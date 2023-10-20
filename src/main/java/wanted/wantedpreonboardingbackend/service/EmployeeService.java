package wanted.wantedpreonboardingbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wanted.wantedpreonboardingbackend.dto.EmployeeCreateRequest;
import wanted.wantedpreonboardingbackend.dto.EmployeeGetResponse;
import wanted.wantedpreonboardingbackend.dto.EmployeeUpdateRequest;
import wanted.wantedpreonboardingbackend.entity.Company;
import wanted.wantedpreonboardingbackend.entity.Employee;
import wanted.wantedpreonboardingbackend.repository.CompanyRepository;
import wanted.wantedpreonboardingbackend.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    public void createEmployee(EmployeeCreateRequest employeeCreateRequest){
        Company company = companyRepository.findByCompanyId(employeeCreateRequest.getCompanyId()).get();
        Employee employee = Employee.builder()
                .empPos(employeeCreateRequest.getEmpPos())
                .empReward(employeeCreateRequest.getEmpReward())
                .empContext(employeeCreateRequest.getEmpContext())
                .technology(employeeCreateRequest.getTechnology())
                .company(company)
                .build();
        employeeRepository.save(employee);
    }

    public List<EmployeeGetResponse> makeEmployeeList(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeGetResponse> employeeGetResponses = new ArrayList<>();

        for(Employee e: employeeList){

            Company company = e.getCompany();
            EmployeeGetResponse response = EmployeeGetResponse.builder()
                    .empId(e.getEmpId())
                    .companyName(company.getCompanyName())
                    .companyNation(company.getCompanyNation())
                    .companyRegion(company.getCompanyRegion())
                    .empPos(e.getEmpPos())
                    .empReward(e.getEmpReward())
                    .technology(e.getTechnology())
                    .build();

            employeeGetResponses.add(response);
        }

        return employeeGetResponses;
    }
    @Transactional
    public void updateEmployee(Long id, EmployeeUpdateRequest employeeUpdateRequest){
        Employee employee = employeeRepository.findByEmpId(id).get();
        employee.setEmpPos(employeeUpdateRequest.getEmpPos());
        employee.setEmpReward(employeeUpdateRequest.getEmpReward());
        employee.setEmpContext(employeeUpdateRequest.getEmpContext());
        employee.setTechnology(employeeUpdateRequest.getTechnology());
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
