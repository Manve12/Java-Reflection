package com.manvidas.core;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;

    public BaseEntity() {
        this.id = null;
    }
}
