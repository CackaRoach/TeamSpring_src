package com.test.springboard.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.test.springboard.vo.BoardVO;

@Mapper
public interface BoardDAO {
	// Board CRUD
	public void addBoard(BoardVO boardVO);
	public void deleteBoard(int idx);
	public ArrayList<BoardVO> getBoardList();
	public ArrayList<BoardVO> getBoardListCond(Map<String, String> searchParams);
	public BoardVO getBoardDetail(int idx);
	public void updateBoard(BoardVO boardVO);
}
