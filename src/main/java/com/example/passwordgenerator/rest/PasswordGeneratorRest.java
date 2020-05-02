package com.example.passwordgenerator.rest;

import com.example.passwordgenerator.dto.PasswordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PasswordGeneratorRest {

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/generate")
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<String> getPassword(@RequestBody @Valid PasswordDTO dto) {

    String small = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder availableCharacters = new StringBuilder();

    availableCharacters.append(small);

    if (dto.isUppercase()) {
      String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      availableCharacters.append(uppercase);
    }

    if (dto.isNumbers()) {
      String numbers = "0123456789";
      availableCharacters.append(numbers);
    }

    if (dto.isSpecial()) {
      String symbols = "!@#$%^&*_=+-/.?<>)";
      availableCharacters.append(symbols);
    }

    if (dto.isSpaces()) {
      StringBuilder space = new StringBuilder();

      for (int i = 0; i < dto.getLength() / 2; i++) {
        space.append(" ");
      }

      availableCharacters.append(space);
    }

    StringBuilder password = new StringBuilder();

    for (int i = 0; i < dto.getLength(); i++) {
      int random = (int) (Math.random() * availableCharacters.length());
      password.append(availableCharacters.charAt(random));
    }

    return new ResponseEntity<>(password.toString(), HttpStatus.OK);
  }
}
