package com.example.model.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String startDate;
    private String endDate;
    private double deposit;

    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employees;

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customers;

    @ManyToOne()
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facilities;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    public Contract() {
    }

    public Contract(int id, String startDate, String endDate, double deposit, Employee employees, Customer customers, Facility facilities, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employees = employees;
        this.customers = customers;
        this.facilities = facilities;
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Facility getFacilities() {
        return facilities;
    }

    public void setFacilities(Facility facilities) {
        this.facilities = facilities;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
