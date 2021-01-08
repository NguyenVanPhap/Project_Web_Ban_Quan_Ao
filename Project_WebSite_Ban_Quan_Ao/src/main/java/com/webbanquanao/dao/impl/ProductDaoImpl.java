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
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

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
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            trans.begin();
            em.remove(em.merge(productEntity));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public ProductEntity get(int id){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        try{
            ProductEntity productEntity = em.find(ProductEntity.class, id);
            return productEntity;
        }
        finally {
            em.close();
        }
    }

    @Override
    public List<ProductEntity> getAll(){
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
    public List<ProductEntity> getByPage(int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
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
    public List<ProductEntity> getByPageAndPrice(double priceStart,double priceEnd, int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.price >= :priceStart and P.price <= : priceEnd";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("priceStart",priceStart);
        q.setParameter("priceEnd",priceEnd);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
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
    public List<ProductEntity> searchByPageAndCategory(int cate_id,int offset, int limit){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P Where P.categoryEntity.cateId =:cate_id ";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("cate_id",cate_id);
        q.setFirstResult(offset);
        q.setMaxResults(limit);
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
    }
    public List<ProductEntity> searchByPrice(double priceStart,double priceEnd){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        String qString = "FROM ProductEntity P where P.price >= :priceStart and P.price <= : priceEnd";
        TypedQuery<ProductEntity> q = em.createQuery(qString,ProductEntity.class);
        q.setParameter("priceStart",priceStart);
        q.setParameter("priceEnd",priceEnd);
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
}
