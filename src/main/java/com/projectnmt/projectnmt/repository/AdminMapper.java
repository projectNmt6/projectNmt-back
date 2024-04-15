package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.dto.req.AdminMessageReqDto;
import com.projectnmt.projectnmt.dto.resp.CommentListRespDto;
import com.projectnmt.projectnmt.entity.AdminUser;
import com.projectnmt.projectnmt.entity.Authority;
import com.projectnmt.projectnmt.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<AdminUser> findUserList();
    public AdminUser findUserByUserId(int userId);
    public List<CommentListRespDto> findCommentListByUserId(int userId);
    public void addRole(Authority authority);
    public void sendMessage(int userId, String message);
}
