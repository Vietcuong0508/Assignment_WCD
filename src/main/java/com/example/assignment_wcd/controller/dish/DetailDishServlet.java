package com.example.assignment_wcd.controller.dish;

import com.example.assignment_wcd.entity.Dish;
import com.example.assignment_wcd.model.DishModel;
import com.example.assignment_wcd.model.MySqlDishModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailDishServlet extends HttpServlet {
    private DishModel dishModel;

    public DetailDishServlet() {
        this.dishModel = new MySqlDishModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Dish dish = dishModel.findById(id);
            if (dish == null) {
                req.setAttribute("message", "Dish is not found!");
                req.getRequestDispatcher("/admin/error/404.jsp");
                return;
            }
            req.setAttribute("dish", dish);
            req.getRequestDispatcher("/admin/dish/detail.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp");
        }
    }
}
