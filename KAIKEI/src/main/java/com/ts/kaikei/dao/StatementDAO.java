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
	public void GLinit();
	public ArrayList<int[]> getDataList();
	public int[] getTotal();
	public void StatementSort();
}