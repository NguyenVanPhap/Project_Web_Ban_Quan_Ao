package com.webbanquanao.controller.admin;

import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.ProductService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import com.webbanquanao.service.impl.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/product/add"})
public class ProductAddController extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<CategoryEntity> categories = categoryService.getAll();

        request.setAttribute("categories", categories);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/admin/add-product.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("One");
        ProductEntity product = new ProductEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        ServletContext context = request.getServletContext();
        final String dir = context.getRealPath("image");



        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("name")) {
                    product.setName(item.getString());
                } else if (item.getFieldName().equals("category")) {
                    product.setCategoryEntity(categoryService.get(Integer.parseInt(item.getString())));
                } else if (item.getFieldName().equals("price")) {
                    product.setPrice(Double.parseDouble(item.getString()));
                } else if (item.getFieldName().equals("des")) {
                    product.setDes(item.getString());
                } else if (item.getFieldName().equals("image")) {
                    String originalFileName = item.getName();

                    System.out.println("FileName: "+originalFileName);
                    File file = new File(dir + File.separator + originalFileName);
                    if (!file.exists() && !file.isDirectory()) {
                        item.write(file);
                    }
                    product.setImage(originalFileName);
                }
            }

            productService.insert(product);
            response.sendRedirect(request.getContextPath() + "/admin/product/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Two");
            response.sendRedirect(request.getContextPath() + "/admin/product/add?e=1");
        }

    }
}
