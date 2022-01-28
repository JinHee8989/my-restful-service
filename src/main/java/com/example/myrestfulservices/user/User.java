package com.example.myrestfulservices.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password","ssn"}) //명명한 필드만 보여지지 않도록 함
//@JsonFilter("userInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체") //swagger 커스터마이징에서 쓰임(객체 설명할 때)
@Entity
public class User {


    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해주세요.")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해주세요.")
    private Date joinDate;

    //    @JsonIgnore //외부에 노출되지 않도록 하는 어노테이션, 클라이언트가 받을때 해당 필드는 안보여지게 됨
    @ApiModelProperty(notes = "사용자 패스워드를 입력해주세요.")
    private String password;

    //    @JsonIgnore
    @ApiModelProperty(notes = "사용자 주민번호를 입력해주세요.")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    public User(int id, String name, Date date, String pwd, String ssn) {

        this.id = id;
        this.name = name;
        this.joinDate = date;
        this.password = pwd;
        this.ssn = ssn;
    }
}
