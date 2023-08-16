package com.example.demo.test;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goods {
    private String name;

    private double cost;

    public Goods(){

    }
    public Goods (String name,double cost)
    {
        this.cost=cost;
        this.name=name;
    }

}
