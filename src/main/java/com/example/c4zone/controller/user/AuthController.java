package com.example.c4zone.controller.user;


import com.example.c4zone.dto.user.request.OtpUser;
import com.example.c4zone.dto.user.request.SignInForm;
import com.example.c4zone.dto.user.request.SignUpForm;
import com.example.c4zone.dto.user.response.ResponMessage;
import com.example.c4zone.model.user.Role;
import com.example.c4zone.model.user.RoleName;
import com.example.c4zone.model.user.User;
import com.example.c4zone.security.jwt.JwtProvider;
import com.example.c4zone.security.userprincal.UserPrinciple;
import com.example.c4zone.service.user.IRoleService;
import com.example.c4zone.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponMessage("no user"), HttpStatus.OK);
        }
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponMessage("no email"), HttpStatus.OK);
        }
        User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), passwordEncoder.encode(signUpForm.getPassword()));
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(() -> new RuntimeException("Role not found")
                    );
                    roles.add(adminRole);
                    break;
                case "business":
                    Role businessRole = roleService.findByName(RoleName.BUSINESS).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(businessRole);
                    break;
                case "inventory":
                    Role inventoryRole = roleService.findByName(RoleName.INVENTORY).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(inventoryRole);
                    break;
                case "sale":
                    Role saleRole = roleService.findByName(RoleName.SALE).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(saleRole);
                    break;
            }
        });
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new ResponMessage("create successfully"), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) throws MessagingException, UnsupportedEncodingException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        User user = userService.findByUsername(userPrinciple.getUsername()).orElse(null);
        userService.generateOneTimePassword(user, passwordEncoder);
//        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getEmail(), userPrinciple.getAuthorities()));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestBody OtpUser otpUser) {
        User user = userService.findByUsername(otpUser.getUsername()).orElse(null);
        if (user != null) {
            if (passwordEncoder.matches(otpUser.getOtp(), user.getOneTimePassword()) && user.isOTPRequired()) {
                return new ResponseEntity<>(new ResponMessage("login successfully"), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponMessage("login fail"), HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(new ResponMessage("login fail"), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/resetOTP")
    public ResponseEntity<?> resetOTP(@RequestBody OtpUser otpUser) throws MessagingException, UnsupportedEncodingException {
        User user = userService.findByUsername(otpUser.getUsername()).orElse(null);
        if (user != null) {
            userService.generateOneTimePassword(user, passwordEncoder);
            return new ResponseEntity<>(new ResponMessage("login successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponMessage("login fail"), HttpStatus.NO_CONTENT);
    }
}
