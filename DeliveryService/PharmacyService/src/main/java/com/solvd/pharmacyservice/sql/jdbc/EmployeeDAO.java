package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Employee;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

public class EmployeeDAO implements IEmployeeDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE employee SET first_name = (?), last_name = (?), employee_number = (?), " +
                "employee_type_id = (?) WHERE employee_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmployeeNumber());
            ps.setInt(4, employee.getEmployeeTypeId());
            ps.setInt(5, employee.getEmployeeId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public Employee createEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO employee (employee_id, first_name, last_name, employee_number, employee_type_id)" +
                " VALUES((?), (?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, employee.getEmployeeId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getEmployeeNumber());
            ps.setInt(5, employee.getEmployeeTypeId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }

        return employee;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM employee WHERE employee_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Employee> resultList = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    Employee employee = new Employee();
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setEmployeeNumber(rs.getString("employee_number"));
                    employee.setEmployeeTypeId(rs.getInt("employee_type_id"));
                    resultList.add(employee);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try{
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return resultList;
    }

    @Override
    public Employee getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Employee employee = new Employee();
        String query = "SELECT * FROM employee WHERE employee_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setEmployeeNumber(rs.getString("employee_number"));
                    employee.setEmployeeTypeId(rs.getInt("employee_type_id"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try{
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return employee;
    }
}
