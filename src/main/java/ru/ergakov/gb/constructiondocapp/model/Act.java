package ru.ergakov.gb.constructiondocapp.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "acts")
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "mounth", nullable = false)
    private String mouth;
//    @Column(name = "section", nullable = false)
    private String section;
    @Column(name = "price")
    private Double price;
//    @Column(name = "status", nullable = false)
    private String status;

}
