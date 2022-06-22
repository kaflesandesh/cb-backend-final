package cz.mendelu.cb.service;

import cz.mendelu.cb.model.OfferModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OfferService {
    List<OfferModel> findAll();
    Optional<OfferModel> findById(Long id);
    ResponseEntity<String> save(OfferModel offer);
    ResponseEntity<String> update(Long id, OfferModel offer);
    ResponseEntity<String> delete(Long id);
    List<OfferModel> findAllActive();
    List<OfferModel> findByEmployee(Long id);
}
