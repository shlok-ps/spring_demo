package com.firstTrial.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String name;

}
