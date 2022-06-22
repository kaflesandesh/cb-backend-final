package cz.mendelu.cb.service;

import cz.mendelu.cb.model.EmployeeModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeModel> findAll();
    Optional<EmployeeModel> findById(Long id);
    ResponseEntity<String> save(EmployeeModel employee);
    ResponseEntity<String> update(Long id, EmployeeModel employee);
    ResponseEntity<String> delete(Long id);
}
