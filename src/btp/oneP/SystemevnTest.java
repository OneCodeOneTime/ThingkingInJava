package btp.oneP;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class SystemevnTest {

	public static void main(String[] args) {
		Map<Object, Object> sysevn = System.getProperties();
		
		for(Object key : sysevn.keySet()) {
			/*if("RUNTIME_CONFIG_ROOT".equals(key)) {
				System.out.println(sysevn.get(key));
			}*/
			System.out.println(key+"  ->  "+sysevn.get(key));
		}
		
		Calendar cd = Calendar.getInstance();
		Date today = new Date();
		System.out.println(today.getTime());
		cd.setTime(today);
		cd.add(Calendar.MONTH, 1);
		System.out.println(cd.getTime().getTime());
	}

}
