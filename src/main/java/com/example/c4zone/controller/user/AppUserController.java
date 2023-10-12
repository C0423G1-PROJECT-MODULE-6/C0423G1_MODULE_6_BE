package com.example.c4zone.controller.user;


import com.example.c4zone.common.user.ValidateAppUser;
import com.example.c4zone.config.JwtTokenUtil;
import com.example.c4zone.dto.user.AppUserDto;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.model.user.JwtResponse;
import com.example.c4zone.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;


    private static final String LOGIN_FAILED = "Đăng nhập thất bại";

    @GetMapping("/information/{id}")
    public ResponseEntity<Object> showInformation(@PathVariable Long id) {
        AppUser appUser = appUserService.findAppUserById(id);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("/login-by-username")
    public ResponseEntity<Object> loginByAccount(@Valid @RequestBody AppUserDto appUserDto,
                                                 BindingResult bindingResult) throws MessagingException, UnsupportedEncodingException {

        new AppUserDto().validate(appUserDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    appUserDto.getUserName(), appUserDto.getPassword()));
        } catch (DisabledException e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Tài khoản của bạn đã bị vô hiệu hoá");
        } catch (BadCredentialsException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(LOGIN_FAILED);
        }

        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);

        appUserService.generateOneTimePassword(appUser, passwordEncoder);

        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
        if (appUser != null) {
            if (passwordEncoder.matches(appUserDto.getOtp(), appUser.getOneTimePassword()) && appUser.isOTPRequired()) {

                UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUserName());

                String jwtToken = jwtTokenUtil.generateToken(userDetails);

                return ResponseEntity
                        .ok()
                        .body(new JwtResponse(jwtToken));

            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/resetOTP")
    public ResponseEntity<?> resetOTP(@RequestBody AppUserDto appUserDto) throws MessagingException, UnsupportedEncodingException {
        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
        if (appUser != null) {
            appUserService.generateOneTimePassword(appUser, passwordEncoder);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/register-by-manager")
    public ResponseEntity<Object> registerByManager(@RequestParam String userName) {

        String errMsg = ValidateAppUser.checkValidateOnlyAppUserName(userName);
        if (!errMsg.equals("")) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body(errMsg);
        }
        boolean userNameExisted = appUserService.existsByUsername(userName);
        if (userNameExisted) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Tài khoản này đã tồn tại");
        }
        AppUser appUser = new AppUser();
        appUser.setUserName(userName);
        appUser.setPassword(passwordEncoder.encode("123"));
        boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser,"ROLE_EMPLOYEE");
        if (!checkAddNewAppUser) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lát");
        }
        return ResponseEntity.ok("Đăng ký thành công");
    }




    @GetMapping("/logout/{userName}")
    public ResponseEntity<Object> logout(@PathVariable String userName) {
        boolean logout = appUserService.logout(userName);
        if (logout) {
            return ResponseEntity.ok("Đăng xuất thành công");
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Đăng xuất thất bại, vui lòng chờ trong giây lát");
    }

    @GetMapping("/get-id-app-user/{userName}")
    public ResponseEntity<Object> getIdByAppUserName(@PathVariable String userName){
        Long id = appUserService.findAppUserIdByUserName(userName);
        if(id == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
        return ResponseEntity.ok().body(id);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody AppUserDto appUserDto, BindingResult bindingResult) {
        new AppUserDto().validate(appUserDto, bindingResult);
        Map<String, String> errorMap= new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError: bindingResult.getFieldErrors()
            ) {
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_ACCEPTABLE);
        }


        AppUser appUser = new AppUser();
        appUser.setUserName(appUserDto.getUserName());
        appUser.setPassword(passwordEncoder.encode("123"));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser,"ROLE_ADMIN");
        if (!Boolean.TRUE.equals(checkAddNewAppUser)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lát");
        }
        return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
    }
}
