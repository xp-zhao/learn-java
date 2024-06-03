package com.example.feature.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 *
 * @author zhaoxiaoping
 * @date 2024-6-3
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<String> paramExceptionHandle(MethodArgumentNotValidException e) {
    BindingResult result = e.getBindingResult();
    FieldError error = result.getFieldError();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body("参数验证失败: " + error.getDefaultMessage());
  }
}
