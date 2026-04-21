package com.frudoko.DAO.impl;

import com.frudoko.DAO.UserDAO;
import com.frudoko.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
        
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean existsByUserName(String userName) {
        return false;
    }

    @Override
    public boolean emailExists(String email) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
