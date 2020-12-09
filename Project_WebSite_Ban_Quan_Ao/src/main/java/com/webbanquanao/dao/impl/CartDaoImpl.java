package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.CartDao;
import com.webbanquanao.model.CartEntity;
import com.webbanquanao.service.UserService;
import com.webbanquanao.service.impl.UserServiceImpl;

import java.util.List;

public class CartDaoImpl implements CartDao {
   UserService userS = new UserServiceImpl();

    @Override
    public void insert(CartEntity cart) {
/*        String sql = "INSERT INTO Cart(id,u_id, buyDate) VALUES (?,?,?)";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cart.getId());
            ps.setInt(2, cart.getBuyer().getId());
            ps.setDate(3, (java.sql.Date) new Date(cart.getBuyDate().getTime()));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void edit(CartEntity cart) {
/*        String sql = "UPDATE cart SET id_user = ?, buyDate = ? WHERE id = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cart.getBuyer().getId());
            ps.setDate(2, (java.sql.Date) new Date(cart.getBuyDate().getTime()));
            ps.setString(3, cart.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    @Override
    public void delete(int id) {
/*        String sql = "DELETE FROM cart WHERE id = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
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
}
