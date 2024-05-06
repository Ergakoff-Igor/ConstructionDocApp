package ru.ergakov.gb.constructiondocapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


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
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ActStatus actStatus;

    /**
     * Метод конвертации статуса акта в string для шаблонизатора
     *
     * @return строковое значение статуса
     */
    public String actStatusToString() {
        return this.actStatus.toString();
    }
}
