package br.com.globallabs.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Jedi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message = "Nome deve ser preenchido.")
    @Size(min = 3, max = 20, message = "Nome deve ter entre 3 e 20 caracteres.")
    private String name;
    
    @NotBlank(message = "Sobrenome deve ser preenchido.")
    @Size(max = 20, message = "Sobrenome não deve ter mais de 20 caracteres.")
    private String lastName;

    public Jedi (final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi () {
        
    }

    public String getName () {
        return name;
    }

    public void setName (final String name) {
        this.name = name;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (final String lastName) {
        this.lastName = lastName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
