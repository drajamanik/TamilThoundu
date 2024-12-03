package org.wotsoc.tamilthoundu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.wotsoc.tamilthoundu.dao.TypingConfigDao;
import org.wotsoc.tamilthoundu.dao.TypingGameDAO;
import org.wotsoc.tamilthoundu.dao.UserDao;
import org.wotsoc.tamilthoundu.dao.UserHistoryDAO;
import org.wotsoc.tamilthoundu.domain.TypingConfig;
import org.wotsoc.tamilthoundu.domain.TypingGame;
import org.wotsoc.tamilthoundu.domain.User;
import org.wotsoc.tamilthoundu.domain.UserHistory;
import org.wotsoc.tamilthoundu.dto.TypingGameForm;

public class TypingService
{
	public TypingGameForm getGame(String userName, int levelId) throws Exception{
		TypingGameForm 	tgForm	= new TypingGameForm();
		UserHistoryDAO 	uhDao 	= new UserHistoryDAO();
		TypingConfigDao tcDao 	= new TypingConfigDao();
		TypingGameDAO 	tgDao 	= new TypingGameDAO();
		UserDao			userDao	= new UserDao();
		User			user 	= userDao.getUser(null,userName);	
		List<UserHistory>  usList 	= uhDao.getUserHistory(user.getUserId(), levelId);
		List<TypingConfig> tcList 	= tcDao.getConfig(levelId,"char", "minute");
		List<TypingGame>   tgList 	= tgDao.getGames(levelId);
		UserHistory us =null;
		TypingConfig tc = null;
		
		tgForm.setUserId(user.getUserId());
		tgForm.setUserName(userName);
		tgForm.setLevelId(levelId);
		
		int seqId = 1;
		if(!usList.isEmpty()) {
			us = usList.get(0);
			seqId = us.getSeqId();
		}
		if(!tcList.isEmpty()) {
			tc = tcList.get(0);
			tgForm.setTimer(tc.getTime());
			tgForm.setTimerUnit(tc.getTimeUnit());
		}
		
		Integer counts[]=new Integer[] {0,0};
		List<String> dataList = new ArrayList<>();
		counts = getData(tgList, seqId, counts[0],counts[1], tc, dataList);
		if(tc!=null && counts[0] <= tc.getEndRange()){
			seqId= 1;
			getData(tgList, seqId, counts[0],counts[1], tc, dataList);
		}
		tgForm.setLetterCount(counts[0]);
		tgForm.setWordCount(counts[1]);
		tgForm.setDataList(dataList);
		return tgForm;
	}
	
	private Integer[] getData(List<TypingGame> tgList, int seqId,int letterCount,int wordCount,TypingConfig tc, List<String> dataList) {
		for(TypingGame tg:tgList) {
			if(tg.getSeqId() >= seqId ) {//1 =245
				letterCount = letterCount + tg.getLetterCount();
				wordCount = wordCount + tg.getWordCount();
				if(tc!=null && letterCount <= tc.getEndRange()){
					dataList.add(tg.getTypeText());
				}else {
					break;
				}
			}
		}
		return new Integer[] {letterCount,wordCount};
	}
	
	public UserHistory saveGame(TypingGameForm typeForm) throws Exception {
		UserHistoryDAO 	uhDao 	= new UserHistoryDAO();
		UserHistory userHistory = convertUserHistory(typeForm);
		return uhDao.createUserHistory(userHistory);
	}
	
	private UserHistory convertUserHistory(TypingGameForm typeForm) throws Exception {
		UserHistory uh = new UserHistory();
		uh.setProjectId(3);
		uh.setProfileId(1);
		uh.setSeqId(1);
		UserDao userDao = new UserDao();
		User	user 	= userDao.getUser(null,typeForm.getUserName());
		uh.setUserId(user.getUserId());
		uh.setLevelId(typeForm.getLevelId());
		uh.setStartTime(typeForm.getStartTime());
		uh.setEndTime(typeForm.getEndTime());
		uh.setTotalCount(typeForm.getTotalCount());
		uh.setErrorCount(typeForm.getErrorCount());
		uh.setIp(typeForm.getIp());
		uh.setDeviceDetail(typeForm.getDeviceDetail());
		uh.setTimer(typeForm.getTimer());
		uh.setErrorData(typeForm.getIncorrectWordsList().toString());
		return uh;
	}
	
	public static void main(String args[]) throws Exception {
		TypingService ts = new TypingService();
		System.out.println(ts.getGame("raj", 1));
		System.out.println(ts.getGame("raj", 3));
		TypingGameForm tgf = new TypingGameForm();
		
		tgf.setUserName("elaya");
		tgf.setLevelId(1);
		tgf.setTimer(1l);
		tgf.setStartTime(new Date());
		tgf.setEndTime(new Date());
		tgf.setTimerUnit("minute");
		tgf.setWordCount(15);
		tgf.setLetterCount(200);
		tgf.setTotalCount(15);
		tgf.setErrorCount(3);
		tgf.setIp("192.1.1.1");;
		tgf.setDeviceDetail("Chrome");
		Map<String,List<Object>>	incorrectWordsList = new HashMap<String,List<Object>>();
		String[] strArr = new String[] {"மூன்ற","மூன்"};
		incorrectWordsList.put("மூன்று",Arrays.asList(strArr));
		tgf.setIncorrectWordsList(incorrectWordsList);
		System.out.println(ts.saveGame(tgf));
	}
}
