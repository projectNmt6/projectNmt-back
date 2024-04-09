package com.projectnmt.projectnmt.service;

import com.projectnmt.projectnmt.dto.EditAccountReqDto;
import com.projectnmt.projectnmt.entity.User;
import com.projectnmt.projectnmt.exception.ValidException;
import com.projectnmt.projectnmt.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void editAccount(EditAccountReqDto editAccountReqDto) {
        User user = userMapper.findUserByUsername(editAccountReqDto.getUsername());
        if (!passwordEncoder.matches(editAccountReqDto.getOldPassword(), user.getPassword())) {
            throw new ValidException(Map.of("oldPassword", "비밀번호 인증에 실패하였습니다.\n다시입력하세요."));
        }
        if (!editAccountReqDto.getNewPassword().equals(editAccountReqDto.getNewPasswordCheck())) {
            throw new ValidException(Map.of("newPasswordCheck", "새로운 비밀번호가 서로 일치하지 않습니다.\n다시입력하세요."));
        }
        if (passwordEncoder.matches(editAccountReqDto.getNewPassword(), user.getPassword())) {
            throw new ValidException(Map.of("newPassword", "이전 비밀번호와 동일한 비밀번호는 사용하실 수 없습니다.\n다시입력하세요."));
        }
        User updatedUser = User.builder()
                .userId(editAccountReqDto.getUserId())
                .username(editAccountReqDto.getUsername())
                .password(passwordEncoder.encode(editAccountReqDto.getNewPassword()))
                .name(editAccountReqDto.getName())
                .email(editAccountReqDto.getEmail())
                .age(editAccountReqDto.getAge())
                .gender(editAccountReqDto.getGender())
                .phoneNumber(editAccountReqDto.getPhonenumber())
                .profileImg(editAccountReqDto.getProfileImg())
                .build();

        userMapper.updateUser(updatedUser);
    }
}

