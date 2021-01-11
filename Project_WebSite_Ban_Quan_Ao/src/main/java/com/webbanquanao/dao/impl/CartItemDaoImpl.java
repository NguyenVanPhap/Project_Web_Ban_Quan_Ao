package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CartItemDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CartItemDaoImpl implements CartItemDao {

    @Override
    public void insert(CartitemEntity cartItem) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("Insert into CartItem(pro_id,cart_id,quantity) values(:pro_id,:cart_id,:quantity)");
        query.setParameter("pro_id",cartItem.getSkuEntity().getProductEntity().getId());
        query.setParameter("cart_id",cartItem.getCartEntity().getId());
        query.setParameter("quantity",cartItem.getQuantity());
        try{
            query.executeUpdate();
            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void edit(CartitemEntity cartItem) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("UPDATE CartItem SET quantity = :quantity WHERE id = :id");
        query.setParameter("id", cartItem.getId());
        query.setParameter("quantity", cartItem.getQuantity());;
        try{
            query.executeUpdate();
            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
    }

    @Override
    public void delete(CartitemEntity cartItem) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("DELETE FROM CartItem Where id = :id");
        query.setParameter("id", cartItem.getId());
        try{
            query.executeUpdate();
            getSession.getTransaction().commit();
            getSession.close();
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

    @Override
    public int getIDCartItem(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int id = (int) getSession.createSQLQuery("SELECT id FROM CartItem ORDER BY id DESC LIMIT 1").addScalar("id",new IntegerType()).uniqueResult();
        try{

            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
        return id;
    }
}
