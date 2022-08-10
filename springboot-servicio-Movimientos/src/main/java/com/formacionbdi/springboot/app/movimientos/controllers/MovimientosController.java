package com.formacionbdi.springboot.app.movimientos.controllers;

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

import com.formacionbdi.springboot.app.movimientos.models.entity.Movimientos;
import com.formacionbdi.springboot.app.movimientos.models.service.IMovimientosService;

@RestController
public class MovimientosController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IMovimientosService movimientosService;
	
	@GetMapping("/listar")
	public List<Movimientos> listar(){
		return movimientosService.findAll().stream().map(movimientos ->{
			movimientos.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			
			return movimientos;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Movimientos detalle(@PathVariable Long id) {
		Movimientos movimientos= movimientosService.findById(id);
		movimientos.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		
		return movimientos;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Movimientos crear(@RequestBody Movimientos movimientos) {
		return movimientosService.save(movimientos);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Movimientos editar(@RequestBody Movimientos movimientos, @PathVariable Long id) {
		Movimientos movimientosDb = movimientosService.findById(id);
		
		movimientosDb.setMovimiento(movimientos.getMovimiento());
		movimientosDb.setValor(movimientos.getValor());
		movimientosDb.setTipomovimiento(movimientos.getTipomovimiento());
		movimientosDb.setSaldo(movimientos.getSaldo());
		movimientosDb.setFecha(movimientos.getFecha());
		
        
        return movimientosService.save(movimientosDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		movimientosService.deleteById(id);
	}
	

}
