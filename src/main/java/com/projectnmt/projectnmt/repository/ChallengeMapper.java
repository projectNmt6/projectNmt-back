package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.ChallengePage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChallengeMapper {

    public int saveChallengePage(ChallengePage challengePage);

}
