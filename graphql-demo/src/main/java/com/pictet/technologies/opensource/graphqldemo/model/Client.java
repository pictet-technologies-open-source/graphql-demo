package com.pictet.technologies.opensource.graphqldemo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    Long id;

    String name;
}
