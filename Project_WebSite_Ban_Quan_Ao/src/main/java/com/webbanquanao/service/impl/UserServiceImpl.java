package com.webbanquanao.service.impl;

import com.webbanquanao.dao.UserDao;
import com.webbanquanao.dao.impl.UserDaoImpl;
import com.webbanquanao.model.User;
import com.webbanquanao.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void edit(User newUser) {
        User oldUser = userDao.get(newUser.getId());

        oldUser.setEmail(newUser.getEmail());
        oldUser.setUserName(newUser.getUserName());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setAddress(newUser.getAddress());
        oldUser.setPermission(newUser.getPermission());
        if (newUser.getAvatar() != null) {
            /*// XOA ANH CU DI
            String fileName = oldUser.getAvatar();
            final String dir = "C:\\Users\\mai vien\\eclipse-workspace\\UNIFY\\upload";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            // THEM ANH MOI*/
            oldUser.setAvatar(newUser.getAvatar());
        }

        userDao.edit(oldUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> search(String username) {
        return userDao.search(username);
    }

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }

        return null;
    }

    @Override
    public boolean register(String username, String password, String email) {
        if (userDao.checkExistUserName(username)) {
            return false;
        }
        userDao.insert(new User(email, username, password));
        return true;
    }


    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    public boolean checkExistUsername(String username) {
        return userDao.checkExistUserName(username);
    }
}
