package com.futstack.repository;

import javax.enterprise.context.ApplicationScoped;

import com.futstack.Model.Login;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class LoginRepository implements PanacheRepository<Login> {
  
    
}
