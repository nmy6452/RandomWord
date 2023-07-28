package com.nmy.randomword.Exception;

import com.nmy.randomword.Enum.CustomExceptonCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    CustomExceptonCode exceptonCode;
}
