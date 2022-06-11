package com.example.assignment_wcd.model;

import com.example.assignment_wcd.constant.SqlConstant;
import com.example.assignment_wcd.entity.Dish;
import com.example.assignment_wcd.entity.myenum.DishStatus;
import com.example.assignment_wcd.service.ConnectionHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySqlDishModel implements DishModel {

    @Override
    public boolean save(Dish obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.DISH_INSERT);
            preparedStatement.setString(1, obj.getFood());
            preparedStatement.setString(2, obj.getThumbnail());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.setInt(4, obj.getCategoryId());
            preparedStatement.setString(5, obj.getDescription());
            preparedStatement.setString(6, obj.getCreatedAt().toString());
            preparedStatement.setString(7, obj.getUpdatedAt().toString());
            preparedStatement.setInt(8, obj.getCreatedBy());
            preparedStatement.setInt(9, obj.getUpdatedBy());
            preparedStatement.setInt(10, obj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Dish updateObj) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.DISH_UPDATE);
            preparedStatement.setString(1, updateObj.getFood());
            preparedStatement.setString(2, updateObj.getThumbnail());
            preparedStatement.setDouble(3, updateObj.getPrice());
            preparedStatement.setInt(4, updateObj.getCategoryId());
            preparedStatement.setString(5, updateObj.getDescription());
            preparedStatement.setString(6, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(7, updateObj.getUpdatedBy());
            preparedStatement.setInt(8, updateObj.getStatus().getValue());
            preparedStatement.setInt(9, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.DISH_DELETE);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Dish> findAll() {
        List<Dish> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.DISH_SELECT_ALL);
            preparedStatement.setInt(1, DishStatus.ON_SALE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Dish dish = convertResultSetToDish(resultSet);
                if (dish != null) {
                    listObj.add(dish);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public Dish findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.DISH_SELECT_BY_ID);
            preparedStatement.setInt(1, DishStatus.ON_SALE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToDish(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Dish findByDishName(String name) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.DISH_SELECT_BY_NAME);
            preparedStatement.setInt(1, DishStatus.ON_SALE.getValue());
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return convertResultSetToDish(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Dish convertResultSetToDish(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SqlConstant.DISH_FIELD_ID);
            String name = resultSet.getString(SqlConstant.DISH_FIELD_NAME);
            String thumbnail = resultSet.getString(SqlConstant.DISH_FIELD_THUMBNAIL);
            Double price = resultSet.getDouble(SqlConstant.DISH_FIELD_PRICE);
            int categoryId = resultSet.getInt(SqlConstant.DISH_FIELD_CATEGORY_ID);
            String description = resultSet.getString(SqlConstant.DISH_FIELD_DESCRIPTION);
            Date saleDate = resultSet.getDate(SqlConstant.DISH_FIELD_SALE_DATE);
            int status = resultSet.getInt(SqlConstant.DISH_FIELD_STATUS);
            LocalDateTime createdAt = resultSet.getTimestamp(SqlConstant.FIELD_CREATED_AT).toLocalDateTime();
            LocalDateTime updatedAt = resultSet.getTimestamp(SqlConstant.FIELD_UPDATED_AT).toLocalDateTime();
            LocalDateTime deletedAt = null;
            Timestamp timestamp = resultSet.getTimestamp(SqlConstant.FIELD_DELETED_AT);
            if (timestamp != null) {
                deletedAt = timestamp.toLocalDateTime();
            }
            int createdBy = resultSet.getInt(SqlConstant.FIELD_CREATED_BY);
            int updatedBy = resultSet.getInt(SqlConstant.FIELD_UPDATED_BY);
            int deletedBy = resultSet.getInt(SqlConstant.FIELD_DELETED_BY);
//            return DISH.DISHBuilder.aDISH()
            Dish dish = new Dish(id, name, categoryId, description, thumbnail, price, saleDate, DishStatus.of(status));
            dish.setCreatedAt(createdAt);
            dish.setUpdatedAt(updatedAt);
            dish.setDeletedAt(deletedAt);
            dish.setCreatedBy(createdBy);
            dish.setUpdatedBy(updatedBy);
            dish.setDeletedBy(deletedBy);
            return dish;
        } catch (SQLException ex) {
            return null;
        }
    }
}
