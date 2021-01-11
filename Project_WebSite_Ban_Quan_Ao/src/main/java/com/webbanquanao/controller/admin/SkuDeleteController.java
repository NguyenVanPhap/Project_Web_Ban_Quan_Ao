package com.webbanquanao.controller.admin;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.model.SkuEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.SkuService;
import com.webbanquanao.service.impl.ProductServiceImpl;
import com.webbanquanao.service.impl.SkuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin/sku/delete" })
public class SkuDeleteController extends HttpServlet {
    SkuService skuService = new SkuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SkuEntity skuEntity = skuService.get(Integer.parseInt(id));
        ProductEntity productEntity = skuEntity.getProductEntity();
        int proid = productEntity.getId();
        skuService.delete(Integer.parseInt(id));


        response.sendRedirect(request.getContextPath() + "/admin/sku/list?id=" + proid);
    }

}
