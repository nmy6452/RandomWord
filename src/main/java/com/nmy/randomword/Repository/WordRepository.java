package com.nmy.randomword.Repository;

import com.nmy.randomword.Entity.Word;
import com.nmy.randomword.Enum.WordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WordRepository extends JpaRepository<Word, Long> {

    public Word findOneById(Integer id);

    @Query(value = "SELECT * FROM word where type = :type order by RAND() limit 1",nativeQuery = true)
    public Word findOneByType(@Param("type") String type);
    @Query(value = "SELECT * FROM word order by RAND() limit 1",nativeQuery = true)
    public Word findwordrand();


}
