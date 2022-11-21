//package com.example.testingspringboot.entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="otp")
//public class otp {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private  String otpid;
//    private String otpCode;
//    private String userid;
//    private  long otpExpiredAT;
//    private  boolean status = false;
//
//    public otp() {
//    }
//
//    public otp(String otpid, String otpCode, String userid, long otpExpiredAT, boolean status) {
//        this.otpid = otpid;
//        this.otpCode = otpCode;
//        this.userid = userid;
//        this.otpExpiredAT = otpExpiredAT;
//        this.status = status;
//    }
//
//    public String getOtpid() {
//        return otpid;
//    }
//
//    public void setOtpid(String otpid) {
//        this.otpid = otpid;
//    }
//
//    public String getOtpCode() {
//        return otpCode;
//    }
//
//    public void setOtpCode(String otpCode) {
//        this.otpCode = otpCode;
//    }
//
//    public String getUserid() {
//        return userid;
//    }
//
//    public void setUserid(String userid) {
//        this.userid = userid;
//    }
//
//    public long getOtpExpiredAT() {
//        return otpExpiredAT;
//    }
//
//    public void setOtpExpiredAT(long otpExpiredAT) {
//        this.otpExpiredAT = otpExpiredAT;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//}
