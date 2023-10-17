package com.example.c4zone.controller.user;


import com.example.c4zone.config.JwtTokenUtil;
import com.example.c4zone.dto.user.AppUserDto;
import com.example.c4zone.dto.user.UserInfoDto;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.model.user.JwtResponse;
import com.example.c4zone.service.user.IAppUserService;
import org.springframework.beans.BeanUtils;
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

    /**
     * method showInformation
     * Create HaiBH
     * Date 12-10-2023
     * param Long id
     * return ResponseEntity<>();
     */
    @GetMapping("/information/{id}")
    public ResponseEntity<Object> showInformation(@PathVariable Long id) {
        AppUser appUser = appUserService.findAppUserById(id);
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    /**
     * method editInformation
     * Create HaiBH
     * Date 12-10-2023
     * param UserInfoDto userInfoDto, BindingResult bindingResult
     * return ResponseEntity<>();
     */
    @PutMapping("/information/edit")
    public ResponseEntity<Object> editInformation(@Valid @RequestBody UserInfoDto userInfoDto,
                                                  BindingResult bindingResult) {
        AppUser appUser = appUserService.findAppUserById(userInfoDto.getId());
//        new AppUserDto().validate(userInfoDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        if (appUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(userInfoDto, appUser);
        appUserService.updateInfoUser(appUser);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    /**
     * method loginByAccount
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto, BindingResult bindingResult
     * return ResponseEntity<>();
     */
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

    /**
     * method confirm
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PostMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestBody AppUserDto appUserDto) {
        try {
            AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
            if (appUser != null) {
                if (passwordEncoder.matches(appUserDto.getOtp(), appUser.getOneTimePassword()) && appUser.isOTPRequired()) {

                    UserDetails userDetails = appUserService.loadUserByUsername(appUser.getUserName());

                    String jwtToken = jwtTokenUtil.generateToken(userDetails);

                    return ResponseEntity.ok().body(new JwtResponse(jwtToken));

                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    /**
     * method resetOTP
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PostMapping("/resetOTP")
    public ResponseEntity<?> resetOTP(@RequestBody AppUserDto appUserDto) throws MessagingException, UnsupportedEncodingException {
        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
        if (appUser != null) {
            appUserService.generateOneTimePassword(appUser, passwordEncoder);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * method register
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
//    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/register")
    public ResponseEntity<Object> register(@RequestBody AppUserDto appUserDto) throws MessagingException, UnsupportedEncodingException {

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
                    .body("Đổi mật khẩu không thành công");
        }

        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);

        appUserService.generateOneTimePassword(appUser, passwordEncoder);

        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    /**
     * method confirmRegister
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto
     * return ResponseEntity<>();
     */
    @PostMapping("/confirmRegister")
    public ResponseEntity<?> confirmRegister(@RequestBody AppUserDto appUserDto) {
        AppUser appUser = appUserService.findByUsername(appUserDto.getUserName()).orElse(null);
        if (appUser != null) {
            if (passwordEncoder.matches(appUserDto.getOtp(), appUser.getOneTimePassword()) && appUser.isOTPRequired()) {
                appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
                appUserService.updatePass(appUser);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * method logout
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return ResponseEntity<>();
     */
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

    /**
     * method getIdByAppUserName
     * Create HaiBH
     * Date 12-10-2023
     * param String userName
     * return ResponseEntity<>();
     */
    @GetMapping("/get-id-app-user/{userName}")
    public ResponseEntity<Object> getIdByAppUserName(@PathVariable String userName) {
        Long id = appUserService.findAppUserIdByUserName(userName);
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không có dữ liệu");
        }
        return ResponseEntity.ok().body(id);
    }

    /**
     * method create
     * Create HaiBH
     * Date 12-10-2023
     * param AppUserDto appUserDto, BindingResult bindingResult
     * return ResponseEntity<>();
     */
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AppUserDto appUserDto, BindingResult bindingResult) {
        new AppUserDto().validate(appUserDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()
            ) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.NOT_ACCEPTABLE);
        }


        AppUser appUser = new AppUser();
        appUser.setUserName(appUserDto.getUserName());
        appUser.setPassword(passwordEncoder.encode("123"));
        Boolean checkAddNewAppUser = appUserService.createNewAppUser(appUser, "ROLE_ADMIN");
        if (!Boolean.TRUE.equals(checkAddNewAppUser)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Đăng ký thất bại, vui lòng chờ trong giây lát");
        }
        return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
    }
}
