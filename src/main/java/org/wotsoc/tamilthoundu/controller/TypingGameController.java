package org.wotsoc.tamilthoundu.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.wotsoc.tamilthoundu.dto.TypingGameForm;
import org.wotsoc.tamilthoundu.service.TypingService;

import com.google.gson.Gson;

@RestController
@RequestMapping("/type")
public class TypingGameController
{
	@RequestMapping(value = "/getGame",
            method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getGame(@RequestParam("userName") String userName,@RequestParam("levelId") Integer levelId) throws Exception {
		TypingService us = new TypingService();
		return new Gson().toJson(us.getGame(userName, levelId));
	}
	
	 @RequestMapping(value = "/saveGame", //
	            method = RequestMethod.POST) //,
	 @ResponseBody
	 public void saveGame(@RequestBody  TypingGameForm typeForm) throws Exception {
		TypingService us = new TypingService();
		us.saveGame(typeForm);
	}
}
