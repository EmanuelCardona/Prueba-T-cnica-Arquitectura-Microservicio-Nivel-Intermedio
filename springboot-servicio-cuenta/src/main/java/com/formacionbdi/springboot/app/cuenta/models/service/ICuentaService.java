package com.formacionbdi.springboot.app.cuenta.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.cuenta.models.entity.Cuenta;

public interface ICuentaService {

	public List<Cuenta> findAll();
	public Cuenta findById(Long id);
	
	public Cuenta save(Cuenta Cuenta);
	
	public void deleteById(Long id);
}
