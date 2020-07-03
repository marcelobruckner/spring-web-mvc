package br.com.globallabs.springmvc.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.globallabs.springmvc.exception.JediNotFoundException;
import br.com.globallabs.springmvc.model.Jedi;
import br.com.globallabs.springmvc.service.JediService;

@RestController
public class JediResource {

	@Autowired
	private JediService jediService;
	
	@GetMapping("/api/jedi")
	public List<Jedi> getAllJedi(){
		return jediService.findAll();
	}
	
	@GetMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id){
		try {
			Jedi jedi = jediService.findById(id);
			return ResponseEntity.ok(jedi);
		} catch (JediNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/api/jedi")
	public ResponseEntity<?> createJedi(@Valid @RequestBody Jedi jedi) {
		
		try {
			jedi = jediService.save(jedi);
			return ResponseEntity.status(HttpStatus.CREATED).body(jedi);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/api/jedi/{id}")
	public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id,
			@Valid @RequestBody Jedi novoJedi){
		
		try {
			Jedi jediAtualizado = jediService.updateJedi(id, novoJedi);
			return ResponseEntity.ok(jediAtualizado);
		} catch (JediNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
}
