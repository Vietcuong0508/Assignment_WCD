package com.example.assignment_wcd.entity.myenum;

public enum DishStatus {
    ON_SALE(1), STOP_SALE(0), DELETED(-1);

    private int value;

    DishStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DishStatus of(int value) {
        for (DishStatus dishStatus :
                DishStatus.values()) {
            if (dishStatus.getValue() == value) {
                return dishStatus;
            }
        }
        return DishStatus.DELETED;
    }
}
