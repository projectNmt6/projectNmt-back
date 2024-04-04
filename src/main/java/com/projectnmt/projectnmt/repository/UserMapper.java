package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public int saveUser(User user);
}
