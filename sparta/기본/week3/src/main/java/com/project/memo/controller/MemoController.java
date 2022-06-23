package com.project.memo.controller;

import com.project.memo.domain.Memo;
import com.project.memo.domain.MemoRepository;
import com.project.memo.domain.MemoRequestDto;
import com.project.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo CreatMemo(@RequestBody MemoRequestDto requestDto){ // body에서 memo를 작성해야 하는데 @RequestBody으로 요청 받은 것을 body라고 annotation 해주지 않으면 오류 발생
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

//    @GetMapping("/api/memos")
//    public List<Memo> readMemo(){
//        return memoRepository.findAllByOrderByModifiedAtDesc();
//    }

    // 타임라인 서비스가 불러오는 메모 목록의 시간을, 조회 시간으로부터 24시간 이내로 함
    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start,end);
    }


    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){ // @PathVariable : 위 중괄호로 싸여 있는 {id}를 변수로 넣어주겠다는 의미
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }
}
