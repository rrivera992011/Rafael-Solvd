package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Appointment;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AppointmentDAO implements IAppointmentDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();



    @Override
    public Appointment getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Appointment appointment = new Appointment();
        String query = "SELECT * FROM appointment WHERE appointment_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    appointment.setAppointmentId(rs.getInt("appointment_id"));
                    appointment.setAppointmentDate(rs.getDate("appointment_date"));
                    appointment.setCustomerId(rs.getInt("customer_id"));
                    appointment.setEmployeeId(rs.getInt("employee_id"));
                    appointment.setAppointmentTypeId(rs.getInt("appointment_type_id"));
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
        return appointment;
    }

    @Override
    public void updateEntity(Appointment appointment) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE appointment SET appointment_date = (?), customer_id = (?), employee_id = (?), " +
                "appointment_type_id = (?) WHERE appointment_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setDate(1, appointment.getAppointmentDate());
            ps.setInt(2, appointment.getCustomerId());
            ps.setInt(3, appointment.getEmployeeId());
            ps.setInt(4, appointment.getAppointmentTypeId());
            ps.setInt(5, appointment.getAppointmentId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public Appointment createEntity(Appointment appointment) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO appointment (appointment_id, appointment_date, customer_id, employee_id, " +
                "appointment_type_id) VALUES((?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, appointment.getAppointmentId());
            ps.setDate(2, appointment.getAppointmentDate());
            ps.setInt(3, appointment.getCustomerId());
            ps.setInt(4, appointment.getEmployeeId());
            ps.setInt(5, appointment.getAppointmentTypeId());
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

        return appointment;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM appointment WHERE appointment_id = (?)";
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
    public List<Appointment> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Appointment> resultList = new ArrayList<>();
        String query = "SELECT * FROM appointment";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    Appointment appointment = new Appointment();
                    appointment.setAppointmentId(rs.getInt("appointment_id"));
                    appointment.setAppointmentDate(rs.getDate("appointment_date"));
                    appointment.setCustomerId(rs.getInt("customer_id"));
                    appointment.setEmployeeId(rs.getInt("employee_id"));
                    appointment.setAppointmentTypeId(rs.getInt("appointment_type_id"));
                    resultList.add(appointment);
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
    public Appointment getAppointmentByCustomerId(int customerId) {
        Connection connection = connectionPool.getConnection();
        Appointment appointment = new Appointment();
        String query = "SELECT * FROM appointment WHERE customer_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, customerId);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    appointment.setAppointmentId(rs.getInt("appointment_id"));
                    appointment.setAppointmentDate(rs.getDate("appointment_date"));
                    appointment.setCustomerId(rs.getInt("customer_id"));
                    appointment.setEmployeeId(rs.getInt("employee_id"));
                    appointment.setAppointmentTypeId(rs.getInt("appointment_type_id"));
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
        return appointment;
    }


}
