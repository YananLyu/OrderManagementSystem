package com.astronet.oms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Yanan Lyu
 * @date 3/11/21 12:42 AM
 */
@ControllerAdvice
public class SpuNotFoundAdvice {

    /**
     * @ResponseBody signals that this advice is rendered straight into the response body.
     * @ExceptionHandler configures the advice to only respond if an EmployeeNotFoundException is thrown.
     * @ResponseStatus says to issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
     * The body of the advice generates the content. In this case, it gives the message of the exception.
     *
     * @param ex
     * @return string, message
     */
    @ResponseBody
    @ExceptionHandler(SpuNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String spuNotFoundHandler(SpuNotFoundException ex) {
        return ex.getMessage();
    }
}
