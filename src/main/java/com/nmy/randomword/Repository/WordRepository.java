package com.nmy.randomword.Repository;

import com.nmy.randomword.Entity.Word;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WordRepository extends JpaRepository<Word, Long> {

    public Word findOneById(Integer id);

    public Word findOneByWord(String word);


    public Word[] findLikeWordAndType(String word,String Type, Pageable pageable);

    @Query(value = "SELECT * FROM word where type = :type order by RAND() limit 1",nativeQuery = true)
    public Word findOneByType(@Param("type") String type);

    @Query(value = "SELECT * FROM word order by RAND() limit 1",nativeQuery = true)
    public Word findwordrand();


}
