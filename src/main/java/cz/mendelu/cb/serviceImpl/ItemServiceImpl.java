package cz.mendelu.cb.serviceImpl;

import cz.mendelu.cb.model.ItemModel;
import cz.mendelu.cb.repository.ItemRepository;
import cz.mendelu.cb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository repository;

    @Override
    public List<ItemModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ItemModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> save(ItemModel item) {
        try{
            repository.save(item);
            return ResponseEntity.ok().body("Item Saved Successfully.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to save Item");
        }
    }

    @Override
    public ResponseEntity<String> update(Long id, ItemModel item) {
        Optional<ItemModel> optional = repository.findById(id);
        if (optional.isPresent()) {
            optional.get().setName(item.getName());
            optional.get().setItemCode(item.getItemCode());
            optional.get().setPrice(item.getPrice());
            try {
                repository.save(optional.get());
                return ResponseEntity.ok().body("Item Updated Successfully.");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Failed To Update Item.");
            }
        } else {
            return ResponseEntity.badRequest().body("Item Not Found Or Already Deleted");
        }
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<ItemModel> item = repository.findById(id);
        if(item.isPresent()){
            try{
                repository.deleteById(id);
                return ResponseEntity.ok().body("Item Deleted Successfully.");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Failed To Delete Item.");
            }
        }else{
            return ResponseEntity.badRequest().body("Item Not Found Or Already Deleted.");
        }
    }
}
