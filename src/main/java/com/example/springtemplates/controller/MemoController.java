package com.example.springtemplates.controller;


import com.example.springtemplates.dto.MemoRequestDto;
import com.example.springtemplates.dto.MemoResponseDto;
import com.example.springtemplates.entity.Memo;
import com.example.springtemplates.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        return memoService.getMemos();
    }

    @PostMapping("/memos")
    public MemoResponseDto saveMemo(@RequestBody MemoRequestDto memoRequestDto){
        return memoService.saveMemo(memoRequestDto);
    }

    @PutMapping("/memos/{memoId}")
    public Long updateMemo(@PathVariable Long memoID, @RequestBody MemoRequestDto memoRequestDto){
        return memoService.updateMemo(memoID, memoRequestDto);
    }

    @DeleteMapping("/memos/{memoId}")
    public void deleteMemo(@PathVariable Long memoId){
        memoService.deleteMemo(memoId);
    }

}
