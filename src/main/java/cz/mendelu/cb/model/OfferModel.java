package cz.mendelu.cb.model;

import cz.mendelu.cb.model.base.BaseEntity;
import cz.mendelu.cb.utility.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class OfferModel extends BaseEntity {
    private String offerName;
    private Date offerStartDate;
    private Date offerEndDate;
    private double price;
    private Long employeeId;
    private StatusEnum status= StatusEnum.ACTIVE;
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="offer_model_id")
    private List<OfferDetails> offerDetails;
}
