package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.ExaminationType;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

public class ExaminationTypeDAO implements IExaminationTypeDAO {

    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(ExaminationType examinationType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE examination_type SET examination_type = (?) WHERE examination_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, examinationType.getExaminationType());
            ps.setInt(2, examinationType.getExaminationTypeId());
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
    public ExaminationType createEntity(ExaminationType examinationType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO examination_type (examination_type_id, examination_type) VALUES((?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, examinationType.getExaminationTypeId());
            ps.setString(2, examinationType.getExaminationType());
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
        return examinationType;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM examination_type WHERE examination_type_id = (?)";
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
    public List<ExaminationType> getAll() {
        Connection connection = connectionPool.getConnection();
        List<ExaminationType> resultList = new ArrayList<>();
        String query = "SELECT * FROM examination_type";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()) {
                while(rs.next()){
                    ExaminationType examinationType = new ExaminationType();
                    examinationType.setExaminationTypeId(rs.getInt("examination_type_id"));
                    examinationType.setExaminationType(rs.getString("examination_type"));
                    resultList.add(examinationType);
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
    public ExaminationType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        ExaminationType examinationType = new ExaminationType();
        String query = "SELECT * FROM examination_type WHERE examination_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    examinationType.setExaminationTypeId(rs.getInt("examination_type_id"));
                    examinationType.setExaminationType(rs.getString("examination_type"));
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
        return examinationType;
    }
}
