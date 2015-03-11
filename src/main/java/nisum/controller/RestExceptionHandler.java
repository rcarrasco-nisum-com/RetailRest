package nisum.controller;

import nisum.CustomExceptions.ProductIdNotFoundException;
import nisum.CustomExceptions.ProductTypeIdNotFoundException;
import nisum.errorResource.ErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductTypeIdNotFoundException.class)
    public @ResponseBody
    ResponseEntity<ErrorResource> handleProductTypeId(Exception e) {

         ErrorResource errorResource = new ErrorResource
                (HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value()
                        ,e.getMessage(),e.getMessage(),"link",null);

        return new ResponseEntity<ErrorResource>(errorResource,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductIdNotFoundException.class)
    public @ResponseBody
    ResponseEntity<ErrorResource> handleProductId(Exception e) {

        ErrorResource errorResource = new ErrorResource
                (HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.value()
                        ,e.getMessage(),e.getMessage(),"link",null);

        return new ResponseEntity<ErrorResource>(errorResource,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public @ResponseBody
    ResponseEntity<ErrorResource> handleProductTypeIdNotNull(Exception e) {

        ErrorResource errorResource = new ErrorResource
                (HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value()
                        ,e.getMessage(),e.getMessage(),"link",null);

        return new ResponseEntity<ErrorResource>(errorResource,HttpStatus.BAD_REQUEST);
    }
/*
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    */
}
