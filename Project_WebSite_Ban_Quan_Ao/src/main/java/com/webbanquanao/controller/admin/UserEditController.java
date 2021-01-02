package com.webbanquanao.controller.admin;

import com.webbanquanao.model.UserEntity;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.UserServiceImpl;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = { "/admin/user/edit" })
public class UserEditController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserEntity user = userService.get(id);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/View/admin/edit-user.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserEntity user = new UserEntity();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        String url="";
        String iduser="";
        try
        {
            List<FileItem> items = servletFileUpload.parseRequest(req);
            for (FileItem item : items)
            {
                if (item.getFieldName().equals("id"))
                {
                    iduser=item.getString();
                    user.setId(Integer.parseInt(item.getString()));
                }
                else if (item.getFieldName().equals("email")) {
                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("emailError", "Email is not allowed to be blank");
                        url = "0";
                    }
                    else
                    {
                        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
                        if(!pattern.matcher(item.getString()).matches())
                        {
                            req.getSession().setAttribute("emailError", "You must enter email in format xx@xx");
                            url = "0";
                        }
                        else {
                            req.getSession().setAttribute("emailError", null);
                        }

                    }

                    user.setEmail(item.getString());;
                } else if (item.getFieldName().equals("username")) {
                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("nameError", "username is not allowed to be blank");
                        url = "0";
                    }
                    else {
                        req.getSession().setAttribute("nameError", null);
                    }
                    //req.getSession().setAttribute("name",item.getString());
                    user.setUserName(item.getString());
                } else if (item.getFieldName().equals("password")) {
                    if(item.getString().equals(""))
                    {
                        req.getSession().setAttribute("passError", "password is not allowed to be blank");
                        url = "0";
                    }
                    else {
                        req.getSession().setAttribute("passError", null);
                    }
                    
                    user.setPassword(item.getString());
                }else if (item.getFieldName().equals("address")) {
                    user.setAddress(item.getString());
                } else if (item.getFieldName().equals("permission")) {
                    user.setPermission(Integer.parseInt(item.getString()));;
                } else if (item.getFieldName().equals("avatar"))
                {
                    if (item.getSize() > 0)
                    {
                        String originalFileName = item.getName();
                        Path path = Paths.get(originalFileName);
                        final String storepath = servletContext.getRealPath("image");
                        System.out.println("File1: " + storepath + "\\" + path.getFileName());
                        File file = new File(storepath + "\\" + path.getFileName());
                        if (!file.exists() && !file.isDirectory()) {
                            item.write(file);
                        }
                        user.setAvatar(originalFileName);
                    }
                    else
                    {
                        user.setAvatar(null);
                    }
                }
            }
            if(url!="0") {
                userService.edit(user);
                resp.sendRedirect(req.getContextPath() + "/admin/user/list");
            }
            else
            {
                userService.edit(user);
                resp.sendRedirect(req.getContextPath() + "/admin/user/edit?id="+iduser);
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/admin/user/list");
        }

    }
}