package com.onecontroller.ecommerce.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private Status status;
    private String message;
    private Object data;
    private Long timestamp;

   public enum Status {
        SUCCESS,
        ERROR,
    }

    public static ApiResponse success(Object responseData, String successMessage){
       return ApiResponse.builder()
               .status(Status.SUCCESS)
               .message(successMessage)
               .data(responseData)
               .timestamp(System.currentTimeMillis())
               .build();
    }

    public static ApiResponse error(String errorMessage){
       return ApiResponse.builder()
               .status(Status.ERROR)
               .message(errorMessage)
               .data(null)
               .timestamp(System.currentTimeMillis())
               .build();
    }
}

