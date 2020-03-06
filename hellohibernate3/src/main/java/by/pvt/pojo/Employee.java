package by.pvt.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity

@SequenceGenerator(sequenceName = "employee_seq", name = "employeeGenerator")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeGenerator")
    private Long id;

    private String name;

    private Date startDate;

    private int employeeNumber;

    private Double salary;

    @OneToOne
    private Person person;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetails employeeDetails;

    @ManyToOne
    private Department department;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;

    public Employee() {
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNumber == employee.employeeNumber &&
                id.equals(employee.id) &&
                name.equals(employee.name) &&
                startDate.equals(employee.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, employeeNumber);
    }


}
