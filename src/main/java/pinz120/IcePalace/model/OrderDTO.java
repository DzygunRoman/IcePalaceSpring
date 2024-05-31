package pinz120.IcePalace.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class OrderDTO {
    List<Schedule> scheduleList;
    private String Email;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime DateTime;
}
