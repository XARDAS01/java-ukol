package com.example.demo.resource;

import com.example.demo.exception.InternalTransactionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
public class ExHandler {

  @ExceptionHandler(InternalTransactionException.class)
  void doNothing(InternalTransactionException internalTransactionException) {
    log.error(Arrays.toString(internalTransactionException.getStackTrace()));
  }
}
