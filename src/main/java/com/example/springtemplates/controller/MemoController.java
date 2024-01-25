package com.example.springtemplates.controller;


import com.example.springtemplates.dto.MemoRequestDto;
import com.example.springtemplates.dto.MemoResponseDto;
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
    public Long updateMemo(@PathVariable Long memoId, @RequestBody MemoRequestDto memoRequestDto){
        return memoService.updateMemo(memoId, memoRequestDto);
    }

    @DeleteMapping("/memos/{memoId}")
    public Long deleteMemo(@PathVariable Long memoId){
       return memoService.deleteMemo(memoId);
    }

}
