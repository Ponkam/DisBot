package com.example.DisBot.data.dto;

import org.springframework.context.annotation.Configuration;

import discord4j.core.GatewayDiscordClient;
import lombok.Data;


@Data
@Configuration
public class DisBotDto {
	//ボットの名前
	private String botName;
	//トークン
	private String botToken;
	//ボットのログインステータス
	private Boolean botStatus = false;
	//ボット自体みたいなもの
	private GatewayDiscordClient client;
}
