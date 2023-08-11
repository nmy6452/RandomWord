package com.nmy.randomword.Service;

import com.nmy.randomword.Entity.Word;
import com.nmy.randomword.Enum.CustomExceptonCode;
import com.nmy.randomword.Enum.WordType;
import com.nmy.randomword.Exception.CustomException;
import com.nmy.randomword.Repository.WordRepository;
import com.nmy.randomword.dto.WordPutDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Word> GetWordList(int page, int size, String word, WordType wordType){

        PageRequest pageRequest = PageRequest.of(page,size);
//        return repository.findLikeWordAndType(word, wordType.toString(), pageRequest);
        return repository.findAll(pageRequest);
    }

    public Word WordInser(WordPutDTO wordPutDTO){
        if (wordPutDTO.getId() == null){
            if (repository.findOneByWord(wordPutDTO.getWord()) != null){
                throw new CustomException(CustomExceptonCode.CONFLICT_WORD);
            }
            Long id = repository.count() + 1;
            Word word = new Word(id.intValue(), wordPutDTO.getWord(), WordType.valueOf(wordPutDTO.getType()));
            return repository.save(word);
        }else {
            Word word = new Word(wordPutDTO.getId(), wordPutDTO.getWord(), WordType.valueOf(wordPutDTO.getType()));
            return repository.save(word);
        }
    }
}
