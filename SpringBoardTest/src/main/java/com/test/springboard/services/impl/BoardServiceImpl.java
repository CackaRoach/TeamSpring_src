package com.test.springboard.services.impl;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboard.dao.BoardDAO;
import com.test.springboard.services.BoardService;

import com.test.springboard.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void addBoard(BoardVO boardVO) {
		boardDAO.addBoard(boardVO);
	}
	
	@Override
	public void deleteBoard(int idx) {
		boardDAO.deleteBoard(idx);
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList(Map<String, String> searchParams) {
		return boardDAO.getBoardListCond(searchParams);
	}
	
	@Override
	public BoardVO getBoardDetail(int idx) {
		return boardDAO.getBoardDetail(idx);
	}
	
	@Override
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);
	}

}
