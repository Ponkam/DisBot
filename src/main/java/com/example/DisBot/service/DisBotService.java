package com.example.DisBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.DisBot.data.dto.DisBotDto;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

@Service
public class DisBotService {
//TODOシングルトンになるように考える
	@Autowired DisBotDto bot;

//	private static JDA jda;

	//ログイン処理
	public void discordBotLogin(String token){
		//ボットログイン処理
		bot.setClient(DiscordClientBuilder.create(token).build().login().block());
//		System.out.println(bot.getClient().toString().isEmpty() ? "login feild" : bot.getClient());
		System.out.println(bot.getClient().getGuilds().blockFirst().getName());
		bot.getClient().getGuilds();
	}

//	ログアウト処理
	public void discordBotLogout() {
		if(bot.getBotStatus()) {
			bot.getClient().logout().block();
		}else {
			System.out.println("ログアウトできませんでした");
			return;
	}
		bot.getClient().onDisconnect();
	}

	//非同期でメッセージをするメソッド
	@Async("MessageThread")
	public void asyncMessage()throws InterruptedException {
		bot.getClient().getEventDispatcher().on(MessageCreateEvent.class)
        .map(MessageCreateEvent::getMessage)
        .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
        .flatMap(Message::getChannel)
        .flatMap(channel -> channel.createMessage("ハロー"))
        .subscribe();

		bot.getClient().onDisconnect();
	}

	public void message(String message) {
		bot.getClient().onDisconnect();
	}


}
