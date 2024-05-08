package com.projectnmt.projectnmt.repository;

import com.projectnmt.projectnmt.entity.ActionBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ActionBoardMapper {

    public int saveActionBoard(ActionBoard actionBoard);

    public int deleteActionBoardById(@Param("actionBoardId") int actionBoardId);

    public List<ActionBoard> getActionBoardLIst(
            @Param("actionBoardId") int actionBoardId,
            @Param("userId") int userId,
            @Param("actionContent") String actionContent,
            @Param("imageId") int imageId,
            @Param("imageURL") String imageURL,
            @Param("createDate")LocalDateTime createDate,
            @Param("challengePageId") int challengePageId
            );

    List<ActionBoard> getActionBoardByChallengePageId(int challengePageId);

    public int countByActionBoardPageId(@Param("challengePageId") int challengePageId);
}
