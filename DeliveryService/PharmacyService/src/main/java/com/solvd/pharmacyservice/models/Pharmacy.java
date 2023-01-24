package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "pharmacy")
@XmlType(propOrder = {"customerList", "employeeTypeList", "employeeList", "appointmentTypeList", "examinationTypeList",
"paymentTypeList", "recipeList", "categoryList", "inventoryList", "examinationList"})
public class Pharmacy {
    private List<Customer> customerList;
    private List<EmployeeType> employeeTypeList;
    private List<Employee> employeeList;
    private List<AppointmentType> appointmentTypeList;
    private List<ExaminationType> examinationTypeList;
    private List<PaymentType> paymentTypeList;
    private List<Recipe> recipeList;
    private List<Category> categoryList;
    private List<Inventory> inventoryList;
    private List<Examination> examinationList;

    public Pharmacy() {

    }

    public Pharmacy(List<Customer> customerList, List<EmployeeType> employeeTypeList, List<Employee> employeeList,
                    List<AppointmentType> appointmentTypeList, List<ExaminationType> examinationTypeList,
                    List<PaymentType> paymentTypeList, List<Recipe> recipeList, List<Category> categoryList,
                    List<Inventory> inventoryList, List<Examination> examinationList) {

        this.customerList = customerList;
        this.employeeTypeList = employeeTypeList;
        this.employeeList = employeeList;
        this.appointmentTypeList = appointmentTypeList;
        this.examinationTypeList = examinationTypeList;
        this.paymentTypeList = paymentTypeList;
        this.recipeList = recipeList;
        this.categoryList = categoryList;
        this.inventoryList = inventoryList;
        this.examinationList = examinationList;
    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    @XmlElementWrapper(name = "customers")
    @XmlElement (name = "customer", type = Customer.class)
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<EmployeeType> getEmployeeTypeList() {
        return this.employeeTypeList;
    }

    @XmlElementWrapper(name = "employeeTypes")
    @XmlElement (name = "employeeType", type = EmployeeType.class)
    public void setEmployeeTypeList(List<EmployeeType> employeeTypeList) {
        this.employeeTypeList = employeeTypeList;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    @XmlElementWrapper(name = "employees")
    @XmlElement (name = "employee", type = Employee.class)
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<AppointmentType> getAppointmentTypeList() {
        return this.appointmentTypeList;
    }

    @XmlElementWrapper(name = "appointmentTypes")
    @XmlElement (name = "appointmentType", type = AppointmentType.class)
    public void setAppointmentTypeList(List<AppointmentType> appointmentTypeList) {
        this.appointmentTypeList = appointmentTypeList;
    }

    public List<ExaminationType> getExaminationTypeList() {
        return this.examinationTypeList;
    }

    @XmlElementWrapper(name = "examinationTypes")
    @XmlElement (name = "examinationType", type = ExaminationType.class)
    public void setExaminationTypeList(List<ExaminationType> examinationTypeList) {
        this.examinationTypeList = examinationTypeList;
    }

    public List<PaymentType> getPaymentTypeList() {
        return this.paymentTypeList;
    }

    @XmlElementWrapper(name = "paymentTypes")
    @XmlElement (name = "paymentType", type = PaymentType.class)
    public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public List<Recipe> getRecipeList() {
        return this.recipeList;
    }

    @XmlElementWrapper(name = "recipes")
    @XmlElement (name = "recipe", type = Recipe.class)
    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public List<Category> getCategoryList() {
        return this.categoryList;
    }

    @XmlElementWrapper(name = "categories")
    @XmlElement (name = "category", type = Category.class)
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Inventory> getInventoryList() {
        return this.inventoryList;
    }

    @XmlElementWrapper(name = "inventories")
    @XmlElement (name = "inventory", type = Inventory.class)
    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Examination> getExaminationList() {
        return this.examinationList;
    }

    @XmlElementWrapper(name = "examinations")
    @XmlElement (name = "examination", type = Examination.class)
    public void setExaminationList(List<Examination> examinationList) {
        this.examinationList = examinationList;
    }

    @Override
    public String toString() {
        return "Customer List = " + customerList +
                "\nEmployee Type List = " + employeeTypeList +
                "\nEmployee List=" + employeeList +
                "\nAppointment Type List = " + appointmentTypeList +
                "\nExamination Type List = " + examinationTypeList +
                "\nPayment Type List = " + paymentTypeList +
                "\nRecipe List = " + recipeList +
                "\nCategory List = " + categoryList +
                "\nInventory List = " + inventoryList +
                "\nExamination List = " + examinationList;
    }
}
