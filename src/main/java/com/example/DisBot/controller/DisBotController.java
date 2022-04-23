package com.example.DisBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.DisBot.service.DisBotService;

//TODO serviseでロジックを考える
@RestController
public class DisBotController {

	//discordBotのビジネスロジック
	@Autowired DisBotService disService;
//	@Autowired DisBot bot;

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		mav.setViewName("index");
		System.out.println("こんにちは");
		return mav;
	}

	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav){
		mav.setViewName("login");
		return mav;
	}

    @RequestMapping(value = "/login" , method = RequestMethod.POST )
    public ModelAndView login(@RequestParam("token") String token , ModelAndView mav) {
    	disService.discordBotLogin(token);
    	mav.setViewName("main");

		try {
			disService.asyncMessage();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	return mav;
    }

    @RequestMapping(value = "/message" , method =RequestMethod.POST)
    public ModelAndView message(@RequestParam("message") String message , ModelAndView mav) {
    	disService.message(message);
    	mav.setViewName("main");
		return mav;

    }

    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
    public void logout() {
    	disService.discordBotLogout();
    }


}
