package pinz120.IcePalace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pinz120.IcePalace.model.Schedule;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
