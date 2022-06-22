package cz.mendelu.cb.controller;

import cz.mendelu.cb.model.EmployeeModel;
import cz.mendelu.cb.service.EmployeeService;
import cz.mendelu.cb.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE)
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/employee/findAll")
    public List<EmployeeModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/employee/findById/{id}")
    public Optional<EmployeeModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/employee/save")
    public ResponseEntity<String> save(@RequestBody EmployeeModel employee){
        return service.save(employee);
    }

    @PutMapping("/employee/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody EmployeeModel employee){
        return service.update(id,employee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
