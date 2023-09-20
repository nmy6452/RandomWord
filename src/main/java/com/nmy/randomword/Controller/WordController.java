package com.nmy.randomword.Controller;

import com.nmy.randomword.Entity.Word;
import com.nmy.randomword.Enum.CustomExceptonCode;
import com.nmy.randomword.Enum.WordType;
import com.nmy.randomword.Exception.CustomException;
import com.nmy.randomword.Repository.WordRepository;
import com.nmy.randomword.Service.WordService;
import com.nmy.randomword.dto.WordPutDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.MDC;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class WordController {

    final WordRepository wordRepository;
    final WordService wordService;

    public WordController(WordRepository wordRepository, WordService wordService) {
        this.wordService = wordService;
        this.wordRepository = wordRepository;
    }
    @Operation(
            summary = "단어 조회",
            description = "id 또는 타입을 지정해 랜덤한 한 단어를 조회")
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public ResponseEntity<Word> FindWord(
            @Parameter(name = "id", description = "word 의 id", in = ParameterIn.QUERY) @RequestParam(value = "id", required = false) Integer id,
            @Parameter(name = "type", description = "word 의 type", in = ParameterIn.QUERY) @RequestParam(value = "type", required = false) WordType type){

        return ResponseEntity.ok(wordService.getword(id,type));
    }
    @Operation(
            summary = "단어 목록 조회",
            description = "id 또는 타입을 지정해 단어목록을 조회")
    @RequestMapping(value = "/word/list", method = RequestMethod.GET)
    public ResponseEntity<Page<Word>> GetWordList(
            @Parameter(name = "page", description = "조회 하고자 하는 페이지", in = ParameterIn.QUERY)
            @RequestParam(value = "page", required = false, defaultValue="1") int page,
            @Parameter(name = "size", description = "페이지 사이즈", in = ParameterIn.QUERY)
            @RequestParam(value = "size", required = false, defaultValue="15") int size,
            @Parameter(name = "word", description = "검색 조건 단어", in = ParameterIn.QUERY)
            @RequestParam(value = "id", required = false) String word,
            @Parameter(name = "type", description = "검색 조건 타입", in = ParameterIn.QUERY)
            @RequestParam(value = "type", required = false) WordType type){

        return ResponseEntity.ok(wordService.GetWordList(page, size, word, type));
    }
    @Operation(
            summary = "단어 타입",
            description = "어떤 단어 타입이 있는지 확인")
    @RequestMapping(value = "/word/type", method = RequestMethod.GET)
    public ResponseEntity<WordType[]> AllWordType(){
        WordType[] Type = WordType.values();

        return ResponseEntity.ok(Type);
    }
    @Operation(
            summary = "단어 입력",
            description = "단어를 입력 가능, 만약에 있는 단어라면 업데이트")
    @RequestMapping(value = "/word",
            method = RequestMethod.PUT,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Word InsertWord(@RequestBody @Valid WordPutDTO wordPutDTO){
//        if (wordPutDTO.getId() == null){
//            throw new CustomException(CustomExceptonCode.ID_IS_NULL);
//        }
        //타입이 틀리면 예외 발생
        try {
            WordType.valueOf(wordPutDTO.getType());
        }
        catch (IllegalArgumentException e){
            throw new CustomException(CustomExceptonCode.INVALID_WORD_TYPE);
        }
        return wordService.WordInser(wordPutDTO);
    }
}
