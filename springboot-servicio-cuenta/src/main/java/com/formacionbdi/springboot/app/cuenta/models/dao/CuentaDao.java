package com.formacionbdi.springboot.app.cuenta.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.cuenta.models.entity.Cuenta;

public interface CuentaDao extends CrudRepository<Cuenta, Long>{

}
