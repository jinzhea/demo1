package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryDefinition(domainClass=User.class,idClass = Integer.class)
public interface UserJPA extends JpaRepository<User,Integer> {

    //登录验证
    User findByUsernameAndPassword(String username , String password);

    //验证用户名是否存在
    Boolean existsByUsername(String username);



}
