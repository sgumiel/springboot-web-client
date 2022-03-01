package com.kairosds.cursospb2.httpclient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TakeMyBooksClientResponse {

    private String status;
    private String code;
}
