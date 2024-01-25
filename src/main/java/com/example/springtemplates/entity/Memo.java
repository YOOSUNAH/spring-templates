package com.example.springtemplates.entity;

import com.example.springtemplates.dto.MemoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Memo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoId;
    private String title;

    public Memo(MemoRequestDto requestDto) {
        this.title =requestDto.getTitle();
    }


    public void update(MemoRequestDto memoRequestDto){
        this.title = memoRequestDto.getTitle();
    }
}


