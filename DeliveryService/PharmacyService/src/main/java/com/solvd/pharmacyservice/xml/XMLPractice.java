package com.solvd.pharmacyservice.xml;


import com.solvd.pharmacyservice.models.*;
import org.apache.logging.log4j.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class XMLPractice {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    final static Level MENU_LOG = Level.forName("MENU_LOG", 700);

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<EmployeeType> employeeTypes = new ArrayList<>();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<AppointmentType> appointmentTypes = new ArrayList<>();
    private static ArrayList<ExaminationType> examinationTypes = new ArrayList<>();
    private static ArrayList<PaymentType> paymentTypes = new ArrayList<>();
    private static ArrayList<Recipe> recipes = new ArrayList<>();
    private static ArrayList<Category> categories = new ArrayList<>();
    private static ArrayList<Inventory> inventories = new ArrayList<>();
    private static ArrayList<CustomerOrder> customerOrders = new ArrayList<>();
    private static ArrayList<Prescription> prescriptions = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<Examination> examinations = new ArrayList<>();


    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document = null;

        try{
            builder = documentBuilderFactory.newDocumentBuilder();
            document = builder.parse(new File(System.getProperty("user.dir") + "/src/main/resources/pharmacy.xml"));

            readXML(document, "customer");
            readXML(document, "employeeType");
            readXML(document, "employee");
            readXML(document, "appointmentType");
            readXML(document, "examinationType");
            readXML(document, "paymentType");
            readXML(document, "recipe");
            readXML(document, "category");
            readXML(document, "inventory");
            readXML(document, "customerOrder");
            readXML(document, "prescription");
            readXML(document, "appointment");
            readXML(document, "examination");

        } catch (ParserConfigurationException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (SAXException e) {
            LOGGER.error(e);
        }

        LOGGER.log(MENU_LOG, customers);
        LOGGER.log(MENU_LOG, employeeTypes);
        LOGGER.log(MENU_LOG, employees);
        LOGGER.log(MENU_LOG, appointmentTypes);
        LOGGER.log(MENU_LOG, examinationTypes);
        LOGGER.log(MENU_LOG, paymentTypes);
        LOGGER.log(MENU_LOG, recipes);
        LOGGER.log(MENU_LOG, categories);
        LOGGER.log(MENU_LOG, inventories);
        LOGGER.log(MENU_LOG, customerOrders);
        LOGGER.log(MENU_LOG, prescriptions);
        LOGGER.log(MENU_LOG, appointments);
        LOGGER.log(MENU_LOG, examinations);
    }

    private static void readXML(Document document, String entity){
        NodeList nodeList = null;
        if(document != null){
            nodeList = document.getElementsByTagName(entity);
        }

        int length = 0;

        if(nodeList != null){
            length = nodeList.getLength();
        }

        for(int i = 0; i < length; i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            NamedNodeMap attributes = node.getAttributes();
            switch(entity){
                case "customer":
                    Customer customer = new Customer();
                    customer.setCustomerId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    customer.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
                    customer.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
                    customer.setPhoneNumber(element.getElementsByTagName("phoneNumber").item(0).getTextContent());
                    customer.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
                    customer.setAddress(element.getElementsByTagName("address").item(0).getTextContent());
                    customers.add(customer);
                    break;
                case "employeeType":
                    EmployeeType employeeType = new EmployeeType();
                    employeeType.setEmployeeTypeId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    employeeType.setEmployeeTypeName(element.getElementsByTagName("employeeTypeName").item(0).getTextContent());
                    employeeTypes.add(employeeType);
                    break;
                case "employee":
                    Employee employee = new Employee();
                    employee.setEmployeeId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    employee.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
                    employee.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
                    employee.setEmployeeNumber(element.getElementsByTagName("employeeNumber").item(0).getTextContent());
                    employee.setEmployeeTypeId(Integer.parseInt(element.getElementsByTagName("employeeTypeId").item(0).getTextContent()));
                    employees.add(employee);
                    break;
                case "appointmentType":
                    AppointmentType appointmentType = new AppointmentType();
                    appointmentType.setAppointmentTypeId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    appointmentType.setAppointmentTypeName(element.getElementsByTagName("appointmentTypeName").item(0).getTextContent());
                    appointmentTypes.add(appointmentType);
                    break;
                case "examinationType":
                    ExaminationType examinationType = new ExaminationType();
                    examinationType.setExaminationTypeId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    examinationType.setExaminationTypeName(element.getElementsByTagName("examinationTypeName").item(0).getTextContent());
                    examinationTypes.add(examinationType);
                    break;
                case "paymentType":
                    PaymentType paymentType = new PaymentType();
                    paymentType.setPaymentTypeId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    paymentType.setPaymentTypeName(element.getElementsByTagName("paymentTypeName").item(0).getTextContent());
                    paymentTypes.add(paymentType);
                    break;
                case "recipe":
                    Recipe recipe = new Recipe();
                    recipe.setRecipeId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    recipe.setRecipeSize(Double.parseDouble(element.getElementsByTagName("recipeSize").item(0).getTextContent()));
                    recipes.add(recipe);
                    break;
                case "category":
                    Category category = new Category();
                    category.setCategoryId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    category.setCategoryName(element.getElementsByTagName("categoryName").item(0).getTextContent());
                    categories.add(category);
                    break;
                case "inventory":
                    Inventory inventory = new Inventory();
                    inventory.setInventoryId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    inventory.setMedicineName(element.getElementsByTagName("medicineName").item(0).getTextContent());
                    inventory.setAmountLeft(Integer.parseInt(element.getElementsByTagName("amountLeft").item(0).getTextContent()));
                    inventory.setAmountTaken(Integer.parseInt(element.getElementsByTagName("amountTaken").item(0).getTextContent()));
                    inventory.setCategoryId(Integer.parseInt(element.getElementsByTagName("categoryId").item(0).getTextContent()));
                    inventory.setPriceOfMedicine(Double.parseDouble(element.getElementsByTagName("priceOfMedicine").item(0).getTextContent()));
                    inventories.add(inventory);
                    break;
                case "customerOrder":
                    CustomerOrder customerOrder = new CustomerOrder();
                    customerOrder.setCustomerOrderId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    customerOrder.setOrderTotal(Double.parseDouble(element.getElementsByTagName("orderTotal").item(0).getTextContent()));
                    customerOrder.setOrderDate(Date.valueOf(element.getElementsByTagName("orderDate").item(0).getTextContent()));
                    customerOrder.setPaymentTypeId(Integer.parseInt(element.getElementsByTagName("paymentTypeId").item(0).getTextContent()));
                    customerOrder.setProductId(Integer.parseInt(element.getElementsByTagName("productId").item(0).getTextContent()));
                    customerOrders.add(customerOrder);
                    break;
                case "prescription":
                    Prescription prescription = new Prescription();
                    prescription.setPrescriptionId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    prescription.setRxNumber(element.getElementsByTagName("rxNumber").item(0).getTextContent());
                    prescription.setPriceOfPrescription(Double.parseDouble(element.getElementsByTagName("priceOfPrescription").item(0).getTextContent()));
                    prescription.setAmountOfMedicine(Integer.parseInt(element.getElementsByTagName("amountOfMedicine").item(0).getTextContent()));
                    prescription.setDateFilled(Date.valueOf(element.getElementsByTagName("dateFilled").item(0).getTextContent()));
                    prescription.setCustomerId(Integer.parseInt(element.getElementsByTagName("customerId").item(0).getTextContent()));
                    prescription.setInventoryId(Integer.parseInt(element.getElementsByTagName("inventoryId").item(0).getTextContent()));
                    prescription.setRecipeId(Integer.parseInt(element.getElementsByTagName("recipeId").item(0).getTextContent()));
                    prescriptions.add(prescription);
                    break;
                case "appointment":
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    appointment.setAppointmentDate(Date.valueOf(element.getElementsByTagName("appointmentDate").item(0).getTextContent()));
                    appointment.setCustomerId(Integer.parseInt(element.getElementsByTagName("customerId").item(0).getTextContent()));
                    appointment.setEmployeeId(Integer.parseInt(element.getElementsByTagName("employeeId").item(0).getTextContent()));
                    appointment.setAppointmentTypeId(Integer.parseInt(element.getElementsByTagName("appointmentTypeId").item(0).getTextContent()));
                    appointments.add(appointment);
                    break;
                case "examination":
                    Examination examination = new Examination();
                    examination.setExaminationId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    examination.setExamResult(element.getElementsByTagName("examResult").item(0).getTextContent());
                    examination.setEmployeeId(Integer.parseInt(element.getElementsByTagName("employeeId").item(0).getTextContent()));
                    examination.setCustomerId(Integer.parseInt(element.getElementsByTagName("customerId").item(0).getTextContent()));
                    examination.setExaminationTypeId(Integer.parseInt(element.getElementsByTagName("examinationTypeId").item(0).getTextContent()));
                    examinations.add(examination);
                    break;
            }
        }

    }
}
