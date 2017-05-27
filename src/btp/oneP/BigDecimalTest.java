package btp.oneP;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		try{
			BigDecimal bd = new BigDecimal("222222222222d222.0");
			if(bd.toString().contains(".")){
				int num = 0;
				for(int i=bd.toString().indexOf(".");i<bd.toString().length();i++){
					num++;
					if(num>2){
						System.out.println("请输入小数点2位及2位以内的年收入");
						break;
					}
				}
			}
			System.out.println(bd);
		}catch(Exception e){
			System.out.println("请输入数字年收入");
		}
	}

}
