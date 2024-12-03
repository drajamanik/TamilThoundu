package org.wotsoc.tamilthoundu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wotsoc.tamilthoundu.domain.TypingGame;
import org.wotsoc.tamilthoundu.jdbc.PostgresSQLDatabase;

public class TypingGameDAO
{
	public List<TypingGame> getGames(int levelId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.Typing_Game where level_id = ? order by seq_id");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, levelId);
		return getResultSet(ps.executeQuery());
	}
	
	public List<TypingGame> saveGames(int levelId) throws SQLException
	{
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("select * from public.Typing_Game where level_id = ? order by seq_id");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		ps.setInt(1, levelId);
		return getResultSet(ps.executeQuery());
	}

	
	public List<TypingGame> getResultSet(ResultSet rs) throws SQLException
	{
		List<TypingGame> pList = new ArrayList<TypingGame>();
		TypingGame  p=null;
		while(rs.next())
		{
			p = new TypingGame();
			p.setTgId(rs.getInt("tg_Id"));
			p.setLevelId(rs.getInt("level_id"));
			p.setSeqId(rs.getInt("seq_Id"));
			p.setWordCount(rs.getInt("word_count"));
			p.setLetterCount(rs.getInt("letter_count"));
			p.setTypeText(rs.getString("type_text"));
			pList.add(p);
		}
		return pList;
	}
	
	public void updateCounts(List<TypingGame> tgList) throws SQLException {
		PostgresSQLDatabase pd = PostgresSQLDatabase.getInstance();
		StringBuilder sb =new StringBuilder();
		sb.append("update public.typing_game set letter_count=?, word_count=? where tg_id=? ");
		PreparedStatement ps =pd.getConnetion().prepareStatement(sb.toString());
		try {
			for(TypingGame tg:tgList) {
				ps.setInt(1, tg.getLetterCount());
				ps.setInt(2, tg.getWordCount());
				ps.setInt(3, tg.getTgId());
				ps.addBatch();
			}
			ps.executeBatch();
		}finally{
			ps.close();
		}
	}
	
	public static void main(String args[]) throws SQLException {
		TypingGameDAO tgDao = new TypingGameDAO();
		List<TypingGame> tgList = tgDao.getGames(3);
		for(TypingGame tg: tgList) {
			System.out.println(tg);
			tg.setWordCount(tg.getTypeText().split(" ").length);
			tg.setLetterCount(tg.getTypeText().length());
		}
		//tgDao.updateCounts(tgList);
	}
}
