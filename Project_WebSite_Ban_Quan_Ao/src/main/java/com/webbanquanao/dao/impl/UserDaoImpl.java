package com.webbanquanao.dao.impl;

import com.webbanquanao.dao.UserDao;
import com.webbanquanao.model.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public void insert(UserEntity user) {
 /*       String sql = "INSERT INTO User(avatar,email, username, password,address,permission) VALUES (?,?,?,?,?,?)";
        Connection con = super.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getAvatar());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getPermission());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void edit(UserEntity user) {
  /*      String sql = "update user set email = ? , userName = ?, password = ?, avatar = ?, address = ?, permission = ? WHERE id = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAvatar());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getPermission());
            ps.setInt(7, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    @Override
    public void delete(int id) {
 /*       String sql = "DELETE FROM User WHERE id = ?";
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
    public UserEntity get(String username) {
  /*      String sql = "SELECT * FROM [User] WHERE username = ? ";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPermission(Integer.parseInt(rs.getString("permission")));

                return user;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public UserEntity get(int id) {
  /*      String sql = "select * from user where id = ? ";
        Connection con = super.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPermission(Integer.parseInt(rs.getString("permission")));
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public List<UserEntity> getAll() {
   /*     List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM User";
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setAddress(rs.getString("address"));
                user.setPermission(rs.getInt("permission"));
                userList.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;*/
        return null;
    }

    @Override
    public List<UserEntity> search(String keyword) {
 /*       List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM [User] WHERE name LIKE ? ";
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));


                userList.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;*/
        return  null;
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
   /*     Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String query = "select * from [user] where email = ?";

            PreparedStatement psmt = conn.prepareStatement(query);

            psmt.setString(1, email);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                duplicate = true;
            }
            psmt.close();
            conn.close();
        } catch (SQLException ex) {
        }*/
        return duplicate;
    }

    @Override
    public boolean checkExistUserName(String username) {
        boolean duplicate = false;
    /*    Connection conn = JDBCConnection.getJDBCConnection();
        try {
            String query = "select * from [User] where username = ?";

            PreparedStatement psmt = conn.prepareStatement(query);

            psmt.setString(1, username);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                duplicate = true;
            }
            psmt.close();
            conn.close();
        } catch (SQLException ex) {
        }*/
        return duplicate;
    }
}
