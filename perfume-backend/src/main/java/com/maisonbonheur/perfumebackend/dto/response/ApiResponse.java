package com.maisonbonheur.perfumebackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private LocalDateTime timestamp;
    private Object data;
    
    public ApiResponse(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
    
    public ApiResponse(String message, Object data) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }
}