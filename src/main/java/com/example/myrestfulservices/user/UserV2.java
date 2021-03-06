package com.example.myrestfulservices.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password","ssn"}) //명명한 필드만 보여지지 않도록 함
@JsonFilter("userInfoV2")
public class UserV2 extends User{
   private String grade;
}
