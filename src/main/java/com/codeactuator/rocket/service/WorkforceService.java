package com.codeactuator.rocket.service;

import com.codeactuator.rocket.dto.WorkforceDTO;

import java.util.Collection;
import java.util.Optional;

public interface WorkforceService {

    Optional<WorkforceDTO> create(WorkforceDTO workforceDTO);
    Optional<WorkforceDTO> update(WorkforceDTO workforceDTO);
    Optional<WorkforceDTO> remove(WorkforceDTO workforceDTO);
    Optional<WorkforceDTO> removeById(Long workforceId);

    Optional<WorkforceDTO> findById(Long workforceId);
    Optional<Collection<WorkforceDTO>> findAll();
    Optional<Collection<WorkforceDTO>> findAll(Long organizationId);
}
