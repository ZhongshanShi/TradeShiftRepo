package com.example.tradeshift.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseMessage {
     int statusCode;
     String message;
}
