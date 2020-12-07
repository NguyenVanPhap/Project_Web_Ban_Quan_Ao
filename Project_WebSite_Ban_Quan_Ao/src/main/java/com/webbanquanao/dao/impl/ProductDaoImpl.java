package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.dao.connect.JDBCConnection;
import com.webbanquanao.model.Category;
import com.webbanquanao.model.Product;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.impl.CategoryServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void insert(Product product){
        String sql="Insert into Product(image, name, price, cate_id, des) values (?,?,?,?,?)";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,product.getImage());
            ps.setString(2,product.getName());
            ps.setFloat(3,product.getPrice());
            ps.setInt(4,product.getCategory().getCate_id());
            ps.setString(5,product.getDes());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product){
        String sql = "Update Product Set image = ?, name = ?, price = ?, cate_id = ?, des= ?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,product.getImage());
            ps.setString(2,product.getName());
            ps.setFloat(3,product.getPrice());
            ps.setInt(4,product.getCategory().getCate_id());
            ps.setString(5,product.getDes());
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id)
    {
        String sql = "Delete From Product Where id=?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Product get(int id){
        String sql = "SELECT product.id, product.image, product.name AS p_name, product.price, product.des, category.cate_name AS c_name, category.cate_id AS c_id "
                + "FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id WHERE product.id=?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Category category = categoryService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImage(rs.getString("image"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getFloat("price"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                return product;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();;
        }
        return null;
    }

    @Override
    public List<Product> getAll(){
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.image, product.name AS p_name, product.price, product.des , category.cate_name AS c_name, category.cate_id AS c_id  "
                + "FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Category category = categoryService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImage(rs.getString("image"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getFloat("price"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                productList.add(product);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> search(String keyword)
    {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.image, product.name AS p_name, product.price, " +
                "product.des , category.cate_name AS c_name, category.cate_id AS c_id " +
                "FROM Product , Category   where product.cate_id = category.cate_id and Category.cate_id=?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Category category = categoryService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImage(rs.getString("image"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getFloat("price"));
                product.setDes(rs.getString("des"));

                product.setCategory(category);

                productList.add(product);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchByCategory(int cate_id){
        List<Product> productList = new ArrayList<Product>();
        String sql ="SELECT product.id, product.image, product.name AS p_name, product.price, " +
                "product.des , category.cate_name AS c_name, category.cate_id AS c_id " +
                "FROM Product , Category   where product.cate_id = category.cate_id and Category.cate_id=?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cate_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Category category = categoryService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImage(rs.getString("image"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getFloat("price"));
                product.setDes(rs.getString("des"));

                product.setCategory(category);

                productList.add(product);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchByName(String productName) {
/*        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.image, product.name AS p_name, product.price, product.des , category.cate_name AS c_name, category.cate_id AS c_id 				"
                + " FROM Product , Category   where product.cate_id = category.cate_id and Product.name like ? ";
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+ productName +"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);

                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;*/
        return null;
    }
}
