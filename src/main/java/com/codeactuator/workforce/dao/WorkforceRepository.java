package com.codeactuator.workforce.dao;

import com.codeactuator.workforce.domain.Workforce;
import org.springframework.data.repository.CrudRepository;

public interface WorkforceRepository extends CrudRepository<Workforce, Integer> {
}
