package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.resp.MessageRespDto;
import com.projectnmt.projectnmt.dto.resp.ParticipateCountRespDto;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<MessageRespDto> getMessageList(int id, int isTeam) {
        return userMapper.getMessageList(id, isTeam);
    }
    public void deleteMessageBYId(int id, int isTeam) {
        userMapper.deleteMessageById(id, isTeam);
    }
    public ParticipateCountRespDto getParticipateCount(int userId) {
        return userMapper.getParticipateCountByuserId(userId);
    }
}
