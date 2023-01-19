package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Category;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

public class CategoryDAO implements ICategoryDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public void updateEntity(Category category) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE category SET category_name = (?) WHERE category_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getCategoryId());
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
    public Category createEntity(Category category) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO category (category_id, category_name) VALUES((?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, category.getCategoryId());
            ps.setString(2, category.getCategoryName());
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
        return category;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM category WHERE category_id = (?)";
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
    public List<Category> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Category> resultList = new ArrayList<>();
        String query = "SELECT * FROM category";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()) {
                while(rs.next()) {
                    Category category = new Category();
                    category.setCategoryId(rs.getInt("category_id"));
                    category.setCategoryName(rs.getString("category_name"));
                    resultList.add(category);
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
    public Category getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Category category = new Category();
        String query = "SELECT * FROM category WHERE category_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    category.setCategoryId(rs.getInt("category_id"));
                    category.setCategoryName(rs.getString("category_name"));
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
        return category;
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        Connection connection = connectionPool.getConnection();
        Category category = new Category();
        String query = "SELECT * FROM category WHERE category_name = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, categoryName);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    category.setCategoryId(rs.getInt("category_id"));
                    category.setCategoryName(rs.getString("category_name"));
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
        return category;
    }
}
