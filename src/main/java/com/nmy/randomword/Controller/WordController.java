package com.nmy.randomword.Controller;

import com.nmy.randomword.Entity.Word;
import com.nmy.randomword.Enum.CustomExceptonCode;
import com.nmy.randomword.Enum.WordType;
import com.nmy.randomword.Exception.CustomException;
import com.nmy.randomword.Repository.WordRepository;
import com.nmy.randomword.Service.WordService;
import com.nmy.randomword.dto.WordPutDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.slf4j.MDC;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
public class WordController {

    final WordRepository wordRepository;
    final WordService wordService;

    public WordController(WordRepository wordRepository, WordService wordService) {
        this.wordService = wordService;
        this.wordRepository = wordRepository;
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public ResponseEntity<Word> FindWord(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "type", required = false) WordType type){

        return ResponseEntity.ok(wordService.getword(id,type));
    }

    @RequestMapping(value = "/word/type", method = RequestMethod.GET)
    public ResponseEntity<WordType[]> AllWordType(){
        WordType[] Type = WordType.values();

        return ResponseEntity.ok(Type);
    }

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
