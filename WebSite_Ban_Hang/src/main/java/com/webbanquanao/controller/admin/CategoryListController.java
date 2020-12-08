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
import java.util.List;

@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryListController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> cateList = cateService.getAll();
        request.setAttribute("cateList", cateList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/admin/list-category.jsp");
        dispatcher.forward(request, response);
    }
}
