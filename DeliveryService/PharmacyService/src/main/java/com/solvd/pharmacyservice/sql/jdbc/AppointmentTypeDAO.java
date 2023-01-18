package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.AppointmentType;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AppointmentTypeDAO implements IAppointmentTypeDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public AppointmentType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        AppointmentType appointmentType = new AppointmentType();
        String query = "SELECT * FROM appointment_type WHERE appointment_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    appointmentType.setAppointmentTypeId(rs.getInt("appointment_type_id"));
                    appointmentType.setAppointmentType(rs.getString("appointment_type"));
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
        return appointmentType;
    }

    @Override
    public void updateEntity(AppointmentType appointmentType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE appointment_type SET appointment_type = (?) WHERE appointment_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, appointmentType.getAppointmentType());
            ps.setInt(2, appointmentType.getAppointmentTypeId());
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
    public AppointmentType createEntity(AppointmentType appointmentType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO appointment_type (appointment_type_id, appointment_type) VALUES((?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, appointmentType.getAppointmentTypeId());
            ps.setString(2, appointmentType.getAppointmentType());
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

        return appointmentType;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM appointment_type WHERE appointment_type_id = (?)";
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
    public List<AppointmentType> getAll() {
        Connection connection = connectionPool.getConnection();
        List<AppointmentType> resultList = new ArrayList<>();
        String query = "SELECT * FROM appointment_type";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    AppointmentType appointmentType = new AppointmentType();
                    appointmentType.setAppointmentTypeId(rs.getInt("appointment_type_id"));
                    appointmentType.setAppointmentType(rs.getString("appointment_type"));
                    resultList.add(appointmentType);
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
}
