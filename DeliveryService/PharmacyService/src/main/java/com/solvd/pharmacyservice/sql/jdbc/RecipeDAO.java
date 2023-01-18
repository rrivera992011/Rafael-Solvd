package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Recipe;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

public class RecipeDAO implements IRecipeDAO {

    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(Recipe recipe) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE recipe SET recipe_size = (?), medicine_name = (?) WHERE recipe_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setDouble(1, recipe.getRecipeSize());
            ps.setString(2, recipe.getMedicineName());
            ps.setInt(3, recipe.getRecipeId());
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
    public Recipe createEntity(Recipe recipe) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO recipe (recipe_id, recipe_size, medicine_name) VALUES((?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, recipe.getRecipeId());
            ps.setDouble(2, recipe.getRecipeSize());
            ps.setString(3, recipe.getMedicineName());
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
        return recipe;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM recipe WHERE recipe_id = (?)";
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
    public List<Recipe> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Recipe> resultList = new ArrayList<>();
        String query = "SELECT * FROM recipe";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()) {
                    Recipe recipe = new Recipe();
                    recipe.setRecipeId(rs.getInt("recipe_id"));
                    recipe.setRecipeSize(rs.getDouble("recipe_size"));
                    recipe.setMedicineName(rs.getString("medicine_name"));
                    resultList.add(recipe);
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
    public Recipe getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Recipe recipe = new Recipe();
        String query = "SELECT * FROM recipe WHERE recipe_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    recipe.setRecipeId(rs.getInt("recipe_id"));
                    recipe.setRecipeSize(rs.getDouble("recipe_size"));
                    recipe.setMedicineName(rs.getString("medicine_name"));
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
        return recipe;
    }
}
