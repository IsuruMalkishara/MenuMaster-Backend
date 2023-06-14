package com.oxcentra.menumaster.controller;

import com.oxcentra.menumaster.dto.BackgroundDto;
import com.oxcentra.menumaster.model.Branch;
import com.oxcentra.menumaster.repository.BusinessRepository;
import com.oxcentra.menumaster.services.BackgroundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class BackgroundController {
    @Autowired
    private BackgroundService backgroundService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/background/{id}")
    @ResponseBody
    public BackgroundDto getBackgroundByBusinessId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return backgroundService.getBackgroundByBusinessId(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/background/{id}")
    @ResponseBody
    public Boolean updateBackgroundByBusinessId(@RequestBody BackgroundDto backgroundDto){
        log.info(backgroundDto.getBackground());
        return backgroundService.updateBackgroundByBusinessId(backgroundDto);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/background/{id}")
    @ResponseBody
    public Boolean removeBackgroundByBusinessId(@PathVariable Integer id){
        log.info(String.valueOf(id));
        return backgroundService.removeBackgroundByBusinessId(id);
    }
}
