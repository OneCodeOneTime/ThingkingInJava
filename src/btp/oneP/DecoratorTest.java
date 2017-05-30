package btp.oneP;

import java.util.ArrayList;
import java.util.List;

public class DecoratorTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		OriginalCoffee originalCoffee = new OriginalCoffee();
		double priceMilk = 10.0;
		Milk milkCoffee = new Milk(originalCoffee,priceMilk);
		milkCoffee.mixing();
		System.out.println("当前咖啡中的配料："+milkCoffee.foodList);
		System.out.println("当前咖啡价格："+milkCoffee.getPrice());
		System.out.println("---------------------------");
		double priceMatcha = 20.0;
		Matcha matchaCoffee = new Matcha(milkCoffee,priceMatcha);
		matchaCoffee.mixing();
		System.out.println("当前咖啡中的配料："+matchaCoffee.foodList);
		System.out.println("当前咖啡价格："+matchaCoffee.getPrice());
		System.out.println("---------------------------");
		double priceChocolate = 30.0;
		Chocolate chocolateCoffee = new Chocolate(matchaCoffee,priceChocolate);
		chocolateCoffee.mixing();
		System.out.println("当前咖啡中的配料："+chocolateCoffee.foodList);
		System.out.println("当前咖啡价格："+chocolateCoffee.getPrice());
		System.out.println("---------------------------");
	}

}

/**
 * 装饰品和被装饰器的共同接口
 *
 */
interface CoffeeTaste{
	//返回价格
	double getPrice();
	//搅拌咖啡
	void mixing();
}

/**
 * 原始的被装饰器
 *
 */
class OriginalCoffee implements CoffeeTaste{
	private String name;
	public OriginalCoffee(){
		name = "原味咖啡";
		System.out.println("原味咖啡的价格是：50");
	}
	@Override
	public double getPrice() {
		//原味咖啡的价钱
		return 50;
	}

	@Override
	public void mixing() {
		System.out.println("--搅拌咖啡");
	}
	
}

/**
 * 装饰品的共同父类
 *
 */
abstract class SnacksAndDesserts implements CoffeeTaste{
	public static List<String> foodList= new ArrayList<String>();
	//小食和甜品的价格
	private double additionalPrice;
	//要加入小食和甜品的咖啡
	CoffeeTaste coffeeTaste;
	public SnacksAndDesserts(CoffeeTaste coffeeTaste,double additionalPrice){
		this.coffeeTaste = coffeeTaste;
		this.additionalPrice = additionalPrice;
	}
	//返回价格
	@Override
	public double getPrice() {
		double priceNow = coffeeTaste.getPrice()+additionalPrice;
		return priceNow;
	}
	
	abstract void add();
}

/**
 * 牛奶类
 *
 */
class Milk extends SnacksAndDesserts{

	public Milk(CoffeeTaste coffeeTaste, double additionalPrice) {
		super(coffeeTaste, additionalPrice);
		System.out.println("O(∩_∩)O~~牛奶的价格是："+additionalPrice);
	}

	@Override
	void add() {
		System.out.println("--咖啡中加入牛奶");
		SnacksAndDesserts.foodList.add("牛奶");
	}

	@Override
	public void mixing() {
		add();
		System.out.println("--牛奶加入咖啡中搅拌");
	}
	
	
}


/**
 * 抹茶类
 */
class Matcha extends SnacksAndDesserts{

	public Matcha(CoffeeTaste coffeeTaste, double additionalPrice) {
		super(coffeeTaste, additionalPrice);
		System.out.println("O(∩_∩)O~~抹茶的价格是："+additionalPrice);
	}

	@Override
	void add() {
		System.out.println("--咖啡中混入抹茶");
		SnacksAndDesserts.foodList.add("抹茶");
	}
	
	@Override
	public void mixing() {
		add();
		System.out.println("--抹茶加入咖啡中搅拌");
	}
}

/**
 * 巧克力类
 */

class Chocolate extends SnacksAndDesserts{

	public Chocolate(CoffeeTaste coffeeTaste, double additionalPrice) {
		super(coffeeTaste, additionalPrice);
		System.out.println("O(∩_∩)O~~巧克力的价格是："+additionalPrice);
	}

	@Override
	void add() {
		System.out.println("--咖啡中加入巧克力");
		SnacksAndDesserts.foodList.add("巧克力");
	}
	
	@Override
	public void mixing() {
		add();
		System.out.println("--咖啡加入咖啡中搅拌");
	}
}
