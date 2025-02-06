package com.emre.springjpademo.exception;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.Field;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> ValidationExceptionHandler(MethodArgumentNotValidException ex){
//Validasyon hatalarını key value şekline formatlamak için Map oluşturduk
        //Bu sınıfı doldurup Api errore vereceğiz
        Map<String, List<String>> mappedErrors = new HashMap<>();

        for(ObjectError objErrors:ex.getBindingResult().getAllErrors()){
            //hatanın fieldNameini al
            String fieldName = ((FieldError)objErrors).getField();
            //hatanın detayını al fakat burada ilgili fieldName olabileceği için
            //öncelikle mapped i kontrol et eğer içerisinde var ise listeye ekle
            if(mappedErrors.containsKey(fieldName)){
                mappedErrors.put(fieldName, addItemToList(mappedErrors.get(fieldName), objErrors.getDefaultMessage()));
            }else{
                //hata ilk kez oluşturulacağı için fieldName ve yeni liste verilir
                mappedErrors.put(fieldName,addItemToList(new ArrayList<>(),objErrors.getDefaultMessage()));
            }
        }

        ApiError apiError = createApiError(mappedErrors);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    //İçerisine liste ve itemi alır geriye itemi eklediği listeyi döner
    private List<String> addItemToList(List<String> list, String item){
        list.add(item);
        return list;
    }


    //Clienta aşağıdaki tipte veri dönmemizi sağlar
    private ApiError createApiError(Map<String, List<String>> errors) {
        ApiError apiError = new ApiError();
        apiError.setErrors(errors);
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        return apiError;
    }
}


/*
* "id":"ftpy7e2idvtMDQA3E1XOWeNK",
* "dateTime":"06-02-2025"
*"errors":{
* "firstName":["Firstname alanı boş geçilemez",
* "En fazla 10 karakter olabilir",
* "En az iki karakter olabilir"]
* }
* */