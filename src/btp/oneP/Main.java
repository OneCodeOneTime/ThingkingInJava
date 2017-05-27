package btp.oneP;

import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PrintStream p = System.out;
		Scanner sc =new Scanner(new BufferedInputStream(System.in));
		try{
			
			String[] dss = new String[]{"深圳A股开户失败：[ErrorNo_HS=160247]中登股东账户数已达到或超过限制数[20],新开股东账户失败",
					"开放式基金失败：[ErrorNo_HS=150174][150174][该证件已在此基金公司开户][branch_no_out=270,id_kind=0,id_no=421087198408083738,fund_company=98]",
					"开立三方存管账户失败：[ErrorNo_HS=150388][150388][该账号有相同证件的其它账号的银行存管开户!请检查身份证重复的账户!][fund_account=80846585,branch_no=808,id_no=230102197401160413]",
					"开立三方存管账户失败：开户失败，请重新操作。失败原因：该卡不能做此交易!!"
			};
			StringBuilder sb = new StringBuilder("");
			try{
				for(String ssss:dss){
					sb.append("[");
					String ds = ssss;
					if(ds.contains("开放式基金失败")||ds.contains("开立三方存管账户失败")){
						String snew = ds.substring(0,ds.indexOf("：")+1);
						String ss = ds.substring(ds.indexOf("：")+1);
						if(ss.contains("[")&&ss.contains("]")){
							int num=0;
							for(int i=ss.indexOf("[");i<ss.length();i++){
								if(ss.charAt(i)=='['){
									num++;
								}
								if(num==3){
									String ssb = ss.substring(i+1);
									int index = ssb.indexOf("]");
									String ssnew = ssb.substring(0,index);
									snew += ssnew;
									break;
								}
							}
		
						}else{
							snew += ss;
						}
						sb.append(snew);
					}else{
						String snew = ds.substring(0,ds.indexOf("：")+1);
						if(snew.contains("开户失败")){
							snew += ds.substring(ds.indexOf("]")+1);
							sb.append(snew);
						}
						
					}
					
					sb.append("]");
				}
			}catch(Exception e){
				e.printStackTrace();
				sb = new StringBuilder("");
			}finally{
				p.println(sb);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sc.close();
			p.close();
		}
	}
}
