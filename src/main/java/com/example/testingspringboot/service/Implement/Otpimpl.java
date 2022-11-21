//package com.example.testingspringboot.service.Implement;
//
//import com.example.testingspringboot.Repository.OtpRepository;
//import com.example.testingspringboot.entities.otp;
//import com.example.testingspringboot.service.otpservice;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.Base64;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class Otpimpl implements otpservice {
//
//    @Value("${otp.expire.in}")
//    private  long otpExpiredIn;
//
//    @Value("${otp.max.length}")
//    private  int otpMaxLength;
//
//    @Value("${mail.trap.username}")
//    private  String userNameMailTrap;
//
//    @Value("${mail.trap.password}")
//    private  String passwordMailTrap;
//
//    @Autowired
//    private OtpRepository otpRepository;
//
//    @Override
//    public String decodeStr(String s) {
//        byte[] decodeBytes = Base64.getDecoder().decode(s);
//        String decodeString = new String(decodeBytes);
//        return decodeString;
//    }
//
//    @Override
//    public String encodeStr(String s) {
//
//        String encodeString = Base64.getEncoder().encodeToString(s.getBytes());
//        return encodeString;
//    }
//
//    @Override
//    public String generateNewOtp() {
//        StringBuilder generateOTP = new StringBuilder();
//        SecureRandom secureRandom = new SecureRandom();
//        try {
//            secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());
//            for (int i = 0; i < otpMaxLength; i++){
//                generateOTP.append(secureRandom.nextInt(9));
//            }
//
//        } catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }
//        System.out.println(generateOTP.toString());
//        return generateOTP.toString();
//    }
//
//    @Override
//    public void sendOtp(String username, String otpCode) {
//
//    }
//
//    @Override
//    public long getOtpExpiredAt() {
//        long currentTime = new Date().getTime() + TimeUnit.MINUTES.toMillis(otpExpiredIn);
//        return  currentTime;
//    }
//
//    @Override
//    public boolean checkOtp(String otpCode) {
//        com.example.testingspringboot.entities.otp obj = null;
//        if(otpCode != null){
//            obj = otpRepository.findbyOtpCode(otpCode);
//        }
//        if(obj != null){
//            long otpExpiredAt = obj.getOtpExpiredAT();
//            long currentTime = new Date().getTime();
//            if (otpExpiredAt - currentTime > 0 && obj.isStatus() == true){
//                return  true;
//            }else {
//                otpRepository.delete(obj);
//            }
//        }
//        return false;
//    }
//}
