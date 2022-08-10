package com.formacionbdi.springboot.app.cuenta.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.cuenta.models.dao.CuentaDao;
import com.formacionbdi.springboot.app.cuenta.models.entity.Cuenta;

@Service
public class CuentaServiceImpl implements ICuentaService{

	@Autowired
	private CuentaDao cuentaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> findAll() {
		return (List<Cuenta>) cuentaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cuenta findById(Long id) {
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cuenta save(Cuenta cuenta) {
		return cuentaDao.save(cuenta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		cuentaDao.deleteById(id);
	}

}
