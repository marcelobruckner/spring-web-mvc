package br.com.globallabs.springmvc.model;

public class Jedi {

    private String name;
    private String lastName;

    public Jedi(String name, String lastname) {
        this.name = name;
        this.lastName = lastname;
    }

    public Jedi() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
