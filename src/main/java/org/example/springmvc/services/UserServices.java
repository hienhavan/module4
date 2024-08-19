package org.example.springmvc.services;

import org.example.springmvc.model.UserDTO;
import org.example.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
public UserRepository userRepository;
    public List<UserDTO> showList() {
        return userRepository.findAll();
    }
public void deleteUser(int id) {
        userRepository.deleteById(id);

}
public Optional<UserDTO> getUser(int id){
       return userRepository.findById(id);
}
public void addUser(UserDTO user){
        if(user.getId() == null){
            user.setId(10); //Assuming id = 0 when creating new user.
        }
        userRepository.save(user);
}
}
