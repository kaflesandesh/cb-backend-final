package cz.mendelu.cb.model;

import cz.mendelu.cb.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class EmployeeModel extends BaseEntity {
    private String name;
    private String address;
    private String designation;
    private String role;
}
