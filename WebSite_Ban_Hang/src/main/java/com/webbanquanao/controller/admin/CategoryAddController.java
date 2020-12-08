package com.webbanquanao.controller.admin;

import com.webbanquanao.model.Category;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.impl.CategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/category/add" })
public class CategoryAddController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/category/add-category.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");


        Category category = new Category();
        category.setCate_name(name);


        cateService.insert(category);

        response.sendRedirect(request.getContextPath() + "/admin/category/list");

    }
}
