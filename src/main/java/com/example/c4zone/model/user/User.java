package com.example.c4zone.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    @NaturalId
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes

    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime;

    private String name;
    private String employeeCode;
    private String employeeAddress;
    private String employeePhone;
    @Lob
    private String employeeImage;
    private String employeeIdCard;
    private String employeeBirthday;
    private String employeeStartDate;

    @NaturalId
    private String email;

    @Column(columnDefinition = "bit(1) default true")
    private boolean employeeGender;

    @Column(columnDefinition = "bit(1) default true")
    private boolean flagDelete = true;


    public boolean isOTPRequired() {
        if (this.getOneTimePassword() == null) {
            return false;
        }

        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();

        // OTP expires
        return otpRequestedTimeInMillis + OTP_VALID_DURATION >= currentTimeInMillis;
    }


}
