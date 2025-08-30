package ca.cloudace.backend.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "employee_firstname")
    private String employeeFirstName;

    @Column(name = "employee_lastname")
    private String employeeLastName;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_phone")
    private String employeePhone;

    @Column(name = "employee_hiredate")
    private Date employeeHireDate;

    @Column(name = "employee_title")
    private String employeeTitle;

    @Column(name = "employee_salary")
    private String employeeSalary;

    @Column(name = "department_id")
    private int departmentId;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeFirstName, String employeeLastName, String employeeEmail, String employeePhone, Date employeeHireDate, String employeeTitle, String employeeSalary, int departmentId) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeHireDate = employeeHireDate;
        this.employeeTitle = employeeTitle;
        this.employeeSalary = employeeSalary;
        this.departmentId = departmentId;
    }

    // Getters and Setters

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

}
