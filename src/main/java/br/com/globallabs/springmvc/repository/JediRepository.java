package br.com.globallabs.springmvc.repository;

import br.com.globallabs.springmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private List<Jedi> allJedi;

    public JediRepository() {
        allJedi = new ArrayList<>();
    }

    public List<Jedi> getAllJedi(){
        return allJedi;
    }

    public void add(Jedi jedi) {
        allJedi.add(jedi);
    }
}
