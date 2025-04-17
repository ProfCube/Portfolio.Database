package com.example.NekoDB;

import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // empty or with method declarations like below

    // inherit CRUD methods: save (for create and update), delete
    // for search/read use find
    public List<Customer> findByName(String Name);


}
