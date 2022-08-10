package com.formacionbdi.springboot.app.cliente.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.cliente.models.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
