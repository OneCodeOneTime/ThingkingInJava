package btp.oneP;

import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PrintStream p = System.out;
		Scanner sc =new Scanner(new BufferedInputStream(System.in));
		try{
			
			String[] dss = new String[]{"����A�ɿ���ʧ�ܣ�[ErrorNo_HS=160247]�еǹɶ��˻����Ѵﵽ�򳬹�������[20],�¿��ɶ��˻�ʧ��",
					"����ʽ����ʧ�ܣ�[ErrorNo_HS=150174][150174][��֤�����ڴ˻���˾����][branch_no_out=270,id_kind=0,id_no=421087198408083738,fund_company=98]",
					"������������˻�ʧ�ܣ�[ErrorNo_HS=150388][150388][���˺�����֤ͬ���������˺ŵ����д�ܿ���!�������֤�ظ����˻�!][fund_account=80846585,branch_no=808,id_no=230102197401160413]",
					"������������˻�ʧ�ܣ�����ʧ�ܣ������²�����ʧ��ԭ�򣺸ÿ��������˽���!!"
			};
			StringBuilder sb = new StringBuilder("");
			try{
				for(String ssss:dss){
					sb.append("[");
					String ds = ssss;
					if(ds.contains("����ʽ����ʧ��")||ds.contains("������������˻�ʧ��")){
						String snew = ds.substring(0,ds.indexOf("��")+1);
						String ss = ds.substring(ds.indexOf("��")+1);
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
						String snew = ds.substring(0,ds.indexOf("��")+1);
						if(snew.contains("����ʧ��")){
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
