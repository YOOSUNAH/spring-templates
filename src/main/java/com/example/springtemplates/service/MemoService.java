package com.example.springtemplates.service;

import com.example.springtemplates.dto.MemoRequestDto;
import com.example.springtemplates.dto.MemoResponseDto;
import com.example.springtemplates.entity.Memo;
import com.example.springtemplates.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public List<MemoResponseDto> getMemos() {
        return memoRepository.findAll().stream().map(MemoResponseDto::new).toList();
    }

    @Transactional
    public MemoResponseDto saveMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);
        // DB에 저장
        Memo saveMemo = memoRepository.save(memo);
        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(saveMemo);
        return memoResponseDto;
    }

    @Transactional
    public Long updateMemo(Long memoId, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalArgumentException("해당 메모가 없습니다."));
      memo.update(requestDto);
      return memoId;

//    memo.setTitle(input.getTitle());
//    return memo;
    }

    @Transactional
    public void deleteMemo(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(() -> new IllegalArgumentException("해당 메모가 없습니다."));
            memoRepository.delete(memo);
        //        memoRepository.deleteById(memoId);

    }
}
