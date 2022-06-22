package cz.mendelu.cb.model;

import com.sun.istack.NotNull;
import cz.mendelu.cb.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class ItemModel extends BaseEntity {
    @NotNull
    private String itemCode;
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private double quantity;
}
