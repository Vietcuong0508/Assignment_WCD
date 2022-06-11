package com.example.assignment_wcd.controller.dish.client;

import com.example.assignment_wcd.model.DishModel;
import com.example.assignment_wcd.model.MySqlDishModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListDishClientServlet extends HttpServlet {
    private DishModel dishModel;

    public ListDishClientServlet() {
        this.dishModel = new MySqlDishModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("food", dishModel.findAll());
        req.getRequestDispatcher("/client/dish/list.jsp").forward(req, resp);
    }
}
