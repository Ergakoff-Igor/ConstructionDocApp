package ru.ergakov.gb.constructiondocapp.service;


import ru.ergakov.gb.constructiondocapp.model.Act;
import ru.ergakov.gb.constructiondocapp.model.ActStatus;

import java.util.List;


/**
 * Интерфейс сервисв работы с БД
 */
public interface ActService {
    List<Act> getAllActs();
    Act createAct(Act note);
    Act getActById(Long id);
    void updateAct(Long id, String month, String section, Double price);
    void deleteAct(Long id);
    void updateStatusById(Long id, ActStatus actStatus);
}
