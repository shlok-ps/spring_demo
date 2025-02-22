package com.firstTrial.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String name;
    @Column(nullable = false)
    public String phoneNumber;
}
