package ru.ergakov.gb.constructiondocapp.model;

import jakarta.persistence.*;
import lombok.Data;


/**
 * Модель акта
 */
@Data
@Entity
@Table(name = "acts")
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "month", nullable = false)
    private String month;
    @Column(name = "section", nullable = false)
    private String section;
    @Column(name = "price")
    private Double price;
    @Column(name = "status", nullable = false)
    private String status;

}
