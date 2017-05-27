package btp.oneP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		List<Agent> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		list.add(new Agent(sdf.parse("2011-01-22 00:00:00")));
		list.add(new Agent(sdf.parse("2010-01-22 00:00:00")));
		list.add(new Agent(sdf.parse("2013-01-22 00:00:00")));
		list.add(new Agent(sdf.parse("2009-01-22 00:00:00")));
		list.add(new Agent(sdf.parse("2015-01-22 00:00:00")));
		Collections.sort(list,new Comparator<Agent>(){

			@Override
			public int compare(Agent o1, Agent o2) {
				if(o1.getLastVideoTime().before(o2.getLastVideoTime())){
					return -1;
				}else if(o1.getLastVideoTime().after(o2.getLastVideoTime())){
					return 1;
				}
				return 0;
			}

			
		});
		
		for(Agent a:list){
			System.out.println(a);
		}
	}

}

class Agent{
	private Date lastVideoTime = new Date();
	public Agent(Date lastVideoTime){
		this.lastVideoTime = lastVideoTime;
	}
	public Date getLastVideoTime() {
		return lastVideoTime;
	}

	public void setLastVideoTime(Date lastVideoTime) {
		this.lastVideoTime = lastVideoTime;
	}
	public String toString(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastVideoTime);
	}
}
