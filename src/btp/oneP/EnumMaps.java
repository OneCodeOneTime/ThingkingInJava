package btp.oneP;

import java.util.EnumMap;
import java.util.Map;

public class EnumMaps {

	public static void main(String[] args) {
		EnumMap<AlarmPoints,CommandI> em = 
				new EnumMap<AlarmPoints,CommandI>(AlarmPoints.class);
		em.put(AlarmPoints.KITCHEN, new CommandI(){

			@Override
			public void action() {
				System.out.print("Kitchen fire!");
			}
			
		});
		em.put(AlarmPoints.BATHROOM, new CommandI(){

			@Override
			public void action() {
				System.out.print("Bathroom alert!");
			}
			
		});
		em.put(AlarmPoints.LOBBY, new CommandI(){

			@Override
			public void action() {
				System.out.print("LOBBY fire!");
			}
			
		});
		em.put(AlarmPoints.OFFICE1, new CommandI(){

			@Override
			public void action() {
				System.out.print("office1 fire!");
			}
			
		});
		
		for(Map.Entry<AlarmPoints, CommandI> e : em.entrySet()){
			System.out.print(e.getKey() + ": ");
			e.getValue().action();
			System.out.println();
		}
		try{
			em.get(AlarmPoints.UTILITY).action();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

interface CommandI{
	void action();
}