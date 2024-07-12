package com.example.productservicemorningbatch.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    @Id
//    private long id; --> Moved to base class
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;

}
