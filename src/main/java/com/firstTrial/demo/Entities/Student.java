package com.firstTrial.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String name;
}
