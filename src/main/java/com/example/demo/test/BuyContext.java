package com.example.demo.test;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuyContext {

    private List<Goods> goods;

    private int count;

    private Double allCount =0.00;
}
