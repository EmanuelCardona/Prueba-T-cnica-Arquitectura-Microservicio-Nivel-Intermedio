package com.formacionbdi.springboot.app.movimientos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.movimientos.models.entity.Movimientos;

public interface MovimientosDao extends CrudRepository<Movimientos, Long>{

}
