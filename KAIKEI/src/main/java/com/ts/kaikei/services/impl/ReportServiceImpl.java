package com.ts.kaikei.services.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.kaikei.dao.StatementDAO;
import com.ts.kaikei.services.ReportService;
import com.ts.kaikei.vo.StatementVO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private StatementDAO statementDAO;
	private ArrayList<String> Act_cd = new ArrayList<String>();
	private ArrayList<StatementVO> jasan = null, buche = null, jabon = null, suick = null, biyong = null;
	ArrayList<int[]> dataList = new ArrayList<int[]>();
	int total[] = new int[4];
	
	
	@Override
	public ArrayList<StatementVO> getStatementList() {
		// TODO Auto-generated method stub
		return statementDAO.getStatementList();
	}
	
	@Override
	public ArrayList<StatementVO> getJasanList(){
		return jasan;
	}
	
	@Override
	public ArrayList<StatementVO> getBucheList(){
		return buche;
	}
	
	@Override
	public ArrayList<StatementVO> getJabonList(){
		return jabon;
	}
	
	@Override
	public ArrayList<StatementVO> getSuickList(){
		return suick;
	}
	
	@Override
	public ArrayList<StatementVO> getBiyongList(){
		return biyong;
	}

	@Override
	public ArrayList<int[]> getDataList() {
		return dataList;
	}

	@Override
	public int[] getTotal() {
		return total;
	}
	
	@Override
	public void StatementSort() {
		ArrayList<StatementVO> statList = getStatementList();
		int data[] = new int[4];
		
		//sorting Account & insert Account Title
		for(int i=0; i<statList.size(); i++) {
			boolean flag = true;
			for(int j=0; j<Act_cd.size(); j++) {
				if(statList.get(i).getAccount_cd() == Act_cd.get(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				Act_cd.add(statList.get(i).getAccount_cd());
			}
			
			if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 101 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 240) {
				jasan.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 251 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 305) {
				buche.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 331 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 380) {
				jabon.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 401 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 412) {
				suick.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 451 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 999) {
				biyong.add(statList.get(i));
			}
			
		}
		
		//Calcluator 
		//Reference by : http://m.blog.daum.net/_blog/_m/articleView.do?blogid=0DCZr&articleno=17492948
		// https://modules.tistory.com/141
		
		for(int i = 0, j=0, k=0,l=0,m=0,n=0;i < Act_cd.size();i++) {
			if(Act_cd.get(i) == jasan.get(i).getAccount_cd()) {
				data[1] = jasan.get(j).getDebtor();
				data[2] = jasan.get(j++).getCreditor();
				data[0] = data[1] - data[2];
			}
			else if(Act_cd.get(i) == buche.get(i).getAccount_cd()) {
				data[1] = buche.get(k).getDebtor();
				data[2] = buche.get(k++).getCreditor();
				data[3] = data[2] - data[1];
			}
			else if(Act_cd.get(i) == jabon.get(i).getAccount_cd()) {
				data[1] = jabon.get(l).getDebtor();
				data[2] = jabon.get(l++).getCreditor();
				data[3] = data[2] - data[1];
			}
			else if(Act_cd.get(i) == suick.get(i).getAccount_cd()) {
				data[1] = suick.get(m).getDebtor();
				data[2] = suick.get(m++).getCreditor();
				data[3] = data[2] - data[1];
			}
			else if(Act_cd.get(i) == biyong.get(i).getAccount_cd()) {
				data[1] = biyong.get(n).getDebtor();
				data[2] = biyong.get(n++).getCreditor();
				data[0] = data[1] - data[2];
			}
			dataList.add(data);
		}

		//total Calcluator
		for(int i =0 ; i < dataList.size();i++) {
			for(int j = 0; j<4;j++) {
				total[j] += dataList.get(i)[j];
			}
		}
	}
}