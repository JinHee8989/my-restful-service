package com.example.myrestfulservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password","ssn"}) //명명한 필드만 보여지지 않도록 함
public class User {
    private Integer id;

    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;

    @Past
    private Date joinDate;

//    @JsonIgnore //외부에 노출되지 않도록 하는 어노테이션, 클라이언트가 받을때 해당 필드는 안보여지게 됨
    private String password;

//    @JsonIgnore
    private String ssn;
}
