package com.formacionbdi.springboot.app.movimientos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.movimientos.models.dao.MovimientosDao;
import com.formacionbdi.springboot.app.movimientos.models.entity.Movimientos;

@Service
public class MovimientosServiceImpl implements IMovimientosService{

	@Autowired
	private MovimientosDao personasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Movimientos> findAll() {
		return (List<Movimientos>) personasDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Movimientos findById(Long id) {
		return personasDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Movimientos save(Movimientos personas) {
		return personasDao.save(personas);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personasDao.deleteById(id);
	}

}
