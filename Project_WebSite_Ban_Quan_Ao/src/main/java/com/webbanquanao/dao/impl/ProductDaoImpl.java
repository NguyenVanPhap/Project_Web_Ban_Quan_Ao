package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.dao.ProductDao;
import com.webbanquanao.model.CategoryEntity;
import com.webbanquanao.model.ProductEntity;
import com.webbanquanao.service.CategoryService;
import com.webbanquanao.service.impl.CategoryServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    public void insert(ProductEntity product){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(product);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }

    }

    @Override
    public void edit(ProductEntity product){
        /*Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }*/

        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(product);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(int id)
    {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            ProductEntity product =session.get(ProductEntity.class,id);
            if (product != null){
                session.delete(product);
            }
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public ProductEntity get(int id){
        Transaction transaction = null;
        ProductEntity product = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            product = session.get(ProductEntity.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<ProductEntity> getAll(){
        /*List<ProductEntity> productList = new ArrayList<ProductEntity>();
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            productList = session.createQuery("from ProductEntity").getResultList();
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return productList;*/
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
    }

    @Override
    public List<ProductEntity> search(String keyword)
    {
        /*List<ProductEntity> productList = new ArrayList<ProductEntity>();
        String sql = "SELECT product.id, product.image, product.name AS p_name, product.price, " +
                "product.des , category.cate_name AS c_name, category.cate_id AS c_id " +
                "FROM ProductEntity , Category   where product.cate_id = category.cate_id and Category.cate_id=?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Category category = categoryService.get(rs.getInt("c_id"));

                ProductEntity product = new ProductEntity();
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
        return productList;*/
        return null;
    }

    @Override
    public List<ProductEntity> searchByCategory(int cate_id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P Where P.categoryEntity.cateId =:cate_id ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("cate_id",cate_id);
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
 /*       List<ProductEntity> productList = new ArrayList<ProductEntity>();
        String sql ="SELECT product.id, product.image, product.name AS p_name, product.price, " +
                "product.des , category.cate_name AS c_name, category.cate_id AS c_id " +
                "FROM ProductEntity , Category   where product.cate_id = category.cate_id and Category.cate_id=?";
        Connection conn = super.getJDBCConnection();

        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cate_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Category category = categoryService.get(rs.getInt("c_id"));

                ProductEntity product = new ProductEntity();
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
        return productList;*/

    }

    @Override
    public List<ProductEntity> searchByName(String productName) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.name like :productName";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("productName","%"+productName+"%");
        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        try{
            productList = q.getResultList();
            if(productList == null || productList.isEmpty())
                productList= null;
        }finally {
            em.close();
        }
        return productList;
/*        List<ProductEntity> productList = new ArrayList<ProductEntity>();
        String sql = "SELECT product.id, product.image, product.name AS p_name, product.price, product.des , category.cate_name AS c_name, category.cate_id AS c_id 				"
                + " FROM ProductEntity , Category   where product.cate_id = category.cate_id and ProductEntity.name like ? ";
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+ productName +"%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = categoryService.get(rs.getInt("c_id"));
                ProductEntity product = new ProductEntity();
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
    }

}
