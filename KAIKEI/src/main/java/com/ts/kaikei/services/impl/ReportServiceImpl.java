
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
	
	@Override
	public ArrayList<StatementVO> getStatementList() {
		return statementDAO.getStatementList();
	}
	
	private ArrayList<String> Account_CD_List(){
		ArrayList<StatementVO> statList = statementDAO.getStatementList();
		ArrayList<String> Act_cd = new ArrayList<String>();

		boolean flag = true;
		for(int i=0; i<statList.size(); i++) {
			flag = true;
			for(int j=0; j<Act_cd.size(); j++) {
				if(statList.get(i).getAccount_cd() == Act_cd.get(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				Act_cd.add(statList.get(i).getAccount_cd());
			}
		}
		return Act_cd;
	}
	
	//sorting Account & insert Account Title
	private ArrayList<ArrayList<StatementVO>> Sorting_Account(){
		ArrayList<ArrayList<StatementVO>> Sorted_Acconutlist = new ArrayList<ArrayList<StatementVO>>();
		ArrayList<StatementVO> statList = new ArrayList<StatementVO>();
		ArrayList<StatementVO> jasan = new ArrayList<StatementVO>();
		ArrayList<StatementVO> buche = new ArrayList<StatementVO>();
		ArrayList<StatementVO> jabon = new ArrayList<StatementVO>();
		ArrayList<StatementVO> suick = new ArrayList<StatementVO>();
		ArrayList<StatementVO>  biyong = new ArrayList<StatementVO>();
		
		statList = statementDAO.getStatementList();

		for(int i=0; i<statList.size(); i++) {
			// jasan 101 ~ 250, 961 ~ 980
			if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 101 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 250 || Integer.parseInt(statList.get(i).getAccount_cd()) >= 961 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 980) {
				jasan.add(statList.get(i));
			}
			// buche 251 ~ 330
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 251 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 330) {
				buche.add(statList.get(i));
			}
			// jabon 331 ~ 380
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 331 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 380) {
				jabon.add(statList.get(i));
			}
			// suick 401 ~ 420
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 401 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 420) {
				suick.add(statList.get(i));
			}
			// biyong 451 ~ 960, 981~ 999
			else if(Integer.parseInt(statList.get(i).getAccount_cd()) >= 451 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 960 || Integer.parseInt(statList.get(i).getAccount_cd()) >= 981 && Integer.parseInt(statList.get(i).getAccount_cd()) <= 999) {
				biyong.add(statList.get(i));
			}
		}
		Sorted_Acconutlist.add(jasan);
		Sorted_Acconutlist.add(buche);
		Sorted_Acconutlist.add(jabon);
		Sorted_Acconutlist.add(suick);
		Sorted_Acconutlist.add(biyong);
		
		return Sorted_Acconutlist;
	}
	
	public ArrayList<ArrayList<StatementVO>> get_Sorted_Acconutlist() {
		ArrayList<ArrayList<StatementVO>> Sorted_Acconutlist = new ArrayList<ArrayList<StatementVO>>();
		Sorted_Acconutlist = Sorting_Account();
		return Sorted_Acconutlist;
	}
	
	@Override
	// CTB Calcluator 
	public ArrayList<int[]> CTB_Calculator() {
		ArrayList<String> Act_cd = Account_CD_List();
		ArrayList<ArrayList<StatementVO>> Sorted_Acconutlist = Sorting_Account();
		ArrayList<int[]> CTB_dataList = new ArrayList<int[]>();
		int CTB_total[] = new int[4];
		int CTB_data[] = new int[4];
		
		// Reference by : http://m.blog.daum.net/_blog/_m/articleView.do?blogid=0DCZr&articleno=17492948
		// https://modules.tistory.com/141
		for(int i = 0, j=0, k=0,l=0,m=0,n=0;i < Act_cd.size();i++) {
			if(Act_cd.get(i) == Sorted_Acconutlist.get(0).get(j).getAccount_cd()) { //jasan
				CTB_data[1] = Integer.parseInt(Sorted_Acconutlist.get(0).get(j).getDebtor());
				CTB_data[2] = Integer.parseInt(Sorted_Acconutlist.get(0).get(j++).getCreditor());
				CTB_data[0] = CTB_data[1] - CTB_data[2];
			}
			else if(Act_cd.get(i) == Sorted_Acconutlist.get(0).get(k).getAccount_cd()) {
				CTB_data[1] = Integer.parseInt(Sorted_Acconutlist.get(1).get(k).getDebtor());
				CTB_data[2] = Integer.parseInt(Sorted_Acconutlist.get(1).get(k++).getCreditor());
				CTB_data[3] = CTB_data[2] - CTB_data[1];
			}
			else if(Act_cd.get(i) == Sorted_Acconutlist.get(0).get(l).getAccount_cd()) {
				CTB_data[1] = Integer.parseInt(Sorted_Acconutlist.get(2).get(l).getDebtor());
				CTB_data[2] = Integer.parseInt(Sorted_Acconutlist.get(2).get(l++).getCreditor());
				CTB_data[3] = CTB_data[2] - CTB_data[1];
			}
			else if(Act_cd.get(i) == Sorted_Acconutlist.get(0).get(m).getAccount_cd()) {
				CTB_data[1] = Integer.parseInt(Sorted_Acconutlist.get(3).get(m).getDebtor());
				CTB_data[2] = Integer.parseInt(Sorted_Acconutlist.get(3).get(m++).getCreditor());
				CTB_data[3] = CTB_data[2] - CTB_data[1];
			}
			else if(Act_cd.get(i) == Sorted_Acconutlist.get(0).get(n).getAccount_cd()) {
				CTB_data[1] = Integer.parseInt(Sorted_Acconutlist.get(4).get(n).getDebtor());
				CTB_data[2] = Integer.parseInt(Sorted_Acconutlist.get(4).get(n++).getCreditor());
				CTB_data[0] = CTB_data[1] - CTB_data[2];
			}
			CTB_dataList.add(CTB_data);
		}

		//total Calcluator
		for(int i =0 ; i < CTB_dataList.size();i++) {
			for(int j = 0; j<CTB_total.length;j++) {
				CTB_total[j] += CTB_dataList.get(i)[j];
			}
		}
		CTB_dataList.add(CTB_total);
		
		return CTB_dataList;
	}
	
	@Override
	//GL data find
	public ArrayList<ArrayList<ArrayList<String>>> GL_Calculator() {
		ArrayList<ArrayList<ArrayList<String>>> GL_List = new ArrayList<ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<String>> Daily_dataList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> Monthly_dataList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> Totaly_dataList = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> act_cd = new ArrayList<ArrayList<String>>();
		
		ArrayList<StatementVO> statList = statementDAO.getStatementList();
		ArrayList<String> Act_cd = Account_CD_List();
		int ForwardBalance = getForwardBalance();
		
		for(int i =0; i< Act_cd.size();i++) {
			for(int j =0;j<statList.size();j++) {
				if(Act_cd.get(i) == statList.get(j).getAccount_cd()) {
					//add Act_cd
					ArrayList<String> act = new ArrayList<String>();
					act.add(statList.get(j).getAccount_cd());
					act_cd.add(act);
					
					//calc daily
					ArrayList<String> GL_data = new ArrayList<String>();
					int Day_balance = 0;
					GL_data.add(Integer.toString(ForwardBalance));
					GL_data.add(statList.get(j).getDate());
					GL_data.add(statList.get(j).getAbs());
					GL_data.add(statList.get(j).getCustomer_cd());
					GL_data.add(statList.get(j).getDebtor());
					GL_data.add(statList.get(j).getCreditor());
					Day_balance += Integer.parseInt(statList.get(j).getDebtor()) + Integer.parseInt(statList.get(j).getCreditor());
					GL_data.add(Integer.toString(Day_balance));
					GL_data.add(statList.get(j).getAccount_cd());
					
					Daily_dataList.add(GL_data);
					
				}
			}
		}
		//calc monthly total
		ArrayList<String> mothlyData;
		int lastMonth = 0;
		int month_deb = 0;
		int month_cre = 0;
		int month_balance = 0;

		for(int k=0;k<Daily_dataList.size();k++) {
			mothlyData = new ArrayList<String>();
			String month = Daily_dataList.get(k).get(1).substring(0, 2); // get month // 0 = balance, 1 = date
			if(Integer.parseInt(month) != lastMonth) {
				lastMonth = Integer.parseInt(month);
				
			}
			else {
				//mothlyData.add("0");
				month_deb = month_cre = month_balance = 0;
			}
			mothlyData.add(month);
			month_deb += Integer.parseInt(Daily_dataList.get(k).get(4)); //deb
			month_cre += Integer.parseInt(Daily_dataList.get(k).get(5)); //cre		
			month_balance += Integer.parseInt(Daily_dataList.get(k).get(6));	
			
			mothlyData.add(Integer.toString(month_deb));
			mothlyData.add(Integer.toString(month_cre));
			mothlyData.add(Integer.toString(month_balance));
			Monthly_dataList.add(mothlyData);
		}

		//calc total
		ArrayList<String> total_data;
		int total_deb = 0 ;
		int total_cre = 0;
		int total_balance = 0;
		
		for(int k =0;k<Monthly_dataList.size();k++) {
			total_data = new ArrayList<String>();
			total_deb += Integer.parseInt(Monthly_dataList.get(k).get(0)); //deb
			total_cre += Integer.parseInt(Monthly_dataList.get(k).get(1)); //cre
			total_balance = total_deb + total_cre;
			total_data.add(Integer.toString(total_deb));
			total_data.add(Integer.toString(total_cre));
			total_data.add(Integer.toString(total_balance));
			Totaly_dataList.add(total_data);
		}

		GL_List.add(Daily_dataList);
		GL_List.add(Monthly_dataList);
		GL_List.add(Totaly_dataList);
		GL_List.add(act_cd);
		
		return GL_List;
	}
	
	private int getForwardBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
		// Balance sheet Logic
		// ref :
		// http://blog.naver.com/PostView.nhn?blogId=ako92&logNo=220534204188&parentCategoryNo=&categoryNo=22&viewDate=&isShowPopularPosts=false&from=postView
		// https://post.naver.com/viewer/postView.nhn?volumeNo=15893236&memberNo=9353678
	public ArrayList<Integer> BS_Calculator() {
		ArrayList<ArrayList<StatementVO>> Sorted_Acconutlist = Sorting_Account();
		ArrayList<Integer> BS_dataList = new ArrayList<Integer>();
		
		//jasan split 
		int data1 = 0, data2 = 0;
		
		for(int i=0;i< Sorted_Acconutlist.get(0).size();i++) {
			// 101 ~ 145
			if(Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getAccount_cd()) >= 101 && Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getAccount_cd()) <= 145) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getDebtor()); 
			}	
			//  176 ~ 250,  961 ~ 980
			if(Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getAccount_cd()) >= 176 && Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getAccount_cd()) <= 250 || Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getAccount_cd()) >= 961 && Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getAccount_cd()) <= 980) {
				data2 += Integer.parseInt(Sorted_Acconutlist.get(0).get(i).getDebtor()); 
			}	
		}
		BS_dataList.add(data1);
		BS_dataList.add(data2);
		
		//buche split
		data1 = data2 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(1).size();i++) {
			// 251 ~ 290
			if(Integer.parseInt(Sorted_Acconutlist.get(1).get(i).getAccount_cd()) >= 251 && Integer.parseInt(Sorted_Acconutlist.get(1).get(i).getAccount_cd()) <= 290) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(1).get(i).getCreditor()); 
			}	
			// 291 ~ 330
			if(Integer.parseInt(Sorted_Acconutlist.get(1).get(i).getAccount_cd()) >= 291 && Integer.parseInt(Sorted_Acconutlist.get(1).get(i).getAccount_cd()) <= 330) {
				data2 += Integer.parseInt(Sorted_Acconutlist.get(1).get(i).getCreditor()); 
			}	
		}
		BS_dataList.add(data1);
		BS_dataList.add(data2);
		
		//jabon split
		data1 = data2 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(2).size();i++) {
			// 331
			if(Integer.parseInt(Sorted_Acconutlist.get(2).get(i).getAccount_cd()) == 331) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(2).get(i).getCreditor()); 
			}	
			// 351 ~ 371
			if(Integer.parseInt(Sorted_Acconutlist.get(2).get(i).getAccount_cd()) >= 351 && Integer.parseInt(Sorted_Acconutlist.get(2).get(i).getAccount_cd()) <= 371) {
				data2 += Integer.parseInt(Sorted_Acconutlist.get(2).get(i).getCreditor()); 
			}	
		}
		BS_dataList.add(data1);
		BS_dataList.add(data2);
		
		return BS_dataList;
	}
	
	@Override
	// PL Logic 
	// ref : https://j-dono.tistory.com/entry/%EC%86%90%EC%9D%B5%EA%B3%84%EC%82%B0%EC%84%9C%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%9E%91%EC%84%B1%ED%95%A0%EA%B9%8C
	public ArrayList<Integer> PL_Calculator() {
		ArrayList<ArrayList<StatementVO>> Sorted_Acconutlist = Sorting_Account();
		ArrayList<Integer> PL_dataList = new ArrayList<Integer>();
		
		int data1 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(3).size();i++) {
			// sales(0) 401 ~ 420 
			if(Integer.parseInt(Sorted_Acconutlist.get(3).get(i).getAccount_cd()) >= 401 && Integer.parseInt(Sorted_Acconutlist.get(3).get(i).getAccount_cd()) <= 420) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(3).get(i).getDebtor());
				data1 += Integer.parseInt(Sorted_Acconutlist.get(3).get(i).getCreditor());
			}	
		}
		PL_dataList.add(data1);
		
		data1 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(4).size();i++) {
			// wonga(1) 451 ~ 470
			if(Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) >= 451 && Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) <= 470) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getDebtor());
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getCreditor());
			}	
		}
		PL_dataList.add(data1);
		
		data1 = 0;
		// Gross profit(2) : sales - wonga
		data1 = PL_dataList.get(0) - PL_dataList.get(1);
		PL_dataList.add(data1);
		
		data1 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(4).size();i++) {
			// Selling and administrative(3) 801 ~ 848
			if(Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) >= 801 && Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) <= 848) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getDebtor());
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getCreditor());
			}	
		}
		
		PL_dataList.add(data1);
		
		data1 = 0;
		// Operating profit(4) : Gross profit sales - Selling and administrative 
		data1 = PL_dataList.get(2) - PL_dataList.get(3);
		PL_dataList.add(data1);
		
		data1 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(4).size();i++) {
			// Non-operating Income(5) 901 ~ 930
			if(Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) >= 901 && Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) <= 930) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getDebtor());
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getCreditor());
			}	
		}
		
		PL_dataList.add(data1);
		data1 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(4).size();i++) {
			// Non-operating expenses(6) 931 ~ 960
			if(Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) >= 931 && Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) <= 960) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getDebtor());
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getCreditor());
			}	
		}
		
		PL_dataList.add(data1);
		
		data1 = 0;
		// Income before Tax(7) : Operating profit - Non-operating expenses
		data1 = PL_dataList.get(4) - PL_dataList.get(6);
		
		PL_dataList.add(data1);
		
		data1 = 0;
		for(int i=0;i< Sorted_Acconutlist.get(4).size();i++) {
			// Income Tax(8) : 998
			if(Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getAccount_cd()) == 998) {
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getDebtor());
				data1 += Integer.parseInt(Sorted_Acconutlist.get(4).get(i).getCreditor());
			}	
		}
		
		PL_dataList.add(data1);
		
		data1 = 0;
		// Net Income(9) : Income before Tax - Income Tax
		data1 = PL_dataList.get(7) - PL_dataList.get(8);
		
		PL_dataList.add(data1);
		return PL_dataList;
	}

}