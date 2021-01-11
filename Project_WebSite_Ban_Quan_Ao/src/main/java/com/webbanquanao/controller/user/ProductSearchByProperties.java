package com.webbanquanao.controller.user;

import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductSearchByProperties extends HttpServlet {
    ProductService productService  = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numOfProducts=0;
        String cate_name=req.getParameter("cateid");
        List<ProductEntity> products =productService.searchByCategory(cate_name);
        if (products != null){
            numOfProducts =products.size();
        }
        int litmit=9;
        int numOfPages = 0;
        if (numOfProducts/litmit==(float)numOfProducts/litmit){
            numOfPages = numOfProducts/litmit;
        }
        else{
            numOfPages = numOfProducts/litmit+1;
        }
        int page = Integer.parseInt(req.getParameter("page"));
        int offset = (page-1) * litmit;
        List<ProductEntity> productList=productService.searchByPageAndCategory(cate_name, offset,litmit);

        req.setAttribute("numOfPages",numOfPages);
        req.setAttribute("productList", productList);
        req.setAttribute("cate_id",cate_name);
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/View/User/ProductSearchByCategory.jsp").forward(req, resp);
    }
}
