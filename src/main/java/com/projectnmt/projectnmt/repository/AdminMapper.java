package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.req.PageShowUpdateReqDto;
import com.projectnmt.projectnmt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<User> userList();

    public void updatePageShow(@Param("donationPageId") int donationPageId);

}
