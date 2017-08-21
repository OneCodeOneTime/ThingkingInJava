package btp.oneP;

import btp.oneP.Food.Appetizer;
import btp.oneP.Food.Coffee;
import btp.oneP.Food.DESSERT;
import btp.oneP.Food.MainCourse;

public class TypeOfFood {

	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = DESSERT.GELATO;
		food = Coffee.CAPPUCCINO;
	}

}
