package com.codeactuator.rocket.controllers;


import com.codeactuator.rocket.dto.WorkforceDTO;
import com.codeactuator.rocket.service.WorkforceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping(value = "v1/workforces")
@RefreshScope
public class WorkforceController {

    private Logger logger = LoggerFactory.getLogger(WorkforceController.class.getName());

    @Autowired
    private WorkforceService workforceService;

    @GetMapping(value = "/ping")
    public String ping(){
        return "OK";
    }

    @GetMapping
    public Collection<WorkforceDTO> findAll(){
        return workforceService.findAll()
                .orElseThrow(() -> new EntityNotFoundException("No Workforce found!"));
    }

    @GetMapping("/{id}")
    public WorkforceDTO findById(@PathVariable("id") Long id){
        return workforceService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }


    @PostMapping
    public WorkforceDTO create(@RequestBody WorkforceDTO workforceDTO){
        return workforceService.create(workforceDTO)
                .orElseThrow(() -> new RuntimeException("Workforce could not created: "+workforceDTO));
    }


    @PutMapping
    public WorkforceDTO update(@RequestBody WorkforceDTO workforceDTO){
        return workforceService.update(workforceDTO)
                .orElseThrow(() -> new RuntimeException("Workforce could not updated: "+workforceDTO));
    }

    @DeleteMapping("/{id}")
    public WorkforceDTO delete(@PathVariable("id") Long workforceId){
        return workforceService.removeById(workforceId)
                .orElseThrow(() -> new RuntimeException("Workforce could not deleted: "+workforceId));
    }

}
