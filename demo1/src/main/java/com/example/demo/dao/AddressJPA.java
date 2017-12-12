package com.example.demo.dao;

import com.example.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJPA extends JpaRepository<Address,Integer>{
    //通过id查找收货人地址
    Address findById(Integer id);



}
