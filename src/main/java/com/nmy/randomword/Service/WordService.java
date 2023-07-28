package com.nmy.randomword.Service;

import com.nmy.randomword.Entity.Word;
import com.nmy.randomword.Enum.WordType;
import com.nmy.randomword.Repository.WordRepository;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    final WordRepository repository;

    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    public Word getword(Integer id, WordType type){
    
        //만약에 ID가 주어진다면 ID에 해당하는 단어를 출력
        if (id != null){
            return repository.findOneById(id);
        } else if (type != null) {
            Word word = repository.findOneByType(type.toString());
            return word;
        } else {
            return repository.findwordrand();
        }
    }
}
