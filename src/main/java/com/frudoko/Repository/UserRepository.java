package com.frudoko.Repository;

import com.frudoko.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    User findByEmail(String email);
    User findByUserName(String username);
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
}
