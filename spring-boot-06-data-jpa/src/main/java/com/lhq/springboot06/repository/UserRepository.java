package com.lhq.springboot06.repository;

import com.lhq.springboot06.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//继承jpaRepository来完成对数据库操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
