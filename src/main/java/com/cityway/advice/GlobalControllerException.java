package com.cityway.advice;

import com.cityway.exception.EmptyParameterException;
import com.cityway.model.ResponseMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Name: GlobalControllerException
 * Description: Handles exceptions globally. Using AOP to catch all the exception in the controller advice.
 */
@RestControllerAdvice
public class GlobalControllerException {

    /**
     * Name: responseMessage
     * Description: When EmptyParameterException is thrown. It will be
     * caught here and return the response
     * @param e
     * @return ResponseMessage - details of the exception.
     */
    @ExceptionHandler(EmptyParameterException.class)
    public ResponseMessage responseMessage(EmptyParameterException e){
        return ResponseMessage.builder()
                .code(500)
                .message(e.getMessage())
                .build();
    }
}
