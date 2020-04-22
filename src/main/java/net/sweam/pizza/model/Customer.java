package net.sweam.pizza.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author andrew
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;

    @Basic
    private String address;

    @Basic
    private String phone;

    @Basic
    private String name;

    @ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PizzaOrder> pizzaOrders;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PizzaOrder> getPizzaOrders() {
        if (pizzaOrders == null) {
            pizzaOrders = new ArrayList<>();
        }
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

    public void addPizzaOrder(PizzaOrder pizzaOrder) {
        getPizzaOrders().add(pizzaOrder);
    }

    public void removePizzaOrder(PizzaOrder pizzaOrder) {
        getPizzaOrders().remove(pizzaOrder);
    }

}