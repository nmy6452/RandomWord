package com.nmy.randomword.Repository;

import com.nmy.randomword.Entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {

    public Word findOneById(String id);
}
