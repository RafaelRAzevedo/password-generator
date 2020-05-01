package com.example.passwordgenerator.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Getter
@Setter
public class PasswordDTO {

    private boolean uppercase;
    private boolean numbers;
    private boolean special;
    private boolean spaces;
    private int length;

}
