package com.projectnmt.projectnmt.controller;

import com.projectnmt.projectnmt.dto.req.ActionBoardReqDto;
import com.projectnmt.projectnmt.dto.resp.ActionBoardRespDto;
import com.projectnmt.projectnmt.dto.resp.DonationGivingRespDto;
import com.projectnmt.projectnmt.entity.ActionBoard;
import com.projectnmt.projectnmt.service.ActionBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ActionBoardController {

    @Autowired
    private ActionBoardService actionBoardService;

    @GetMapping("/action-board/{challengePageId}")
    public ResponseEntity<?> getActionBoardListByPageId(@PathVariable int challengePageId) {
        List<ActionBoardRespDto> boardList = actionBoardService.getActionBoardByChallengePageId(challengePageId);
        return ResponseEntity.ok(boardList);
    }



    @DeleteMapping("/action-board/{id}")
    public ResponseEntity<?> deleteActionBoard(@PathVariable("id") int actionBoardId){
        actionBoardService.deleteActionBoard(actionBoardId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/action-board/upload")
    public ResponseEntity<?> saveActionBoard(@Valid @RequestBody ActionBoardReqDto actionBoardReqDto, BindingResult bindingResult) {
        actionBoardService.saveActionBoard(actionBoardReqDto);
        return ResponseEntity.created(null).body(actionBoardReqDto);
    }

}
