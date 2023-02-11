package kz.networksenergy.calendar.repository;

import kz.networksenergy.calendar.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
