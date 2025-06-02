package com.maracaEduca.maracaEduca.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "schools")

public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String district;
    private String phone;
    private String email;
    private double latitude;
    private double longitude;
    private String principalName;
    private int numberOfStudents;

}