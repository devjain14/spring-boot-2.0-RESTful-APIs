package com.example.demo.model;

//import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("category")
    private String category;
}
