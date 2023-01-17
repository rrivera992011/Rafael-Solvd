package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Examination;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

public class ExaminationDAO implements IExaminationDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(Examination examination) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO examination (examination_id, exam_result, employee_id, examination_type_id, " +
                "customer_id) VALUES((?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, examination.getExaminationId());
            ps.setString(2, examination.getExamResult());
            ps.setInt(3, examination.getEmployeeId());
            ps.setInt(4, examination.getExaminationTypeId());
            ps.setInt(5, examination.getCustomerId());
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
    public Examination createEntity(Examination examination) {
        return null;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM examination WHERE id = (?)";
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
    public List<Examination> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Examination> resultList = new ArrayList<>();
        String query = "SELECT * FROM examination";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                Examination examination = new Examination();
                examination.setExaminationId(rs.getInt("examination_id"));
                examination.setExamResult(rs.getString("exam_result"));
                examination.setEmployeeId(rs.getInt("employee_id"));
                examination.setExaminationTypeId(rs.getInt("examination_type_id"));
                examination.setCustomerId(rs.getInt("customer_id"));
                resultList.add(examination);
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
    public Examination getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Examination examination = new Examination();
        String query = "SELECT * FROM examination WHERE id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    examination.setExaminationId(rs.getInt("examination_id"));
                    examination.setExamResult(rs.getString("exam_result"));
                    examination.setEmployeeId(rs.getInt("employee_id"));
                    examination.setExaminationTypeId(rs.getInt("examination_type_id"));
                    examination.setCustomerId(rs.getInt("customer_id"));
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
        return examination;
    }
}
