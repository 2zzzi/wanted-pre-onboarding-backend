package wanted.wantedpreonboardingbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empPos;
    private String empReward;
    private String empContext;
    private String technology;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
}
