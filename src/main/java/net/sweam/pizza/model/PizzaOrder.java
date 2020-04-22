package net.sweam.pizza.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author andrew
 */
@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private LocalDate date;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pizza> pizzas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Pizza> getPizzas() {
        if (pizzas == null) {
            pizzas = new ArrayList<>();
        }
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void addPizza(Pizza pizza) {
        getPizzas().add(pizza);
    }

    public void removePizza(Pizza pizza) {
        getPizzas().remove(pizza);
    }

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        getCustomers().add(customer);
        customer.getPizzaOrders().add(this);
    }

    public void removeCustomer(Customer customer) {
        getCustomers().remove(customer);
        customer.getPizzaOrders().remove(this);
    }

}