package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@Table(name = "schedules")
public class Schedule {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String scheduleName;
     private String treName;
     @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
     private LocalDateTime DateTime;
}
