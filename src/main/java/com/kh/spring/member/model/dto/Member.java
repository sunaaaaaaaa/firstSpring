package com.kh.spring.member.model.dto;

import java.sql.Date;

import lombok.Data;
//롬복으로 getter setter tostring등 다 만들어줌
@Data
public class Member {   
   
   private String userId;
   private String password;
   private String email;
   private String grade;
   private String tell;
   private Date rentableDate;
   private Date regDate;
   private int isLeave;
   
   
}