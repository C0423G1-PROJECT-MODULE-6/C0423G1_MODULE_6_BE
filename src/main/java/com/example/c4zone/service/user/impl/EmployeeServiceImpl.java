package com.example.c4zone.service.user.impl;
import com.example.c4zone.dto.user.employee.IEmployeeDto;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.repository.user.IEmployeeRepository;
import com.example.c4zone.service.user.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<AppUser> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<IEmployeeDto> findAllEmployeeBy(Pageable pageable, String searchJob, String searchName, String searchPhone) {
        return employeeRepository.findAllEmployee(pageable, searchJob, searchName, searchPhone);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public AppUser getEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id);
    }



    @Override
    public String getNextCode() {

        String code = employeeRepository.getLastCodeEmployee();
        if (code == null) {
            return "NV001";
        }
        int currentNumber = Integer.parseInt(code.substring(2));
        currentNumber++;
        return "NV" + String.format("%03d", currentNumber);

    }

    @Override
    public void createEmployee(AppUser user) {
        employeeRepository.save(user);
    }

    @Override
    public void updateEmployee(AppUser employee, Long id) {
        employeeRepository.updateEmployee(employee, id);
    }

    @Override
    public void editUser(AppUser user) {
        employeeRepository.save(user);
    }
}
