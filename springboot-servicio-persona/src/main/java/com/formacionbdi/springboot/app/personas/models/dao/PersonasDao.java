package com.formacionbdi.springboot.app.personas.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.personas.models.entity.Personas;

public interface PersonasDao extends CrudRepository<Personas, Long>{

}
