package cz.mendelu.cb.controller;

import cz.mendelu.cb.model.OfferReplyModel;
import cz.mendelu.cb.service.OfferReplyService;
import cz.mendelu.cb.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE)
public class OfferReplyController {

    @Autowired
    OfferReplyService service;

    @GetMapping("/offerReply/findAll")
    public List<OfferReplyModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/offerReply/findById/{id}")
    public Optional<OfferReplyModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/offerReply/save")
    public ResponseEntity<String> save(@RequestBody OfferReplyModel offer){
        return service.save(offer);
    }

    @PutMapping("/offerReply/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody OfferReplyModel offer){
        return service.update(id,offer);
    }

    @DeleteMapping("/offerReply/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.delete(id);
    }

}
