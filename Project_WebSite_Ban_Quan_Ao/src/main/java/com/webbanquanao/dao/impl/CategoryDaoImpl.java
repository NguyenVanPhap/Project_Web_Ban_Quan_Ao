package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CategoryDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void insert(CategoryEntity category) {

        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // start a transaction
            transaction = session.beginTransaction();
            // save catogery
            session.save(category);
            // commit transaction
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void edit(CategoryEntity category) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(category);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void detele(int cate_id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            CategoryEntity categoryEntity = session.get(CategoryEntity.class, cate_id);
            if (categoryEntity != null) {
                session.delete(categoryEntity);
                System.out.println("Category is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public CategoryEntity get(int cate_id)
    {
        Transaction transaction = null;
        CategoryEntity categoryEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            categoryEntity = session.get(CategoryEntity.class, cate_id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return categoryEntity;
    }

    @Override
    public CategoryEntity getName(String cate_name)
    {
        Transaction transaction = null;
        CategoryEntity categoryEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            categoryEntity = session.get(CategoryEntity.class, cate_name);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> getAll(){

        List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            categoryEntities = session.createQuery("from CategoryEntity").getResultList();
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return categoryEntities;
    }

    @Override
    public List<CategoryEntity> search(String keyword){
        /*
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM category WHERE cate_name LIKE ? ";
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setCate_id(rs.getInt("cate_id"));
                category.setCate_name(rs.getString("cate_name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;*/
        return null;
    }
}
