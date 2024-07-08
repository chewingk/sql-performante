package com.chewingk.sql.index.domain.persistent;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePo {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String idNumber;
    private Character gender;
    private String email;
    private Date dateOfBirth;
    private String address;
    private String zipCode;
    private BigDecimal salary;
    private String department;
    private Date joinDate;
    private String status;
}
