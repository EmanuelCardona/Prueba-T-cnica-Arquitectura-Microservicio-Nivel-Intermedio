package com.formacionbdi.springboot.app.personas.controllers;

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

import com.formacionbdi.springboot.app.personas.models.entity.Personas;
import com.formacionbdi.springboot.app.personas.models.service.IPersonasService;

@RestController
public class PersonasController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IPersonasService personasService;
	
	@GetMapping("/listar")
	public List<Personas> listar(){
		return personasService.findAll().stream().map(personas ->{
			personas.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			//personas.setPort(port);
			return personas;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Personas detalle(@PathVariable Long id) {
		Personas personas = personasService.findById(id);
		personas.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		//personas.setPort(port);
		
		/*
		 * try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return personas;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Personas crear(@RequestBody Personas personas) {
		return personasService.save(personas);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Personas editar(@RequestBody Personas personas, @PathVariable Long id) {
		Personas personasDb = personasService.findById(id);
		
		personasDb.setNombre(personas.getNombre());
        personasDb.setEdad(personas.getEdad());
        personasDb.setGenero(personas.getGenero());
        
        return personasService.save(personasDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		personasService.deleteById(id);
	}
	

}
