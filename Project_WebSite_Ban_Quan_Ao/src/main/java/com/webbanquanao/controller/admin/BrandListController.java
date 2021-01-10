package com.webbanquanao.controller.admin;

import com.webbanquanao.model.BrandEntity;
import com.webbanquanao.service.BrandService;
import com.webbanquanao.service.impl.BrandServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns= {"/admin/brand/list"})
public class BrandListController extends HttpServlet {
    BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BrandEntity> listBrand = brandService.getAll();
        request.setAttribute("listBrand", listBrand);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/admin/list-sku.jsp");
        dispatcher.forward(request, response);
    }
}
