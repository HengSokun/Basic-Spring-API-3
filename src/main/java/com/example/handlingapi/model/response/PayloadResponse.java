package com.example.handlingapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayloadResponse<T>{
    private String timestamp;

    private Integer status;

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
}
