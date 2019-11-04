package com.ts.kaikei.services.impl;

import java.util.ArrayList;

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
	ArrayList<StatementVO> statList = getStatementList();	

	//CTB
	private ArrayList<StatementVO> jasan = null, buche = null, jabon = null, suick = null, biyong = null;
	ArrayList<int[]> CTB_dataList = new ArrayList<int[]>();
	int CTB_total[] = new int[4];
	
	//GL
	private ArrayList<ArrayList<String>> GL_dataList = null;
	private ArrayList<ArrayList<Integer>> GL_MonthlyTotal = null;
	private ArrayList<ArrayList<Integer>> GL_Total = null;
	
	//BS
	private ArrayList<Integer> BS_dataList = null;
	
	@Override
	public ArrayList<Integer> getBS_dataList(){
		return BS_dataList;
	}
	
	@Override
	public ArrayList<ArrayList<String>> getGL_dataList() {
		return GL_dataList;
	}

	@Override
	public ArrayList<ArrayList<Integer>> getGL_MonthlyTotal() {
		return GL_MonthlyTotal;
	}

	@Override
	public ArrayList<ArrayList<Integer>> getGL_Total() {
		return GL_Total;
	}
	
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
		return CTB_dataList;
	}

	@Override
	public int[] getTotal() {
		return CTB_total;
	}
	
	@Override
	//sort for CTB
	public void StatementSort() {
		
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
			
			if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 101 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 250 || Integer.parseInt(statList.get(i).getAccount_cd()) >= 961 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 980) {
				jasan.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 251 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 330) {
				buche.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 331 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 380) {
				jabon.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 401 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 412) {
				suick.add(statList.get(i));
			}
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 451 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 960 || Integer.parseInt(statList.get(i).getAccount_cd()) >= 981 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 999) {
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
			CTB_dataList.add(data);
		}

		//total Calcluator
		for(int i =0 ; i < CTB_dataList.size();i++) {
			for(int j = 0; j<4;j++) {
				CTB_total[j] += CTB_dataList.get(i)[j];
			}
		}
	}

	@Override
	//GL data find
	public void GL_Calculator() {
		int balance = getForwardBalance();
		//input GL data line
		for(int i =0; i< Act_cd.size();i++) {
			
			for(int j =0;j<getStatementList().size();j++) {
				if(Act_cd.get(i) == statList.get(j).getAccount_cd()) {
					ArrayList<String> data = null;
					data.add(Integer.toString(balance));
					data.add(statList.get(j).getDate());
					data.add(statList.get(j).getAbs());
					data.add(statList.get(j).getCustomer_cd());
					data.add(Integer.toString(statList.get(j).getDebtor()));
					data.add(Integer.toString(statList.get(j).getCreditor()));
					balance += statList.get(j).getDebtor() + statList.get(j).getCreditor();
					data.add(Integer.toString(balance));
					GL_dataList.add(data);
				}
			}
			
			//calc monthly total
			int lastMonth = 0;
			ArrayList<Integer> mothlyData = null;
			for(int j=0;j<GL_dataList.size();j++) {
				String month = GL_dataList.get(j).get(1).substring(3, 4); // get month
				int month_deb = 0;
				int month_cre = 0;
				if(Integer.parseInt(month) != lastMonth) {
					lastMonth = Integer.parseInt(month);
					month_deb += Integer.parseInt(GL_dataList.get(j).get(3)); //deb
					month_cre += Integer.parseInt(GL_dataList.get(j).get(4)); //cer				
				}
				mothlyData.add(Integer.parseInt(month));
				mothlyData.add(month_deb);
				mothlyData.add(month_cre);
				GL_MonthlyTotal.add(mothlyData);
			}

			int total_deb = 0 ;
			int total_cre = 0;
			int total_balance = 0;
			ArrayList<Integer> total_data = null;
			//calc total
			for(int j =0;j<GL_MonthlyTotal.size();i++) {
				total_deb += GL_MonthlyTotal.get(j).get(1);
				total_cre += GL_MonthlyTotal.get(j).get(2);
				total_balance = total_deb + total_cre;
				total_data.add(total_deb);
				total_data.add(total_cre);
				total_data.add(total_balance);
				GL_Total.add(total_data);
			}

		}
		
	}
	
	@Override
	public void BS_Calculator() {
		//jasan split
		int data1 = 0, data2 = 0;
		for(int i=0;i< jasan.size();i++) {
			
			if(Integer.parseInt(jasan.get(i).getAccount_cd()) >= 101 && Integer.parseInt(jasan.get(i).getAccount_cd()) <= 145) {
				data1 += jasan.get(i).getDebtor(); 
			}	
			if(Integer.parseInt(jasan.get(i).getAccount_cd()) >= 176 && Integer.parseInt(jasan.get(i).getAccount_cd()) <= 250 || Integer.parseInt(jasan.get(i).getAccount_cd()) >= 961 && Integer.parseInt(jasan.get(i).getAccount_cd()) <= 980) {
				data2 += jasan.get(i).getDebtor(); 
			}	
		}
		BS_dataList.add(data1);
		BS_dataList.add(data2);
		
		//buche split
		data1 = data2 = 0;
		for(int i=0;i< buche.size();i++) {
			
			if(Integer.parseInt(buche.get(i).getAccount_cd()) >= 251 && Integer.parseInt(buche.get(i).getAccount_cd()) <= 290) {
				data1 += buche.get(i).getDebtor(); 
			}	
			if(Integer.parseInt(buche.get(i).getAccount_cd()) >= 291 && Integer.parseInt(buche.get(i).getAccount_cd()) <= 330) {
				data2 += buche.get(i).getDebtor(); 
			}	
		}
		BS_dataList.add(data1);
		BS_dataList.add(data2);
		
		//jabon split
		data1 = data2 = 0;
		for(int i=0;i< jabon.size();i++) {
			
			if(Integer.parseInt(jabon.get(i).getAccount_cd()) == 331) {
				data1 += jabon.get(i).getDebtor(); 
			}	
			if(Integer.parseInt(jabon.get(i).getAccount_cd()) >= 351 && Integer.parseInt(jabon.get(i).getAccount_cd()) <= 371) {
				data2 += jabon.get(i).getDebtor(); 
			}	
		}
		BS_dataList.add(data1);
		BS_dataList.add(data2);
	}
	
	@Override
	public void PL_Calculator() {
		
	}
	
	//public void 
	private int getForwardBalance() {
		// TODO FowardBalance 
		return 0;
	}
}