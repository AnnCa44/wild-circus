package com.wildcodeschool.wildCircus.entity;

import javax.persistence.*;

@Entity
@Table(name = "timerange")
public class Timerange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String label;

    public Timerange() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
