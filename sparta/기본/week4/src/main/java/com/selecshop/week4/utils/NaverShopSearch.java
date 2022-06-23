package com.selecshop.week4.utils;

import com.selecshop.week4.models.ItemDto;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
/*
@Component
클래스에 @Component 어노테이션을 붙임으로써 xml 없이 빈을 생성할 수 있다. (사용자가 요구하면 자동으로 생성할 클래스 목록에 등록)

controller에서 @RequiredArgsConstructor을 사용하기 위해서는 class가 component로 등록이 되어 있어야 하는데
SearchRequestController에서 NaverShopSearch class를 @RequiredArgsConstructor 하기 때문에 여기서 @Component로 지정을 해주는 것
 */
public class NaverShopSearch {
    public String search(String query) { // query : 검색어
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "MRiG5CgVaSGZwqlIYlt7");
        headers.add("X-Naver-Client-Secret", "Cz1ugEZ0Mz");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
//        System.out.println("Response status: " + status);
//        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result){
        // 1. 문자열 정보를 JSONObject로 바꾸기
        JSONObject rjson = new JSONObject(result);
        // System.out.println(rjson); -> "items" : [{},{},...]

        // 2. JSONObject에서 items 배열 꺼내기
        JSONArray items = rjson.getJSONArray("items");

        // 3. JSONArray 로 for 문 돌기
        List<ItemDto> ItemDtoList = new ArrayList<>();
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            //System.out.println(itemJson);

            /*
            // 4. JSONObject 에서 String, int 데이터 뽑기
            String title = itemJson.getString("title");
            String image = itemJson.getString("image");
            int lprice = itemJson.getInt("lprice");
            String link = itemJson.getString("link");
            System.out.println(lprice);
            */

            ItemDto itemDto = new ItemDto(itemJson);
            ItemDtoList.add(itemDto);
        }

        return ItemDtoList;
    }

    /*
    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("아이맥"); // result : query(검색어)로 검색한 검색 결과

    }
    */
}