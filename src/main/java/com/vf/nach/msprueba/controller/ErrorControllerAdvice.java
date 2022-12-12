package com.vf.nach.msprueba.controller;

import com.vf.nach.msprueba.model.dto.ResponseDTO;
import com.vf.nach.msprueba.util.exception.MsPruebaException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;

@RestControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    @ExceptionHandler(value = {MsPruebaException.class})
    ResponseEntity<?> handlingError(MsPruebaException ex, HttpServletRequest httpServletRequest) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ResponseDTO.builder().data(null).success(false).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ParseException.class})
    ResponseEntity<?> handlingError(ParseException ex, HttpServletRequest httpServletRequest) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ResponseDTO.builder().data(null).success(false).build(), HttpStatus.BAD_REQUEST);
    }
}
