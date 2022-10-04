package com.example.DisBot.service;

import discord4j.core.object.entity.channel.GuildChannel;
import discord4j.discordjson.Id;
import discord4j.discordjson.json.*;
import discord4j.discordjson.possible.Possible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.DisBot.data.dto.DisBotDto;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

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
	}

	public void message(String message) {
//		Message msg = new Message(bot.getClient() ,data);
//		msg.getChannel().subscribe();
		Flux<GuildChannel> channelid = bot.getClient().getGuildChannels(bot.getClient().getGuilds().blockFirst().getId());
		System.out.println(channelid);
		bot.getClient().onDisconnect();
	}


}
