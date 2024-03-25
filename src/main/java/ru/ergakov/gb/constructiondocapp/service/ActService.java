package ru.ergakov.gb.constructiondocapp.service;


import ru.ergakov.gb.constructiondocapp.model.Act;

import java.util.List;


/**
 * Интерфейс сервисв работы с БД
 */
public interface ActService {
    List<Act> getAllActs();
    Act createAct(Act note);
    Act getActById(Long id);
    Act updateAct(Act act);
    void deleteAct(Long id);
}
