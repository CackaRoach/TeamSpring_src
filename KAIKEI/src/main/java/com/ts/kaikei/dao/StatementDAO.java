package com.ts.kaikei.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.StatementVO;


@Mapper
public interface StatementDAO {

	public ArrayList<StatementVO> getStatementList();
	public ArrayList<ArrayList<StatementVO>> get_Sorted_Acconutlist();
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator();
	public ArrayList<Integer> PL_Calculator();
	public ArrayList<Integer> BS_Calculator();
	public ArrayList<int[]> CTB_Calculator();
	
}