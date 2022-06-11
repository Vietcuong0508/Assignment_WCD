package com.example.assignment_wcd.entity;

import com.example.assignment_wcd.entity.base.BaseEntity;
import com.example.assignment_wcd.entity.myenum.DishStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class Dish extends BaseEntity {
    public int id;
    public String name;
    public int categoryId;
    public String description;
    public String thumbnail;
    public double price;
    public Date saleDate;
    public DishStatus status;

    public Dish() {
        this.name = "";
        this.price = 0;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.setCreatedBy(0);
        this.setUpdatedBy(0);
        this.status = DishStatus.ON_SALE;
    }

    public Dish(int id, String name, int categoryId, String description, String thumbnail, double price, Date saleDate) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.saleDate = saleDate;
    }

    public Dish(int id, String name, int categoryId, String description, String thumbnail, double price, Date saleDate, DishStatus status) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.saleDate = saleDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return name;
    }

    public void setFood(String food) {
        this.name = food;
    }
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public DishStatus getStatus() {
        return status;
    }

    public void setStatus(DishStatus status) {
        this.status = status;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (name == null || name.length() == 0) {
            errors.put("food", "Please enter food name.");
        }
        if (name == null || name.length() < 7) {
            errors.put("food", "Please enter food name > 7 character.");
        }
        if (price == 0) {
            errors.put("price", "The selling price must be greater than 0.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }


    public static final class DishBuilder {
        public int id;
        public String name;
        public int categoryId;
        public String description;
        public String thumbnail;
        public double price;
        public Date saleDate;
        public DishStatus status;
        private HashMap<String, String> errors = new HashMap<>();
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;

        private DishBuilder() {
            this.name = "";
            this.price = 0;
            this.deletedAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.createdBy = 0;
            this.updatedBy = 0;
            this.status = DishStatus.ON_SALE;
        }

        public static DishBuilder aDish() {
            return new DishBuilder();
        }

        public DishBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public DishBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DishBuilder withCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public DishBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public DishBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public DishBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public DishBuilder withSaleDate(Date saleDate) {
            this.saleDate = saleDate;
            return this;
        }

        public DishBuilder withStatus(DishStatus status) {
            this.status = status;
            return this;
        }

        public DishBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public DishBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public DishBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public DishBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public DishBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public DishBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public DishBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Dish build() {
            Dish dish = new Dish(id, name, categoryId, description, thumbnail, price, saleDate);
            dish.setStatus(status);
            dish.setErrors(errors);
            dish.setCreatedAt(createdAt);
            dish.setUpdatedAt(updatedAt);
            dish.setDeletedAt(deletedAt);
            dish.setCreatedBy(createdBy);
            dish.setUpdatedBy(updatedBy);
            dish.setDeletedBy(deletedBy);
            return dish;
        }
    }
}