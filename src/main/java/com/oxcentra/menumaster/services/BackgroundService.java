package com.oxcentra.menumaster.services;

import com.oxcentra.menumaster.dto.BackgroundDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BackgroundService {
    BackgroundDto getBackgroundByBusinessId(Integer id);

    Boolean updateBackgroundByBusinessId(BackgroundDto backgroundDto);

    Boolean removeBackgroundByBusinessId(Integer id);

    BackgroundDto getBackgroundByBranchId(Integer id);

    Boolean updateBackgroundByBranchId(BackgroundDto backgroundDto);

    Boolean removeBackgroundByBranchId(Integer id);
}
