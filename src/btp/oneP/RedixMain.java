package btp.oneP;

import java.io.PrintStream;

public class RedixMain {

	public static void main(String[] args) {
		PrintStream p = System.out;
		//ʮ����תʮ������
		p.println(Integer.toHexString(112));
		//ʮ����ת�˽���
		p.println(Integer.toOctalString(112));
		//ʮ����ת������
		p.println(Integer.toBinaryString(112));
		
		//������תʮ����
		p.println(Integer.parseInt("01110000", 2));
		//�˽���תʮ����
		p.println(Integer.parseInt("160",8));
		//ʮ������תʮ����
		p.println(Integer.parseInt("70",16));
	}

}
