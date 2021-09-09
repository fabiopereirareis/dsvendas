package com.devesuperior.dsvendas.dto;

import com.devesuperior.dsvendas.entities.Seller;

import java.io.Serializable;

public class SellerDTO implements Serializable {

    private Long id;
    private String name;

//    private List<Sale> sales = new ArrayList<>();

    public SellerDTO() {
    }

    public SellerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SellerDTO(Seller seller) {
        id = seller.getId();
        name = seller.getName();
    }

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

//    public List<Sale> getSales() {
//        return sales;
//    }
}
