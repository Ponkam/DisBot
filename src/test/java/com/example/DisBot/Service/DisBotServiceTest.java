package com.example.DisBot.Service;

import com.example.DisBot.service.DisBotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DisBotServiceTest {
    private final DisBotService disBotService;
    private final String token;

    @Autowired
    public DisBotServiceTest(DisBotService disBotService){
        this.disBotService = disBotService;
        this.token = System.getenv("DISCORDTOKEN");
    }

    @Test
    void DisBotLogin() throws Exception{
        System.out.println("トークン：" + token);
        disBotService.discordBotLogin(token);
//        disBotService.discordBotLogout();
    }

    @Test
    void DisBotMessage() throws Exception{
        System.out.println("======MessageTest========");
        disBotService.discordBotLogin(token);
        disBotService.message("なんでも");
//        disBotService.asyncMessage();
//        disBotService.discordBotLogout();
    }
}