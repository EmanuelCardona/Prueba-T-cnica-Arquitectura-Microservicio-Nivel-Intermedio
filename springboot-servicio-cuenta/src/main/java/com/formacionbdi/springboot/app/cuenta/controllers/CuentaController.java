package com.formacionbdi.springboot.app.cuenta.controllers;

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

import com.formacionbdi.springboot.app.cuenta.models.entity.Cuenta;
import com.formacionbdi.springboot.app.cuenta.models.service.ICuentaService;

@RestController
public class CuentaController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private ICuentaService cuentaService;
	
	@GetMapping("/listar")
	public List<Cuenta> listar(){
		return cuentaService.findAll().stream().map(cuenta ->{
			cuenta.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			
			return cuenta;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Cuenta detalle(@PathVariable Long id) {
		Cuenta cuenta = cuentaService.findById(id);
		cuenta.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		
		return cuenta;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuenta crear(@RequestBody Cuenta cuenta) {
		return cuentaService.save(cuenta);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuenta editar(@RequestBody Cuenta cuenta, @PathVariable Long id) {
		Cuenta cuentaDb = cuentaService.findById(id);
		
		cuentaDb.setEstado(cuenta.getEstado());
        cuentaDb.setNumerocuenta(cuenta.getNumerocuenta());
        cuentaDb.setTipocuenta(cuenta.getTipocuenta());
        cuentaDb.setSaldoinicial(cuenta.getSaldoinicial());
        
        return cuentaService.save(cuentaDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		cuentaService.deleteById(id);
	}
	

}
