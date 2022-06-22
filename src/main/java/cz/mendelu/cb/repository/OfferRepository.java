package cz.mendelu.cb.repository;

import cz.mendelu.cb.model.OfferModel;
import cz.mendelu.cb.utility.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel,Long> {
    List<OfferModel> findByStatus(StatusEnum active);

    @Query("select m from OfferModel m where m.employeeId=:id")
    List<OfferModel> findByEmployeeId(Long id);
}
