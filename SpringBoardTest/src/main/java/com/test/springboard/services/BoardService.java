package com.test.springboard.services;


import java.util.ArrayList;
import java.util.Map;

import com.test.springboard.vo.BoardVO;

public interface BoardService {
	public void addBoard(BoardVO boardVO);
	public void deleteBoard(int idx);
	public ArrayList<BoardVO> getBoardList();
	public ArrayList<BoardVO> getBoardList(Map<String, String> searchParams);
	public BoardVO getBoardDetail(int idx);
	public void updateBoard(BoardVO boardVO);
}
