package com.example.assignment_wcd.constant;

public class SqlConstant {

    public static final String CATEGORY_INSERT = "insert into categories (name, createdAt, updatedAt, createdBy, updatedBy, status) values (?,?,?,?,?,?)";
    public static final String CATEGORY_UPDATE = "update categories set name = ?, updatedAt = ?, updatedBy = ?, status = ? where id = ?";
    public static final String CATEGORY_DELETE = "update categories set status = ? where id = ?";
    public static final String CATEGORY_SELECT_ALL = "select * from categories where status = ?";
    public static final String CATEGORY_SELECT_BY_ID = "select * from categories where status = ? and id = ?";

    public static final String DISH_INSERT = "insert into dish (name, thumbnail, price, categoryId, description, saleDate, createdAt, updatedAt, createdBy, updatedBy, status) values (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String DISH_UPDATE = "update dish set name = ?, thumbnail = ?, price = ?, categoryId = ?, description = ?, saleDate = ?, updatedAt = ?, updatedBy = ?, status = ? where id = ?";
    public static final String DISH_DELETE = "update dish set status = ? where id = ?";
    public static final String DISH_SELECT_ALL = "select * from dish where status = ?";
    public static final String DISH_SELECT_BY_ID = "select * from dish where status = ? and id = ?";
    public static final String DISH_SELECT_BY_NAME = "select * from dish where status = ? and name = ?";


    public static final String ACCOUNT_FIELD_ID = "id";
    public static final String ACCOUNT_FIELD_USERNAME = "username";
    public static final String ACCOUNT_FIELD_EMAIL = "email";
    public static final String ACCOUNT_FIELD_PASSWORD = "password";
    public static final String ACCOUNT_FIELD_STATUS = "status";
    public static final String ACCOUNT_FIELD_FULLNAME = "fullName";

    public static final String CATEGORY_FIELD_ID = "id";
    public static final String CATEGORY_FIELD_NAME = "name";
    public static final String CATEGORY_FIELD_STATUS = "status";

    public static final String DISH_FIELD_ID = "id";
    public static final String DISH_FIELD_NAME = "name";
    public static final String DISH_FIELD_THUMBNAIL = "thumbnail";
    public static final String DISH_FIELD_PRICE = "price";
    public static final String DISH_FIELD_CATEGORY_ID = "categoryID";
    public static final String DISH_FIELD_DESCRIPTION = "description";
    public static final String DISH_FIELD_SALE_DATE = "saleDate";
    public static final String DISH_FIELD_STATUS = "status";


    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final String FIELD_DELETED_AT = "deletedAt";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_UPDATED_BY = "updatedBy";
    public static final String FIELD_DELETED_BY = "deletedBy";
}
