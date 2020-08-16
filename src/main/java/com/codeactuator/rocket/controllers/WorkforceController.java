package com.codeactuator.rocket.controllers;


import com.codeactuator.rocket.dao.WorkforceRepository;
import com.codeactuator.rocket.domain.Workforce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "v1/workforce")
@RefreshScope
public class WorkforceController {

    private Logger logger = LoggerFactory.getLogger(WorkforceController.class.getName());

    @Autowired
    private WorkforceRepository workforceRepository;

    @GetMapping(value = "/ping")
    public String ping(){
        return "OK";
    }

    @GetMapping
    public List<Workforce> findAll(){
        logger.debug("findAll");
        List<Workforce> workforces = new ArrayList<>();
        workforceRepository.findAll()
                .forEach(rocket -> workforces.add(rocket));

        logger.debug("findAll", workforces.stream().findFirst().get().toString());
        return workforces;
    }

    @GetMapping("/{id}")
    public Workforce findById(@PathVariable("id") Integer id){
        logger.debug("findById");
        Optional<Workforce> rocket = workforceRepository.findById(id);
        logger.debug("findById", rocket.get().toString());
        return rocket.get();
    }
}
