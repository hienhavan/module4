package org.example.springmvc.services.bai8;

import org.example.springmvc.model.bai8.Contacts;
import org.example.springmvc.model.demo_bai_8.User;
import org.example.springmvc.repository.Userb8Reposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userb8Services {
    @Autowired
    private Userb8Reposotory userb8;

    public void saveUser(Contacts contact) {
        userb8.save(contact);
    }

}
