package wanted.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {
    private String empPos;
    private String empReward;
    private String empContext;
    private String technology;
}
