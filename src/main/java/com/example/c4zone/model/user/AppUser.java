package com.example.c4zone.model.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private Boolean flagDeleted;
    private Boolean flagOnline;
    private String employeeName;
    private String email;
    private String employeeCode;
    private String employeeAddress;
    private String employeePhone;
    private String employeeGender;

    @Lob
    private String employeeImage;
    private String employeeIdCard;
    private LocalDate employeeBirthday;
    private LocalDate employeeStartDate;

    private static final int OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes

    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime;

    @JsonBackReference
    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    private Set<UserRole> userRoleSet;

    public boolean isOTPRequired() {
        if (this.getOneTimePassword() == null) {
            return false;
        }

        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

        // OTP expires
        return otpRequestedTimeInMillis + OTP_VALID_DURATION >= currentTimeInMillis;
    }

    public AppUser(Long id, String userName, String password, Boolean flagDeleted, Boolean flagOnline, Set<UserRole> userRoleSet) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.flagDeleted = flagDeleted;
        this.flagOnline = flagOnline;
        this.userRoleSet = userRoleSet;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public Date getOtpRequestedTime() {
        return otpRequestedTime;
    }

    public void setOtpRequestedTime(Date otpRequestedTime) {
        this.otpRequestedTime = otpRequestedTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }

    public Boolean getFlagOnline() {
        return flagOnline;
    }

    public void setFlagOnline(Boolean flagOnline) {
        this.flagOnline = flagOnline;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }

}
