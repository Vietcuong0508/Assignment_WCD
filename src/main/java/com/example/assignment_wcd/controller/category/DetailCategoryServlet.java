package com.example.assignment_wcd.controller.category;

import com.example.assignment_wcd.entity.Category;
import com.example.assignment_wcd.model.CategoryModel;
import com.example.assignment_wcd.model.MySqlCategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    public DetailCategoryServlet() {
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = categoryModel.findById(id);
            if (category == null) {
                req.setAttribute("message", "Category is not found!");
                req.getRequestDispatcher("/admin/error/404.jsp");
                return;
            }
            req.setAttribute("categories", category);
            req.getRequestDispatcher("/admin/categories/detail.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp");
        }
    }
}
