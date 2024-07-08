package team.MediaSoft.CRUDForCustomersDemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Size(max = 30)
    @NotBlank
    private String username;
    private LocalDate registrationDate;
    private LocalDate dateOfBirth;
    private String gender;
    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message = "Not supported format")
    private String email;
    private LocalDate lastDataChangeDate;
    @Min(0)
    private BigDecimal balance;
}
