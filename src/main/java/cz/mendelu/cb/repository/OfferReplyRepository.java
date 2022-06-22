package cz.mendelu.cb.repository;

import cz.mendelu.cb.model.OfferReplyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferReplyRepository extends JpaRepository<OfferReplyModel, Long> {

}
