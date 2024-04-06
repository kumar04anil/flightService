package com.aks.flightService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FARE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FareEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String currency;
    private Double fare;
}
