package cz.mendelu.cb.controller;

import cz.mendelu.cb.model.OfferModel;
import cz.mendelu.cb.service.OfferService;
import cz.mendelu.cb.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE)
public class OfferController {

    @Autowired
    OfferService service;

    @GetMapping("/offer/findAll")
    public List<OfferModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/offer/findById/{id}")
    public Optional<OfferModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/offer/save")
    public ResponseEntity<String> save(@RequestBody OfferModel offer){
        return service.save(offer);
    }

    @PutMapping("/offer/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody OfferModel offer){
        return service.update(id,offer);
    }

    @DeleteMapping("/offer/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.delete(id);
    }

    @GetMapping("/offer/findAllActiveOffers")
    public List<OfferModel> findAllActive(){
        return service.findAllActive();
    }

    @GetMapping("/offer/findByEmployeeId/{employeeId}")
    public List<OfferModel> findByEmployee(@PathVariable Long employeeId){
        return service.findByEmployee(employeeId);
    }
}
