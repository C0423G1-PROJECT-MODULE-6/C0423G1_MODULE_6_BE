package com.example.c4zone.service.user.impl;

import com.example.c4zone.service.user.IAppUserService;
import com.example.c4zone.dto.user.JwtResponseUserDetails;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.model.user.UserRole;
import com.example.c4zone.repository.user.IAppUserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private IAppUserRepository appUserRepository;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User name or password is wrong");
        }

        List<GrantedAuthority> grantList = new ArrayList<>();
        for (UserRole userRole : appUser.getUserRoleSet()) {
            grantList.add(new SimpleGrantedAuthority(userRole.getAppRole().getName()));
        }
        UserDetails userDetails = new JwtResponseUserDetails(
                appUser.getUserName(),
                appUser.getPassword(),
                appUser.getFlagOnline(),
                grantList);
        appUserRepository.updateAppUserIsOnline(appUser);
        return userDetails;
    }


    @Override
    public Boolean existsByUsername(String userName) {
        AppUser appUser = appUserRepository.findAppUserByName(userName);
        return appUser != null;
    }


    @Override
    public Boolean createNewAppUser(AppUser appUser,String role) {
        AppUser currentAppUser = appUserRepository.findAppUserByName(appUser.getUserName());
        if (currentAppUser == null) {
            Integer amountAppUserCreated = appUserRepository.addNewAppUser(appUser);
            Long roleId = appUserRepository.findAppRoleIdByName(role);
            currentAppUser = appUserRepository.findAppUserByName(appUser.getUserName());
            appUserRepository.insertRoleForCustomer(roleId, currentAppUser.getId());
            return amountAppUserCreated > 0;
        }
        return false;
    }


    @Override
    public Boolean logout(String userName) {
        return appUserRepository.updateAppUserIsOffline(userName) > 0;
    }

    @Override
    public Long findAppUserIdByUserName(String userName) {
        return appUserRepository.findIdByUserName(userName);
    }
    @Override
    public boolean existsById(Long id){
        return appUserRepository.existsById(id);
    }

    @Override
    public void generateOneTimePassword(AppUser appUser, PasswordEncoder passwordEncoder) throws MessagingException, UnsupportedEncodingException {
        String OTP = RandomString.make(8);
        String encodedOTP = passwordEncoder.encode(OTP);

        appUser.setOneTimePassword(encodedOTP);
        appUser.setOtpRequestedTime(new Date());

        appUserRepository.updateOtp(appUser);

        sendOTPEmail(appUser, OTP);
    }

    @Override
    public void sendOTPEmail(AppUser appUser, String OTP) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("contact@shopme.com", "Shopme Support");
        helper.setTo(appUser.getEmail());

        String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";

        String content = "<p>Hello " + appUser.getEmployeeName() + "</p>"
                + "<p>For security reason, you're required to use the following "
                + "One Time Password to login:</p>"
                + "<p><b>" + OTP + "</b></p>"
                + "<br>"
                + "<p>Note: this OTP is set to expire in 5 minutes.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public void updateOtp(AppUser appUser) {
         appUserRepository.updateOtp(appUser);
    }

    @Override
    public Optional<AppUser> findByUsername(String name) {
        return appUserRepository.findAppUserByUserName(name);
    }

    @Override
    public AppUser findAppUserById(Long id) {
        return appUserRepository.findAppUserById(id);
    }

    @Override
    public void updateInfoUser(AppUser appUser) {
        appUserRepository.updateInfoUser(appUser);
    }

    @Override
    public void updatePass(AppUser appUser) {
        appUserRepository.updatePass(appUser);
    }
}