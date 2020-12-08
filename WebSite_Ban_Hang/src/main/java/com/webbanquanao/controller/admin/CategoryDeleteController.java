package com.webbanquanao.controller.admin;

import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/category/delete" })
public class CategoryDeleteController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();///333333333

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        cateService.delete(Integer.parseInt(id));

        response.sendRedirect(request.getContextPath() + "/admin/category/list");
    }

}