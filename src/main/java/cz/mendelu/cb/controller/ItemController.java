package cz.mendelu.cb.controller;

import cz.mendelu.cb.model.ItemModel;
import cz.mendelu.cb.service.ItemService;
import cz.mendelu.cb.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constants.BASE)
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/item/findAll")
    public List<ItemModel> findAll(){
        return service.findAll();
    }

    @GetMapping("/item/findById/{id}")
    public Optional<ItemModel> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/item/save")
    public ResponseEntity<String> save(@RequestBody ItemModel item){
        return service.save(item);
    }

    @PutMapping("/item/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ItemModel item){
        return service.update(id,item);
    }

    @DeleteMapping("/item/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.delete(id);
    }


}
