package com.example.controllerAdvice.business.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class JsonResponseModel(
    var code: Int?,
    var msgCode: String?,
)
