package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CartDao;
import com.webbanquanao.dao.HibernateConnection.HibernateUtil;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.model.CartitemEntity;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public void insert(CartEntity cart) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("Insert into Cart(u_id,buyDate,action) values(:u_id,:buyDate,:action)");
        query.setParameter("u_id",cart.getUserEntity().getId());
        query.setParameter("buyDate",cart.getBuyDate());
        query.setParameter("action",cart.getAction());
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
    public void edit(CartEntity cart) {
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        Query query = getSession.createSQLQuery("UPDATE Cart SET action = :action WHERE id = :id");
        query.setParameter("id", cart.getId());
        query.setParameter("action", cart.getAction());
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
    public void delete(int id) {
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
    public CartEntity get(int id) {
 /*       String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id WHERE cart.id=?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                return cart;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public List<CartEntity> getAll() {
 /*       List<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartList;*/
        return null;
    }

    public List<CartEntity> search(String name) {
  /*      List<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id LIKE User.email = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartList;*/
        return null;
    }

    @Override
    public CartEntity get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeProduct(CartEntity cart, int pId){
        List <CartitemEntity> cartItems = cart.getCartitemEntities();
        cartItems.remove(pId);
        cart.setCartitemEntities(cartItems);
    }

    @Override
    public double totalBill(CartEntity cart) {
        double total = 0;
        try {
            total = cart.getCartitemEntities().stream().mapToDouble(cartItem -> cartItem.getProductEntity().getPrice() * cartItem.getQuantity()).sum();
        }
        catch(Exception e)
        {}
        return total;
    }

    @Override
    public int getIDCart(){
        EntityManager em = HibernateUtil.getEmFactory().createEntityManager();
        Session getSession = em.unwrap(Session.class);
        getSession.getTransaction().begin();
        int id = (int) getSession.createSQLQuery("SELECT id FROM cart ORDER BY id DESC LIMIT 1").addScalar("id",new IntegerType()).uniqueResult();
        try{

            getSession.getTransaction().commit();
            getSession.close();
        }
        finally {
            em.close();
        }
        return id;
    }

    public CartEntity getCart(int u_id){
        CartEntity cart = new CartEntity();



        return cart;
    }
}
