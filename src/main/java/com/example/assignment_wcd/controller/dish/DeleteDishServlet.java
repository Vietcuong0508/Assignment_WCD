package com.example.assignment_wcd.controller.dish;

import com.example.assignment_wcd.entity.Dish;
import com.example.assignment_wcd.entity.myenum.DishStatus;
import com.example.assignment_wcd.model.CategoryModel;
import com.example.assignment_wcd.model.DishModel;
import com.example.assignment_wcd.model.MySqlCategoryModel;
import com.example.assignment_wcd.model.MySqlDishModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteDishServlet extends HttpServlet {
    private DishModel dishModel;

    public DeleteDishServlet() {
        this.dishModel = new MySqlDishModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Dish dish = dishModel.findById(id);
        if (dish == null) {
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
            return;
        }
        dish.setStatus(DishStatus.DELETED);
        try {
            if (dishModel.update(id, dish)) {
                resp.sendRedirect("/admin/dish/list");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
