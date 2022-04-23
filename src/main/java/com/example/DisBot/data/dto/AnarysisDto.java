package com.example.DisBot.data.dto;

import org.springframework.context.annotation.Configuration;

import lombok.Data;

//anarysisテーブルはbotが管理しているchannel内のユーザのステータスが切り替わるたびに記録をする。
@Data
@Configuration
public class AnarysisDto {
	private String userID;			//botの所有者を確認するために使用
	private String token;			//botを識別するために使用
	private String channelID; 		//管理しているchannelを保持
	private String daysAndTimes;	//yyyy/mm/dd　HH:MM:ss で保持する。channel内でユーザのステータスの変更があった場合に時間を保持する。
	private int loginCount;			//ログインしているユーザー数を保持
//	private String gameCount;
	private String playContentName;
}
