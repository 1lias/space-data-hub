package com.papounidis.space_data_hub.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
Using Spring Framework Web Services to give correct error response to user.
 */

@ControllerAdvice
public class MissionNotFoundExceptionResponse {

    @ResponseBody
    @ExceptionHandler(MissionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String missionNotFoundHandler(MissionNotFoundException ex) {
        return ex.getMessage();
    }
}
