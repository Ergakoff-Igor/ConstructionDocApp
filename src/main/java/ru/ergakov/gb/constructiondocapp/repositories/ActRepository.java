package ru.ergakov.gb.constructiondocapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ergakov.gb.constructiondocapp.model.Act;

/**
 * Репозиторий для работы с БД
 */
@Repository
public interface ActRepository extends JpaRepository<Act, Long> {

}
