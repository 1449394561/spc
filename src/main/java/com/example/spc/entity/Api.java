package com.example.spc.entity;

import lombok.Data;

@Data
public class Api {
    private String apiErrorMsg;
    private String apiResponseID;
    private String apiResultCode;
    private String apiResultData;
}
