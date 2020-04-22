package net.sweam.pizza.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author andrew
 */

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String name;

    @Basic
    private int price;

    @Basic
    private int weight;

    @Basic
    private int diameter;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @OneToMany
    private List<Picture> pictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public List<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        getIngredients().add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        getIngredients().remove(ingredient);
    }

    public List<Picture> getPictures() {
        if (pictures == null) {
            pictures = new ArrayList<>();
        }
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public void addPicture(Picture picture) {
        getPictures().add(picture);
    }

    public void removePicture(Picture picture) {
        getPictures().remove(picture);
    }

}