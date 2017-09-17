package com.hrportal.util;

import com.hrportal.ErrorCode;
import com.hrportal.exception.ApplicationException;
import com.hrportal.exception.ErrorDto;
import com.hrportal.exception.InputValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class ApiExpHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExpHandler.class);


    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorDto processAccessDeniedError(AccessDeniedException ex) {
        LOGGER.error("Error Access Denied ", ex.getMessage());
        ErrorDto error = new ErrorDto(ErrorCode.ACCESS_DENIED_EXCEPTION, "Invalid token. Access denied");
        return error;
    }


    @ExceptionHandler(ProviderNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorDto processProviderNotFoundException(ProviderNotFoundException ex) {
        LOGGER.error("Error ProviderNotFoundException Denied ", ex.getMessage());
        ErrorDto error = new ErrorDto(ErrorCode.ACCESS_DENIED_EXCEPTION, "Invalid token. Access denied");
        return error;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processBeanValidationException(MethodArgumentNotValidException ex) {
        LOGGER.error("Error ", ex);
        ErrorDto error = new ErrorDto(ErrorCode.INPUT_VALIDATION_ERROR, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return error;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processResourceNotFoundException(ResourceNotFoundException ex) {
        ex.printStackTrace();
        LOGGER.error("Error ", ex);
        ex.printStackTrace();
        ErrorDto error = new ErrorDto(ErrorCode.ENTITY_NOT_FOUND, "Entity not found.");
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto processInternalError(Exception ex) {
        LOGGER.error("Error ", ex);
        ex.printStackTrace();
        ErrorDto error = new ErrorDto(ErrorCode.APPLICATION_ERROR, "Internal server error occurred");
        return error;
    }


    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processApplicationException(ApplicationException ex) {
        LOGGER.error("Error ", ex);
        ErrorDto error = new ErrorDto(ErrorCode.APPLICATION_ERROR, ex.getMessage());
        return error;
    }


    @ExceptionHandler(InputValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processUserInputException(InputValidationException ex) {
        LOGGER.debug(ex.toString());
        ErrorDto errorDto = new ErrorDto(ErrorCode.INPUT_VALIDATION_ERROR, ex.getMessage());
        return errorDto;
    }


    @ExceptionHandler(org.springframework.web.client.HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processInternalError(org.springframework.web.client.HttpClientErrorException ex) {
        LOGGER.debug(ex.toString());
        LOGGER.error("Error " + ex.getResponseBodyAsString());
        String message = "Internal server error occurred";
        if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            message = "Please provide valid input";
        } else {
            HashMap<String, String> data = JsonUtils.readObject(ex.getResponseBodyAsString(), HashMap.class);
            if (data != null && !data.isEmpty()) {
                if (StringUtils.isNotBlank(data.get("error_message"))) {
                    message = data.get("error_message");
                }
                if (StringUtils.isNotBlank(data.get("message"))) {
                    message = data.get("message");
                }
            }
        }
        ErrorDto error = new ErrorDto(ErrorCode.APPLICATION_ERROR, message);
        return error;
    }

    @ExceptionHandler(org.springframework.web.client.HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto processInternalError(org.springframework.web.client.HttpServerErrorException ex) {
        LOGGER.debug(ex.toString());
        LOGGER.error("Error " + ex.getResponseBodyAsString());
        String message = "Internal server error occurred";
        HashMap<String, String> data = JsonUtils.readObject(ex.getResponseBodyAsString(), HashMap.class);
        if (data != null && !data.isEmpty()) {
            if (StringUtils.isNotBlank(data.get("error_message"))) {
                message = data.get("error_message");
            }
            if (StringUtils.isNotBlank(data.get("message"))) {
                message = data.get("message");
            }
        }
        ErrorDto error = new ErrorDto(ErrorCode.APPLICATION_ERROR, message);
        return error;
    }


    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto processInternalError(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        LOGGER.debug(ex.toString());
        LOGGER.error("Error while parsing request body" + ex.getMessage());
        String message = "Request Body is Not Valid";
        ErrorDto error = new ErrorDto(ErrorCode.APPLICATION_ERROR, message);
        return error;
    }
}
