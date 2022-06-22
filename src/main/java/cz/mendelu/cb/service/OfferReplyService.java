package cz.mendelu.cb.service;

import cz.mendelu.cb.model.OfferReplyModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OfferReplyService {
    List<OfferReplyModel> findAll();
    Optional<OfferReplyModel> findById(Long id);
    ResponseEntity<String> save(OfferReplyModel offerReply);
    ResponseEntity<String> update(Long id, OfferReplyModel offerReply);
    ResponseEntity<String> delete(Long id);
}
