package com.manvidas.billing;

import com.manvidas.core.BaseEntity;
import com.manvidas.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Billing extends BaseEntity {
    private String title;
    private double value;
    private boolean paid;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Billing() {
        super();
    }

    public Billing(String title, double value, boolean paid) {
        this();
        this.title = title;
        this.value = value;
        this.paid = paid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
