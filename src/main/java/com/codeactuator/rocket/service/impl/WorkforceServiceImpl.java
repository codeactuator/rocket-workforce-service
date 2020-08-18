package com.codeactuator.rocket.service.impl;

import com.codeactuator.rocket.dao.WorkforceRepository;
import com.codeactuator.rocket.domain.Workforce;
import com.codeactuator.rocket.dto.WorkforceDTO;
import com.codeactuator.rocket.service.WorkforceService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorkforceServiceImpl implements WorkforceService {

    @Autowired
    private WorkforceRepository workforceRepository;

    @Override
    public Optional<WorkforceDTO> create(WorkforceDTO workforceDTO) {
        Workforce workforce = workforceDTO.marshall();
        workforceRepository.save(workforce);
        workforceDTO.setId(workforce.getId());
        return Optional.of(workforceDTO);
    }

    @Override
    public Optional<WorkforceDTO> update(WorkforceDTO workforceDTO) {
        Workforce workforce = workforceDTO.marshall();
        workforceRepository.save(workforce);
        workforceDTO.setId(workforce.getId());
        return Optional.of(workforceDTO);
    }

    @Override
    public Optional<WorkforceDTO> remove(WorkforceDTO workforceDTO) {
        Workforce workforce = workforceDTO.marshall();
        workforceRepository.delete(workforce);
        workforceDTO.setId(workforce.getId());
        return Optional.of(workforceDTO);
    }

    @Override
    public Optional<WorkforceDTO> removeById(Long workforceId) {
        Workforce workforce = workforceRepository.findById(workforceId).get();
        workforceRepository.deleteById(workforceId);
        WorkforceDTO workforceDTO = new WorkforceDTO();
        workforceDTO.unmarshal(workforce);
        return Optional.of(workforceDTO);
    }

    @Override
    public Optional<WorkforceDTO> findById(Long workforceId) {
        Optional<WorkforceDTO> workforceDTOOptional = workforceRepository.findById(workforceId)
                .map(workforce -> {
                    WorkforceDTO workforceDTO = new WorkforceDTO();
                    workforceDTO.unmarshal(workforce);
                    return workforceDTO;
                });
        return workforceDTOOptional;
    }

    @Override
    public Optional<Collection<WorkforceDTO>> findAll() {
        ArrayList<Workforce> workforces = Lists.newArrayList(workforceRepository.findAll());
        List<WorkforceDTO> workforceDTOList = workforces.stream()
                .map(workforce -> {
                    WorkforceDTO workforceDTO = new WorkforceDTO();
                    workforceDTO.unmarshal(workforce);
                    return workforceDTO;
                })
                .collect(Collectors.toList());
        return Optional.of(workforceDTOList);

    }

    @Override
    public Optional<Collection<WorkforceDTO>> findAll(Long organizationId) {
        ArrayList<Workforce> workforces = Lists.newArrayList(workforceRepository.findAll());
        List<WorkforceDTO> workforceDTOList = workforces.stream()
                .map(workforce -> {
                    WorkforceDTO workforceDTO = new WorkforceDTO();
                    workforceDTO.unmarshal(workforce);
                    return workforceDTO;
                })
                .collect(Collectors.toList());
        return Optional.of(workforceDTOList);
    }
}
