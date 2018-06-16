package com.cityway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Name: ResponseMessage
 * Description: ResponseMessage class to define the exception details.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseMessage {

    private Integer code;
    private String message;

}
