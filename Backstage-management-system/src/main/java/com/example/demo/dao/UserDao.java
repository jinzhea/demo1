package com.example.demo.dao;


import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    //登录查询
    Boolean existsByUsernameAndPassword(String username,String password);

    //查询用户名是否存在
    boolean existsByUsername(String username);

    //通过id查询
    User findById(Integer id);

    //模糊查询,按照修改的时间将序排列
    @Query(value = "select * from userinfo u where u.username like CONCAT('%',:likename,'%') ORDER BY update_time DESC ", nativeQuery = true)
    List<User> findByKeyNameLimit(@Param("likename") String likename);

    //模糊查询
    List<User> findByUsernameLike(String likename);

    //按照修改时间降序排列
    @Query(value = "select * from  userinfo order BY update_time DESC ", nativeQuery = true)
    List<User> find();

    //分页
   Page<User> findAll(Pageable pageable);

}
