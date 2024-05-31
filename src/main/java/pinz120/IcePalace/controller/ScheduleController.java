package pinz120.IcePalace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pinz120.IcePalace.model.Schedule;
import pinz120.IcePalace.service.ScheduleService;

import java.util.List;
import java.util.Optional;

@Controller
public class ScheduleController {
    private final ScheduleService scheduleService;
    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/IndexSchedule")
    public String findAll(Model model){
        List<Schedule> schedules = (List<Schedule>) scheduleService.findAll();
        model.addAttribute("schedules", schedules);
        return "IndexSchedule";
    }

    @GetMapping("/CreateSchedule")
    public String createScheduleForm(Schedule schedule){
        return "CreateSchedule";
    }

    @PostMapping("/CreateSchedule")
    public String createSchedule(Schedule schedule){
        scheduleService.createSchedule(schedule);
        return "redirect:/IndexSchedule";
    }

    @GetMapping("/DeleteSchedule/{id}")
    public String deleteSchedule(@PathVariable("id") Long id){
        scheduleService.deleteById(id);
        return "redirect:/IndexSchedule";
    }

    @GetMapping("/UpdateSchedule/{id}")
    public String updateScheduleForm(@PathVariable("id") Long id, Model model){
        Optional<Schedule> schedule = scheduleService.findById(id);
        model.addAttribute("schedule", schedule);
        return "UpdateSchedule";
    }

    @PostMapping("/UpdateSchedule")
    public String updateSchedule(Schedule schedule){
        scheduleService.createSchedule(schedule);
        return "redirect:/IndexSchedule";
    }
}
