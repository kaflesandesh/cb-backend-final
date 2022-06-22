package cz.mendelu.cb.model;

import cz.mendelu.cb.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class OfferDetails extends BaseEntity {
    private String itemCode;
    private double quantity;
    private double price;
}
