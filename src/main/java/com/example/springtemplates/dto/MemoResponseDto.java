package com.example.springtemplates.dto;

import com.example.springtemplates.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private Long memoId;
    private String title;



    public MemoResponseDto(Memo memo){
        this.memoId = memo.getMemoId();
        this.title = memo.getTitle();
    }

}
