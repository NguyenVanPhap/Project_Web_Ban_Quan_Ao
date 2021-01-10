package com.webbanquanao.controller.admin;

import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.service.SkuService;
import com.webbanquanao.service.impl.SkuServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns= {"/admin/sku/list"})
public class SkuListController extends HttpServlet {
    SkuService skuService = new SkuServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SkuEntity> listSku = skuService.getAll();
        request.setAttribute("listSku", listSku);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/admin/list-sku.jsp");
        dispatcher.forward(request, response);
    }
}
