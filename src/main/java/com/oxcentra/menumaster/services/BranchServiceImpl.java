package com.oxcentra.menumaster.services;

import com.google.zxing.EncodeHintType;
import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.model.Menu;
import com.oxcentra.menumaster.repository.BranchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;



@Slf4j
@Service
public class BranchServiceImpl implements BranchService{
    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private MenuService menuService;

    @Override
    public List<Branch> getBranchByBusinessId(Integer id) {
        List<Branch> branchList=new ArrayList<>();
        branchList=branchRepository.findAll().stream().filter(b->
               id.equals(b.getBusiness())).collect(Collectors.toList());

        return branchList;
    }

    @Override
    public Optional<Branch> getBranchById(Integer id) {
        return branchRepository.findById(id);
    }

    @Override
    public Boolean addBranch(Branch branch) {
        log.info(String.valueOf(branch.getId()));
        log.info(String.valueOf(branch));
        branch.setQrcode(genarateQRCodeByBranchId(branch.getId()));
      log.info(branch.getQrcode());
        branchRepository.save(branch);
        return true;
    }

    private String genarateQRCodeByBranchId(int id) {
        String qrCodeData = "Branch ID: " + id;
        String qrCodeImageString = null;

        try{
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, 200, 200, hints);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            writeToStream(bitMatrix, "PNG", outputStream);

            byte[] qrCodeBytes = outputStream.toByteArray();
            qrCodeImageString = Base64.getEncoder().encodeToString(qrCodeBytes);


    } catch (Exception e) {
        // Handle QR code generation and storage failure
        log.error("Failed to generate and store QR code for branch: " + id, e);
    }

        return qrCodeImageString;
    }

    private void writeToStream(BitMatrix matrix, String format, ByteArrayOutputStream outputStream) throws IOException {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        ImageIO.write(image, format, outputStream);
    }

    @Override
    public Boolean updateBranch(Branch branch) {
        Optional<Branch> branch1;
        branch1=branchRepository.findById(branch.getId());
        branch.setBackground(branch1.get().getBackground());
        branch.setBusiness(branch1.get().getBusiness());
        branch.setStatus(branch1.get().getStatus());
        branch.setQrcode(branch1.get().getQrcode());
        log.info(String.valueOf(branch));
        branchRepository.save(branch);
        return true;
    }

    @Override
    public Boolean deleteBranch(Integer id) {
        log.info("Delete branch id "+id);
        List<Menu> menuList=menuService.getMenusByBranchId(id);

        if(menuList.size()>0){
            Boolean result=menuService.deleteMenuByBranchId(id);
            if(result){
                branchRepository.deleteById(id);
            }
        }else{
            branchRepository.deleteById(id);
        }


        return true;
    }
}
