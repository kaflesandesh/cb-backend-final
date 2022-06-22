package cz.mendelu.cb.service;

import cz.mendelu.cb.model.ItemModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemModel> findAll();
    Optional<ItemModel> findById(Long id);
    ResponseEntity<String> save(ItemModel item);
    ResponseEntity<String> update(Long id, ItemModel item);
    ResponseEntity<String> delete(Long id);
}
