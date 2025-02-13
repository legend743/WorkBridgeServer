package com.profinder.WorkBridgeServer.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor




public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private  String lastname;
    private String email;
    private String password;
    private String roles;

}
