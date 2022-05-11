package com.fajardo.jadotaweb.models.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HttpErrorResponse {
    
    private String error;
    private String message;
}
