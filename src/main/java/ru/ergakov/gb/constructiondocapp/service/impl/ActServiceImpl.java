package ru.ergakov.gb.constructiondocapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ergakov.gb.constructiondocapp.model.Act;
import ru.ergakov.gb.constructiondocapp.model.ActStatus;
import ru.ergakov.gb.constructiondocapp.repositories.ActRepository;
import ru.ergakov.gb.constructiondocapp.service.ActService;

import java.util.List;

/**
 * Сервис заметок для передачи запросов в БД
 */
@Service
@RequiredArgsConstructor
public class ActServiceImpl implements ActService {
    private final ActRepository actRepository;

    /**
     * Метод получения списка всех задач
     *
     * @return список заметок
     */
    @Override
    public List<Act> getAllActs() {
        return actRepository.findAll();
    }

    /**
     * Метод сохранения заметки
     *
     * @param act новая заметка
     * @return сохраненная заметка
     */
    @Override
    public Act createAct(Act act) {
        act.setActStatus(ActStatus.CHECKING_QC);
        return actRepository.save(act);
    }

    /**
     * Метод получения заметки по id
     *
     * @param id id заметки
     * @return искомая заметка
     */
    @Override
    public Act getActById(Long id) {
        return actRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void updateAct(Long id, String month, String section, Double price) {
        Act act = getActById(id);
        if (act != null) {
            act.setMonth(month);
            act.setSection(section);
            act.setPrice(price);
            actRepository.save(act);
        } else {
            throw new RuntimeException("error");
        }
    }

    /**
     * Метод удаления заметки по id
     *
     * @param id id заметки
     */
    @Override
    public void deleteAct(Long id) {
        Act actById = getActById(id);
        actRepository.delete(actById);
    }

    /**
     * Обновить статус акта по ID
     *
     * @param id         уникальный идентификатор задачи
     * @param actStatus новый статус акта
     */
    public void updateStatusById(Long id, ActStatus actStatus) {
        Act actById = getActById(id);
        actById.setActStatus(actStatus);
        actRepository.save(actById);
    }

}
