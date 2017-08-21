package btp.oneP;

public enum OzWitch {
	WEST("Miss Gulch,aka the Wicked Witch of the West"),
	NORTH("Glinda,the Good Witch of the North"),
	EAST("Slippers,crushed by Dorothy's house"),
	SOUTH("Good by inference,but missing");
	
	private String description;
	private OzWitch(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	public static void main(String...args){
		for(OzWitch witch : OzWitch.values()){
			System.out.println(witch + ": "+witch.getDescription());
		}
		
	}
}
