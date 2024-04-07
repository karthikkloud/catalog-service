package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record Book (
       @NotBlank(message ="isbn cannot be null")
  String isbn,
       @NotBlank(message ="title  cannot be null")
  String title,
       @NotBlank(message ="author cannot be null")
  String author,
       @NotNull(message ="price cannot be null")
       @Positive (message=" Price should be greater than zero")
  Double price
){
}
