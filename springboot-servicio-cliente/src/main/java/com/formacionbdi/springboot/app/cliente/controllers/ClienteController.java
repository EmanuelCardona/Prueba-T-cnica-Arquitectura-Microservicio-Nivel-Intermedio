package com.formacionbdi.springboot.app.cliente.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.cliente.models.entity.Cliente;
import com.formacionbdi.springboot.app.cliente.models.service.IClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return clienteService.findAll().stream().map(cliente ->{
			cliente.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			
			return cliente;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Cliente detalle(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);
		cliente.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		
		return cliente;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crear(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente editar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteDb = clienteService.findById(id);
		
		clienteDb.setContraseña(cliente.getContraseña());
		clienteDb.setEstado(cliente.getEstado());
        
        return clienteService.save(clienteDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
	

}
