package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CartItemDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CartItemDaoImpl implements CartItemDao {

    @Override
    public void insert(CartitemEntity cartItem) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.persist(cartItem);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void edit(CartitemEntity cartItem) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            trans.begin();
            em.merge(cartItem);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(String id) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try{
            CartEntity cart = em.find(CartEntity.class, id);
            trans.begin();
            em.remove(em.merge(cart));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public CartitemEntity get(int id) {
 /*       String sql = "SELECT " +
                "CartItem.id, " +
                "CartItem.quantity, " +
                "CartItem.unitPrice, " +
                "cart.u_id, " +
                "cart.buyDate, " +
                "product.name, " +
                "product.price " +
                "FROM CartItem " +
                "INNER JOIN Cart " +
                "ON CartItem.cart_id = cart.id " +
                "INNER JOIN Product " +
                "ON CartItem.pro_id = Product.id " +
                "WHERE CartItem.id = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("u_id"));

                Cart cart = new Cart();
                cart.setBuyer(user);
                cart.setBuyDate(rs.getDate("buyDate"));

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));

                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));


                return cartItem;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public List<CartitemEntity> getAll() {
/*        List<CartItem> cartItemList = new ArrayList<CartItem>();
        String sql = "SELECT " +
                "CartItem.id, " +
                "CartItem.quantity, " +
                "CartItem.unitPrice, " +
                "cart.u_id, " +
                "cart.buyDate, " +
                "product.name, " +
                "product.price " +
                "FROM CartItem " +
                "INNER JOIN Cart " +
                "ON CartItem.cat_id = Cart.id " +
                "INNER JOIN Product " +
                "ON CartItem.pro_id = Product.id ";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("u_id"));

                Cart cart = new Cart();
                cart.setBuyer(user);
                cart.setBuyDate(rs.getDate("buyDate"));

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));

                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getString("id"));
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));

                cartItemList.add(cartItem);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartItemList;*/
        return null;
    }

    public List<CartitemEntity> search(String name) {
        return null;
    }

    @Override
    public CartitemEntity get(String name) {
        // TODO Auto-generated method stub
        return null;
    }
}
