package com.nmy.randomword.Entity;

import com.nmy.randomword.Enum.WordType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "WORD")
public class Word {

    @Id
    String id;
    @Column(nullable = false)
    String word = "단어";
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    WordType type = null;


    public Word(String id, String word, WordType type) {
        this.id = id;
        this.word = word;
        this.type = type;
    }
}
