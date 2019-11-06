package com.ts.kaikei.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.StatementVO;


@Mapper
public interface StatementDAO {

	public ArrayList<StatementVO> getStatementList();
	
	public ArrayList<StatementVO> getJasanList();
	public ArrayList<StatementVO> getBucheList();
	public ArrayList<StatementVO> getJabonList();
	public ArrayList<StatementVO> getSuickList();
	public ArrayList<StatementVO> getBiyongList();
	public ArrayList<ArrayList<String>> getGL_dataList();
	public ArrayList<ArrayList<Integer>> getGL_MonthlyTotal();
	public ArrayList<ArrayList<Integer>> getGL_Total();
	public ArrayList<Integer> getBS_dataList();
	public ArrayList<Integer> getPL_dataList();
	public ArrayList<int[]> getDataList();
	
	public void GL_Calculator();
	public void PL_Calculator();
	public void BS_Calculator();
	public int[] getTotal();
	public void StatementSort();
	
}