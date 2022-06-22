package cz.mendelu.cb.serviceImpl;

import cz.mendelu.cb.model.OfferReplyModel;
import cz.mendelu.cb.repository.OfferReplyRepository;
import cz.mendelu.cb.service.OfferReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferReplyServiceImpl implements OfferReplyService {
    @Autowired
    OfferReplyRepository repository;

    @Override
    public List<OfferReplyModel> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OfferReplyModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> save(OfferReplyModel offerReply) {
        try{
            repository.save(offerReply);
            return ResponseEntity.ok().body("Offer replied Successfully.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to reply Offer");
        }
    }
    @Override
    public ResponseEntity<String> update(Long id, OfferReplyModel offerReply) {
        Optional<OfferReplyModel> optional = repository.findById(id);
        if (optional.isPresent()) {
            optional.get().setReply(offerReply.getReply());
            optional.get().setOfferId(offerReply.getOfferId());
            optional.get().setCreatedAt(offerReply.getCreatedAt());
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
        Optional<OfferReplyModel> offer = repository.findById(id);
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
}
