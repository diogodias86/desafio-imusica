package com.imusica.desafio.rpgbattle.controller.validation;

import com.imusica.desafio.rpgbattle.controller.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que é responsável por fazer o controle global das exceções referente a validação de dados do Spring Validation.
 */

@RestControllerAdvice
public class ValidationErrorHandler {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationErrorDTO> handle(MethodArgumentNotValidException exception) {
        List<ValidationErrorDTO> dto = new ArrayList<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(e -> {
                    String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
                    dto.add(new ValidationErrorDTO(e.getField(), message));
                });

        return dto;
    }
}
