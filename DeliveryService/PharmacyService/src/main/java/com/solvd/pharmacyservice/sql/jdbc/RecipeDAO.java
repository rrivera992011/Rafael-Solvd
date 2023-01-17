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
        String query = "INSERT INTO appointment (recipe_id, recipe_size, medicine_name) VALUES((?), (?), (?))";
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
    }

    @Override
    public Recipe createEntity(Recipe recipe) {
        return null;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM recipe WHERE id = (?)";
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
                Recipe recipe = new Recipe();
                recipe.setRecipeId(rs.getInt("recipe_id"));
                recipe.setRecipeSize(rs.getDouble("recipe_size"));
                recipe.setMedicineName(rs.getString("medicine_name"));
                resultList.add(recipe);
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
        String query = "SELECT * FROM recipe WHERE id = (?)";
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
