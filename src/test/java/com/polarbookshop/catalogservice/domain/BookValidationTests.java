package com.polarbookshop.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class BookValidationTests {

    private static Validator validator;

    @BeforeAll
    static void setUp(){

        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        validator=validatorFactory.getValidator();
    }

    @Test
    void whenallfieldsareset(){
        var book= new Book("123","title","author",9.0);
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        System.out.println("#####");
        assertThat(validate).isEmpty();
    }

    @Test
    void whenallfieldsarenotset(){
        var book= new Book("","title","author",9.0);
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        assertThat(validate).hasSize(1);
    }
}
