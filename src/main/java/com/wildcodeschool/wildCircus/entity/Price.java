package com.wildcodeschool.wildCircus.entity;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer cost;

    @ManyToOne
    @JoinColumn(name = "timerange_id")
    private Timerange timerange;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
