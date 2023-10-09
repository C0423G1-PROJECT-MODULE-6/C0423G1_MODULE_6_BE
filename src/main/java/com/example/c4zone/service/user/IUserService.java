package com.example.c4zone.service.user;

import com.example.c4zone.model.user.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String name); //Tim kiem User co ton tai trong DB khong?

    Boolean existsByUsername(String username); //username da co trong DB chua, khi tao du lieu

    Boolean existsByEmail(String email); //email da co trong DB chua

    User save(User user);

    void generateOneTimePassword(User user, PasswordEncoder passwordEncoder) throws MessagingException, UnsupportedEncodingException;

    void sendOTPEmail(User user, String OTP) throws MessagingException, UnsupportedEncodingException;

    void clearOTP(User user);
}
