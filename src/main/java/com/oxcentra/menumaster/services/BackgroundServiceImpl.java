package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.dto.BackgroundDto;
import com.oxcentra.menumaster.model.Business;
import com.oxcentra.menumaster.repository.BusinessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class BackgroundServiceImpl implements BackgroundService{
    @Autowired
    private BusinessRepository businessRepository;

    @Override
    public BackgroundDto getBackgroundByBusinessId(Integer id) {
        BackgroundDto backgroundDto=new BackgroundDto();
        Optional<Business> business;
        business=businessRepository.findById(id);
        backgroundDto.setBackground(business.get().getBackground());
        backgroundDto.setId(id);
        log.info(String.valueOf(backgroundDto));
        return backgroundDto;
    }

    @Override
    public Boolean updateBackgroundByBusinessId(BackgroundDto backgroundDto) {

        Optional<Business> optionalBusiness = businessRepository.findById(backgroundDto.getId());
        Business business = optionalBusiness.orElse(null);
        business.setBackground(backgroundDto.getBackground());
        log.info("saved business "+business);
        businessRepository.save(business);
        return true;
    }

    @Override
    public Boolean removeBackgroundByBusinessId(Integer id) {
        Optional<Business> optionalBusiness = businessRepository.findById(id);
        Business business = optionalBusiness.orElse(null);
        business.setBackground(null);
        log.info("removed background "+business);
        businessRepository.save(business);
        return true;
    }
}
