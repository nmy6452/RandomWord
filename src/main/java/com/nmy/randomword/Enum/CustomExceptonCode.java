package com.nmy.randomword.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CustomExceptonCode {

    //400
    INVALID_WORD_TYPE(HttpStatus.BAD_REQUEST, "잘못된 단어 분류입니다. 단어 분류는 word/type에서 확인 가능합니다."),
    ID_IS_NULL(HttpStatus.BAD_REQUEST, "ID 가 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
