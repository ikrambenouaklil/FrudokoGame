package com.frudoko.DAO;

import com.frudoko.model.User;

public interface UserDAO {

    void save(User user);

    User findByEmail(String email);

    User findByUserName(String userName);

    User findById(int id);

    boolean existsByUserName(String userName);

    boolean emailExists(String email);

    void delete(int id);
}