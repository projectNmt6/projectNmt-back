package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<User> userList();
}
