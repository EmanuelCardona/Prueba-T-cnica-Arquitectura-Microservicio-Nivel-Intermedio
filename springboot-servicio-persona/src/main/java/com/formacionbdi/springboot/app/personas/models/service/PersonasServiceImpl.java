package com.formacionbdi.springboot.app.personas.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.personas.models.dao.PersonasDao;
import com.formacionbdi.springboot.app.personas.models.entity.Personas;

@Service
public class PersonasServiceImpl implements IPersonasService{

	@Autowired
	private PersonasDao personasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Personas> findAll() {
		return (List<Personas>) personasDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Personas findById(Long id) {
		return personasDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Personas save(Personas personas) {
		return personasDao.save(personas);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personasDao.deleteById(id);
	}

}
