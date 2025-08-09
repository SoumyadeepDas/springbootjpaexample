package edu.soumyadeep.springbootjpaexample.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
@NamedQuery(query = "SELECT e FROM Employee e order by e.name", name = "Employee.findAllInAsc")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }


    public void setType(EmployeeType type) {
        this.type = type;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "employee_name", length = 100)
    private String name;

    @Column(name = "employee_ssn", unique = true, length = 20)
    private String ssn;

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private LocalDate dateOfBirth;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
