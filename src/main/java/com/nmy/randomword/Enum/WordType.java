package com.nmy.randomword.Enum;

public enum WordType {
    
    ANIMAL("animal", "동물"),
    OBJECT("object", "사물"),
    EMOTION("emotion", "감정");
    private String id;
    private String title;

    WordType(String id, String title){
        this.id = id;
        this.title = title;
    }

}
