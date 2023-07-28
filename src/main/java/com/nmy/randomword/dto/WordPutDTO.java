package com.nmy.randomword.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WordPutDTO {
    Integer id;
    @NotBlank
    String word;
    String type;
}
