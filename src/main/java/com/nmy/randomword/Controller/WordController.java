package com.nmy.randomword.Controller;

import com.nmy.randomword.Entity.Word;
import com.nmy.randomword.Enum.WordType;
import com.nmy.randomword.Repository.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WordController {

    final WordRepository wordRepository;

    public WordController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    public ResponseEntity<Word> FindWord(@RequestParam("id") String id){
        Word word = wordRepository.findOneById(id);

        return ResponseEntity.ok(word);
    }

    @RequestMapping(value = "/word", method = RequestMethod.PUT)
    public boolean InsertWord(@RequestParam("id") String id,
                              @RequestParam("word") String word,
                              @RequestParam("type") String  type){
        Word reqword = new Word(id, word, WordType.valueOf(type));
        wordRepository.save(reqword);
        return true;
    }
}
