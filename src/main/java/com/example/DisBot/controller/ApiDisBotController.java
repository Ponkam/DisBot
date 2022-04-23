package com.example.DisBot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DisBot.data.dto.DisBotDto;

@RestController
public class ApiDisBotController {

	//TODO
	//ここではjsonで値を返すようにする。
//	そのためjson型を保管できるクラスが必要

	@RequestMapping(value = "/api" , method = RequestMethod.GET)
	@ResponseBody
	public DisBotDto apiIndex(@RequestBody DisBotDto disBot){
		System.out.println("Jsonだよ");
		return new DisBotDto();
	}
}
