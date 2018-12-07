package com.manvidas.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manvidas.billing.Billing;
import com.manvidas.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends BaseEntity {
    @NotNull
    private String username;

    @JsonIgnore
    private String password;

    @OneToMany
    private List<Billing> billings;

    public User() {
        super();
        billings = new ArrayList<>();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Billing> getBillings() {
        return billings;
    }

    public void addBilling(Billing billings) {
        this.billings.add(billings);
    }
}
