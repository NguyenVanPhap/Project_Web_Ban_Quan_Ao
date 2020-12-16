package com.webbanquanao.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/product/category")
public class ProductSeachByCategory extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cate_id=req.getParameter("cate_id");
        List<ProductEntity> productSeachByCategory =productService.searchByCategory(Integer.parseInt(cate_id));
        req.setAttribute("productList", productSeachByCategory);
        req.getRequestDispatcher("/View/User/ProductSearchByCategory.jsp").forward(req, resp);
    }
}
