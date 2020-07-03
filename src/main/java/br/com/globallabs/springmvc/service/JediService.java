package br.com.globallabs.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.globallabs.springmvc.exception.JediNotFoundException;
import br.com.globallabs.springmvc.model.Jedi;
import br.com.globallabs.springmvc.repository.JediRepository;

@Service
public class JediService {

	@Autowired
	private JediRepository jediRepository;
	
	public Jedi save(Jedi jedi) {
		return jediRepository.save(jedi);
	}

	public List<Jedi> findAll() {
		return jediRepository.findAll();
	}

	public Jedi findById(Long id) {
		Optional<Jedi> jedi = jediRepository.findById(id);
		if(jedi.isPresent()) {
			return jedi.get();
		}else {
			throw new JediNotFoundException();
		}
		
	}

	public void delete(Long id) {
		final Jedi jedi = findById(id);
		jediRepository.delete(jedi);
	}

	public List<Jedi> findByNameContainingIgnoreCase(String name) {

		return jediRepository.findByNameContainingIgnoreCase(name);
	}

	public Jedi updateJedi(Long id, Jedi novoJedi) {
		Jedi jedi = findById(id);
		jedi.setName(novoJedi.getName());
		jedi.setLastName(novoJedi.getLastName());
				
		return jediRepository.save(jedi);
	}
}
