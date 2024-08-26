package org.example.springmvc.repository;

import org.example.springmvc.model.bai8.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userb8Reposotory extends JpaRepository<Contacts, Integer> {
}
