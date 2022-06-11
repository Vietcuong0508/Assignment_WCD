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

public class UpdateDishServlet extends HttpServlet {
    private CategoryModel categoryModel;
    private DishModel dishModel;

    public UpdateDishServlet() {
        this.categoryModel = new MySqlCategoryModel();
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
            req.setAttribute("action", 2);
            req.setAttribute("categories", categoryModel.findAll());
            req.getRequestDispatcher("/admin/dish/form.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            // lấy giá trị từ form gửi lên.
            String name = req.getParameter("name");
            int id = Integer.parseInt(req.getParameter("id"));
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String description = req.getParameter("description");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            int status = Integer.parseInt(req.getParameter("status"));
            Dish dish = dishModel.findById(id);
            // Khởi tạo đối tượng account từ thông tin truyền lên.
            dish = Dish.DishBuilder.aDish()
                    .withName(name)
                    .withCategoryId(categoryId)
                    .withDescription(description)
                    .withThumbnail(thumbnail)
                    .withPrice(price)
                    .withStatus(DishStatus.of(status))
                    .build();
            if (dish.isValid()) {
                boolean result = dishModel.update(id, dish);
                if (result) {
                    resp.sendRedirect("/admin/dish/list");
                } else {
                    throw new Exception("Can't update dish");
                }
            } else {
                req.setAttribute("action", 2);
                req.setAttribute("errors", dish.getErrors());
                req.setAttribute("categories", categoryModel.findAll());
                req.setAttribute("dish", dish);
                req.getRequestDispatcher("/admin/dish/form.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
        }
    }
}
