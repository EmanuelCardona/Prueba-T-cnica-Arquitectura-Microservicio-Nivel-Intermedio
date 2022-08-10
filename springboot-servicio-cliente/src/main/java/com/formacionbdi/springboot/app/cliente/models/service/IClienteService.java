package com.formacionbdi.springboot.app.cliente.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.cliente.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long id);
}
