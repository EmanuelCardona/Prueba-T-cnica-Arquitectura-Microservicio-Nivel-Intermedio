package com.formacionbdi.springboot.app.personas.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.personas.models.entity.Personas;

public interface IPersonasService {

	public List<Personas> findAll();
	public Personas findById(Long id);
	
	public Personas save(Personas Personas);
	
	public void deleteById(Long id);
}
