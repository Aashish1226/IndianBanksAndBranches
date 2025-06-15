package com.BanksAndBranches.project.Exceptions;
import com.BanksAndBranches.project.DTO.ResponseDTO.CommonResponse;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestControllerAdvice
public class HRMSAdvice {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<CommonResponse> handleResponseStatusException(ResponseStatusException ex) {
        String message = ex.getReason();
        HttpStatus status = (HttpStatus) ex.getStatusCode();
        String errorCode = "RESPONSE_STATUS_EXCEPTION";
        return new ResponseEntity<>(CommonResponse.error(message, errorCode), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleGeneralException(Exception ex) {
        String errorCode = "INTERNAL_SERVER_ERROR";
        CommonResponse errorResponse = CommonResponse.error(ex.getMessage(), errorCode);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CommonResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        String message = ex.getMessage();
        String errorCode = ex.getErrorCode() != null ? ex.getErrorCode() : "ENTITY_NOT_FOUND";
        return ResponseEntity.status(ex.getStatus() != null ? ex.getStatus() : HttpStatus.NOT_FOUND).body(CommonResponse.error(message, errorCode));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CommonResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        String errorCode = "INVALID_ARGUMENT";
        return ResponseEntity.badRequest().body(CommonResponse.error(ex.getMessage(), errorCode));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            if (fieldName.contains(".")) {
                fieldName = fieldName.substring(fieldName.lastIndexOf('.') + 1);
            }
            errors.put(fieldName, error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}