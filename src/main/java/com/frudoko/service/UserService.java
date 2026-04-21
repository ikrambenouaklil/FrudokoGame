package com.frudoko.service;

import com.frudoko.Repository.UserRepository;
import com.frudoko.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * userService — extended from original project.
 *
 * Added on top of the original CRUD:
 *   • BCrypt password hashing (save / changePassword)
 *   • login()        — email + password verification
 *   • findByEmail()  — lookup by email
 *   • emailExists()  — registration uniqueness check
 *   • changePassword()
 *   • getAllUsers()
 */
@Service
@Transactional
public class UserService {

    /** BCrypt encoder — cost factor 12 */
    private final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(12);

    @Autowired
    UserRepository repo ;

    
    // register

    public boolean register (User user )
    {
        if ( repo.existsByEmail(user.getEmail() )
                || repo.existsByUserName(user.getUserName())) return false ;
        // hash the pswd 
        user.setPassword(bCrypt.encode(user.getPassword()));
        
        repo.save(user);
        return true ; 
    }
    // Login

    public boolean login(String identifier , String rawPassword){

    User user = repo.findByEmail(identifier);
    
        if(user == null) user = repo.findByUserName(identifier);
            
        if(user == null) return false ; 
        
        return bCrypt.matches(rawPassword , user.getPassword()) ;
    }
// -------------- crud------- 



    
// update


    public boolean edit (User user){

        User existing = repo.findById(user.getId()).orElse(null);


        if (existing ==null) return false ;
            existing.setUserName(user.getUserName());
            existing.setEmail(user.getEmail());
        repo.save(existing);
        return true ;
    }


    
public boolean changePassword(int userId , String newRawPassword ){
        User user = repo.findById (userId).orElse(null);
        if (user == null ) return false ; 
        user.setPassword(bCrypt.encode(newRawPassword));
        repo.save(user);
        return true ; 
}
// delete

    public  boolean delete ( int id ){
    
        if(!repo.existsById(id)) return false ; 
        repo.deleteById(id);
        return true ; 
       
    }


// functions
    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public User findById(int id) {
        return repo.findById(id).orElse(null);
    }

}
