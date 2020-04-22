package net.sweam.pizza.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author andrew
 */

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private char id;

    @Basic
    private String name;

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}