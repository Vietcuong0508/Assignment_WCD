package com.example.assignment_wcd.controller.category;

import com.example.assignment_wcd.entity.Category;
import com.example.assignment_wcd.entity.Dish;
import com.example.assignment_wcd.entity.myenum.CategoryStatus;
import com.example.assignment_wcd.entity.myenum.DishStatus;
import com.example.assignment_wcd.model.CategoryModel;
import com.example.assignment_wcd.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public DeleteCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryModel.findById(id);
        if (category == null) {
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
            return;
        }
        category.setStatus(CategoryStatus.DELETED);
        try {
            if (categoryModel.update(id, category)) {
                resp.sendRedirect("/admin/categories/list");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
