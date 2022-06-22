package cz.mendelu.cb.serviceImpl;

import cz.mendelu.cb.model.OfferModel;
import cz.mendelu.cb.repository.OfferRepository;
import cz.mendelu.cb.service.OfferService;
import cz.mendelu.cb.utility.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferRepository repository;

    @Override
    public List<OfferModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OfferModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> save(OfferModel offer) {
        try{
            repository.save(offer);
            return ResponseEntity.ok().body("Offer Saved Successfully.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to save Offer");
        }
    }

    @Override
    public ResponseEntity<String> update(Long id, OfferModel offer) {
        Optional<OfferModel> optional = repository.findById(id);
        if (optional.isPresent()) {
            optional.get().setStatus(offer.getStatus().equals(StatusEnum.ACTIVE) ? StatusEnum.ACTIVE : StatusEnum.TERMINATED);
            optional.get().setOfferName(offer.getOfferName());
            optional.get().setOfferEndDate(offer.getOfferEndDate());
            optional.get().setOfferStartDate(offer.getOfferStartDate());
            optional.get().setPrice(offer.getPrice());
            optional.get().getOfferDetails().clear();
            optional.get().getOfferDetails().addAll(offer.getOfferDetails());
            try {
                repository.save(optional.get());
                return ResponseEntity.ok().body("Offer Updated Successfully.");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Failed To Update Offer.");
            }
        } else {
            return ResponseEntity.badRequest().body("Offer Not Found Or Already Deleted");
        }
    }
    @Override
    public ResponseEntity<String> delete(Long id) {
        Optional<OfferModel> offer = repository.findById(id);
        if(offer.isPresent()){
            try{
                repository.deleteById(id);
                return ResponseEntity.ok().body("Offer Deleted Successfully.");
            }catch (Exception e){
                return ResponseEntity.badRequest().body("Failed To Delete Offer.");
            }
        }else{
            return ResponseEntity.badRequest().body("Offer Not Found Or Already Deleted.");
        }
    }

    @Override
    public List<OfferModel> findAllActive() {
        return repository.findByStatus(StatusEnum.ACTIVE);
    }

    @Override
    public List<OfferModel> findByEmployee(Long id) {
        return repository.findByEmployeeId(id);
    }
}
