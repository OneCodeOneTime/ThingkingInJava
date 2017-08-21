package btp.oneP;

public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.DESSERT.class),
	COFFEE(Food.Coffee.class);
	private Food[] values;
	private Course(Class<? extends Food> kind){
		values = kind.getEnumConstants();
	}
	public Food randomSelection(){
		return Enums.random(values);
	}
	
}
