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

@WebServlet(urlPatterns = { "/admin/category/edit" })
public class CategoryEditController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Category category = cateService.get(Integer.parseInt(id));

        request.setAttribute("category", category);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/category/edit-category.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Category category = new Category();
        category.setCate_id(Integer.parseInt(request.getParameter("id")));
        category.setCate_name(request.getParameter("name"));
        cateService.edit(category);

        response.sendRedirect(request.getContextPath()+"/admin/category/list");

    }
}