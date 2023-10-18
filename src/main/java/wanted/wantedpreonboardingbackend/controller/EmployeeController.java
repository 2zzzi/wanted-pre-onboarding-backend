package wanted.wantedpreonboardingbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wanted.wantedpreonboardingbackend.dto.EmployeeCreateRequest;
import wanted.wantedpreonboardingbackend.dto.EmployeeGetResponse;
import wanted.wantedpreonboardingbackend.dto.EmployeeUpdateRequest;
import wanted.wantedpreonboardingbackend.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("")
    public void create(EmployeeCreateRequest employeeCreateRequest){
        employeeService.createEmployee(employeeCreateRequest);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeGetResponse>> getAllList(){
        return ResponseEntity.ok().body(employeeService.makeEmployeeList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, EmployeeUpdateRequest employeeUpdateRequest){
        employeeService.updateEmployee(id, employeeUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
