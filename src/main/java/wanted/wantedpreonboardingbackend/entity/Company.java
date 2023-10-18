package wanted.wantedpreonboardingbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Company {
    @Id
    private Long companyId;
    private String companyName;
    private String companyNation;
    private String companyRegion;
}
