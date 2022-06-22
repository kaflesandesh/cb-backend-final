package cz.mendelu.cb.serviceImpl;

import cz.mendelu.cb.model.EmployeeModel;
import cz.mendelu.cb.repository.EmployeeRepository;
import cz.mendelu.cb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repository;

    @Override
    public List<EmployeeModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<EmployeeModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> save(EmployeeModel employee) {
        try{
            repository.save(employee);
            return ResponseEntity.ok().body("Employee Saved Successfully.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to save Employee");
        }
    }

    @Override
    public ResponseEntity<String> update(Long id, EmployeeModel employee) {
        Optional<EmployeeModel> optional = repository.findById(id);
        if(optional.isPresent()){
            optional.get().setAddress(employee.getAddress());
            optional.get().setDesignation(employee.getDesignation());
            optional.get().setName(employee.getName());
            try{
                repository.save(optional.get());
                return ResponseEntity.ok().body("Employee Updated Successfully.");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Failed To Update Employee.");
            }
        }else{
            return ResponseEntity.badRequest().body("Employee Not Found Or Already Deleted");
        }
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<EmployeeModel> employee = repository.findById(id);
        if(employee.isPresent()){
            try{
                repository.deleteById(id);
                return ResponseEntity.ok().body("Employee Deleted Successfully.");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Failed To Delete Employee.");
            }
        }else{
            return ResponseEntity.badRequest().body("Employee Not Found Or Already Deleted.");
        }
    }
}
