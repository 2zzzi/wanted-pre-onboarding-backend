package wanted.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGetResponse {
    private Long empId;
    private String companyName;
    private String companyNation;
    private String companyRegion;
    private String empPos;
    private String empReward;
    private String technology;
}
