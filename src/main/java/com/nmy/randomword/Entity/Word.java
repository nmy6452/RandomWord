package com.nmy.randomword.Entity;

import com.nmy.randomword.Enum.WordType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "word")
public class Word {

    @Id
    int id;
    @Column(nullable = false)
    String word = "단어";
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    WordType type = null;


    public Word(int id, String word, WordType type) {
        this.id = id;
        this.word = word;
        this.type = type;
    }
}
