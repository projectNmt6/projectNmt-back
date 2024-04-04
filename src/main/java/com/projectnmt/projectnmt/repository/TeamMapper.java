package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.Team;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {
    public int saveTeam(Team team);
    public int saveLeader(int userId, int teamId);
}
