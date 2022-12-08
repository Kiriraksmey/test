package com.example.testingspringboot.response;

public class AjaxCourseResponseBody {

    private String message;
    private String errorCode;
    private Double amount;


    public AjaxCourseResponseBody() {
    }

    public AjaxCourseResponseBody(Double amount) {
        this.amount = amount;
    }

    public AjaxCourseResponseBody(String message, String errorCode, Double amount) {
        this.message = message;
        this.errorCode = errorCode;
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
