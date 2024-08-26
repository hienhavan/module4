package org.example.springmvc.repository;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
