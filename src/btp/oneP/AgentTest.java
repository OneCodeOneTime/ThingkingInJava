package btp.oneP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class AgentTest {
	private static Comparator<Agentnew> comparatorForAgent = new Comparator<Agentnew>(){
		@Override
		public int compare(Agentnew o1, Agentnew o2) {
			if(!o1.isWastage()&&o2.isWastage()){
				return -1;
			}else if(o1.isWastage()&&!o2.isWastage()){
				return 1;
			}else{
				if(o1.getLastVideoTime().before(o2.getLastVideoTime())){
					return -1;
				}else if(o1.getLastVideoTime().after(o2.getLastVideoTime())){
					return 1;
				}else{
					if(o1.getAllocateCount()<o2.getAllocateCount()){
						return -1;
					}else if(o1.getAllocateCount()>o2.getAllocateCount()){
						return 1;
					}else{
						return 0;
					}
				}
			}
		}
	};
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// TODO Auto-generated method stub
		List<Agentnew> userListTemp = new ArrayList<Agentnew>();
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),true,2));
		userListTemp.add(new Agentnew(sdf.parse("2002-3-20 05:05:09"),true,2));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 06:05:09"),true,3));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),true,4));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),false,2));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),true,2));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),false,4));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),true,2));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),false,5));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),false,0));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),true,2));
		userListTemp.add(new Agentnew(sdf.parse("2001-3-20 05:05:09"),true,6));
		
		Collections.sort(userListTemp,comparatorForAgent);
		
		for(Agentnew a:userListTemp){
			System.out.println(a);
		}
		
	}

}

class Agentnew{
	//上次接视频时间
    private Date lastVideoTime = new Date();
    //上次分配是否未接
    private boolean wastage;
    //分配次数
    private int allocateCount;
    
    
	public Agentnew(Date lastVideoTime, boolean wastage, int allocateCount) {
		super();
		this.lastVideoTime = lastVideoTime;
		this.wastage = wastage;
		this.allocateCount = allocateCount;
	}
	public Date getLastVideoTime() {
		return lastVideoTime;
	}
	public void setLastVideoTime(Date lastVideoTime) {
		this.lastVideoTime = lastVideoTime;
	}
	public boolean isWastage() {
		return wastage;
	}
	public void setWastage(boolean wastage) {
		this.wastage = wastage;
	}
	public int getAllocateCount() {
		return allocateCount;
	}
	public void setAllocateCount(int allocateCount) {
		this.allocateCount = allocateCount;
	}
	@Override
	public String toString() {
		return "Agentnew [ wastage=" + wastage+",lastVideoTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastVideoTime) + ", allocateCount=" + allocateCount +"]";
	}
    
}