package com.webbanquanao.controller.user;

import java.io.IOException;
import java.util.ArrayList;
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
        int numOfProducts=0;
        String[] categorylist=req.getParameterValues("catecheckbox");
        System.out.println(categorylist.length);
        req.setAttribute("categorylist",categorylist);
        List<ProductEntity> products=new ArrayList<ProductEntity>();
        for (int i=0;i<categorylist.length;i++)
        {
            List<ProductEntity> tempproducts =productService.searchByCategory(categorylist[i]);
            products.addAll(tempproducts);
        }
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
        List<ProductEntity> productList=new ArrayList<ProductEntity>();
        for (int i=0;i<categorylist.length;i++)
        {
            List<ProductEntity> tempproductList=productService.searchByPageAndCategory(categorylist[i], offset,litmit);
            productList.addAll(tempproductList);
        }


        req.setAttribute("numOfPages",numOfPages);
        req.setAttribute("productList", productList);
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/View/User/ProductSearchByCategory.jsp").forward(req, resp);
    }
}
