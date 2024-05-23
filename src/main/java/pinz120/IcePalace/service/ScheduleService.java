package pinz120.IcePalace.service;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.Schedule;
import pinz120.IcePalace.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    public Optional<Schedule> findById(Long id){
        return scheduleRepository.findById(id);
    }
    public List<Schedule> findAll(){
        return (List<Schedule>) scheduleRepository.findAll();
    }
    public void createSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }
    public void deleteById(Long id){
        scheduleRepository.deleteById(id);
    }
}
