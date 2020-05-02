package com.codeactuator.workforce.controllers;

import com.codeactuator.workforce.dao.WorkforceRepository;
import com.codeactuator.workforce.domain.Workforce;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "/workforce")
@Timed
public class WorkforceController {

    private Logger logger = LoggerFactory.getLogger(WorkforceController.class.getName());

    @Autowired private WorkforceRepository workforceRepository;

    @GetMapping
    public List<Workforce> findAll(){
        logger.debug("findAll");
        List<Workforce> workforces = new ArrayList<>();
        workforceRepository.findAll()
                .forEach(workforce -> workforces.add(workforce));

        logger.debug("findAll", workforces.stream().findFirst().get().toString());
        return workforces;
    }

    @GetMapping("/{id}")
    public Workforce findById(@PathVariable("id") Integer id){
        logger.debug("findById");
        Optional<Workforce> workforce = workforceRepository.findById(id);
        logger.debug("findById", workforce.get().toString());
        return workforce.get();
    }
}
