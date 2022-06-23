package com.selecshop.week4.controller;

import com.selecshop.week4.models.ItemDto;
import com.selecshop.week4.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        /*
        @RequestParam

        URL : /api/search?query=검색어
        ? 뒤에 있는 것을 Param라고 하며 ? 뒤에 있는 변수를 받기 위해 @RequestParam 사용
         */
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}