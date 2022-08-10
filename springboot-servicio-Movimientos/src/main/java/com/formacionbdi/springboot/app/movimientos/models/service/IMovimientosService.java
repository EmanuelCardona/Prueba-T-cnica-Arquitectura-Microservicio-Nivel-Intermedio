package com.formacionbdi.springboot.app.movimientos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.movimientos.models.entity.Movimientos;

public interface IMovimientosService {

	public List<Movimientos> findAll();
	public Movimientos findById(Long id);
	
	public Movimientos save(Movimientos Movimientos);
	
	public void deleteById(Long id);
}
