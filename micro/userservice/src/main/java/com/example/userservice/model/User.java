package com.example.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
    private String userId;
	private String password;
	private String name;
	private String email;
	private Contact contact;

}
