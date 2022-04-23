package com.example.DisBot.data.dto;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class UserDto {
	private String userId;
	private String userName;
	//TODO アノテーションでメールアドレスのバリデーションをする。
	private String emailAddress;
}
