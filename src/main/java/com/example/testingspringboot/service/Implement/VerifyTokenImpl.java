package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.VerifyTokenRepository;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.entities.VerifyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class VerifyTokenImpl  {
    private  final VerifyTokenRepository verifyTokenRepository;

    @Autowired
    public VerifyTokenImpl(VerifyTokenRepository verifyTokenRepository) {
        this.verifyTokenRepository = verifyTokenRepository;
    }
    @Transactional
    public VerifyToken findByToken(String token){
        return verifyTokenRepository.findByToken(token);
    }
    @Transactional
    public  VerifyToken findByUser(User user){
        return  verifyTokenRepository.findByUser(user);
    }
    @Transactional
    public  void save(User user, String token){
        VerifyToken verifyToken=new VerifyToken(token , user);
        // set expiry date
        verifyToken.setExperyDate(calculateExpiryDate(24*60));
        verifyTokenRepository.save(verifyToken);
    }
    //calculate expiry date
    private Timestamp calculateExpiryDate(int expiryTimeInMinute){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, expiryTimeInMinute);
        return  new Timestamp(cal.getTime().getTime());
    }
}
