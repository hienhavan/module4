package org.example.springmvc.services;

import org.example.springmvc.model.bai6_7.User;
import org.example.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
public UserRepository userRepository;
    public List<User> showList() {
        return userRepository.findAll();
    }
public void deleteUser(int id) {
        userRepository.deleteById(id);

}
public Optional<User> getUser(int id){
       return userRepository.findById(id);
}
public void addUser(User user){
        if(user.getId() == null){
            user.setId(10);
        }
        userRepository.save(user);
}
}
