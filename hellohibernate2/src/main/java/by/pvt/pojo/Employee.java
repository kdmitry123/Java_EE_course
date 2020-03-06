package by.pvt.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date startDate;

    private int employeeNumber;

    private Double salary;

    @OneToOne
    private Person person;

    @OneToOne
    private EmployeeDetails employeeDetails;

    @ManyToOne
    private Depatment depatment;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

}