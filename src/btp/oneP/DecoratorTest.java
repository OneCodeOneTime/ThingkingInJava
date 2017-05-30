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
		System.out.println("��ǰ�����е����ϣ�"+milkCoffee.foodList);
		System.out.println("��ǰ���ȼ۸�"+milkCoffee.getPrice());
		System.out.println("---------------------------");
		double priceMatcha = 20.0;
		Matcha matchaCoffee = new Matcha(milkCoffee,priceMatcha);
		matchaCoffee.mixing();
		System.out.println("��ǰ�����е����ϣ�"+matchaCoffee.foodList);
		System.out.println("��ǰ���ȼ۸�"+matchaCoffee.getPrice());
		System.out.println("---------------------------");
		double priceChocolate = 30.0;
		Chocolate chocolateCoffee = new Chocolate(matchaCoffee,priceChocolate);
		chocolateCoffee.mixing();
		System.out.println("��ǰ�����е����ϣ�"+chocolateCoffee.foodList);
		System.out.println("��ǰ���ȼ۸�"+chocolateCoffee.getPrice());
		System.out.println("---------------------------");
	}

}

/**
 * װ��Ʒ�ͱ�װ�����Ĺ�ͬ�ӿ�
 *
 */
interface CoffeeTaste{
	//���ؼ۸�
	double getPrice();
	//���迧��
	void mixing();
}

/**
 * ԭʼ�ı�װ����
 *
 */
class OriginalCoffee implements CoffeeTaste{
	private String name;
	public OriginalCoffee(){
		name = "ԭζ����";
		System.out.println("ԭζ���ȵļ۸��ǣ�50");
	}
	@Override
	public double getPrice() {
		//ԭζ���ȵļ�Ǯ
		return 50;
	}

	@Override
	public void mixing() {
		System.out.println("--���迧��");
	}
	
}

/**
 * װ��Ʒ�Ĺ�ͬ����
 *
 */
abstract class SnacksAndDesserts implements CoffeeTaste{
	public static List<String> foodList= new ArrayList<String>();
	//Сʳ����Ʒ�ļ۸�
	private double additionalPrice;
	//Ҫ����Сʳ����Ʒ�Ŀ���
	CoffeeTaste coffeeTaste;
	public SnacksAndDesserts(CoffeeTaste coffeeTaste,double additionalPrice){
		this.coffeeTaste = coffeeTaste;
		this.additionalPrice = additionalPrice;
	}
	//���ؼ۸�
	@Override
	public double getPrice() {
		double priceNow = coffeeTaste.getPrice()+additionalPrice;
		return priceNow;
	}
	
	abstract void add();
}

/**
 * ţ����
 *
 */
class Milk extends SnacksAndDesserts{

	public Milk(CoffeeTaste coffeeTaste, double additionalPrice) {
		super(coffeeTaste, additionalPrice);
		System.out.println("O(��_��)O~~ţ�̵ļ۸��ǣ�"+additionalPrice);
	}

	@Override
	void add() {
		System.out.println("--�����м���ţ��");
		SnacksAndDesserts.foodList.add("ţ��");
	}

	@Override
	public void mixing() {
		add();
		System.out.println("--ţ�̼��뿧���н���");
	}
	
	
}


/**
 * Ĩ����
 */
class Matcha extends SnacksAndDesserts{

	public Matcha(CoffeeTaste coffeeTaste, double additionalPrice) {
		super(coffeeTaste, additionalPrice);
		System.out.println("O(��_��)O~~Ĩ��ļ۸��ǣ�"+additionalPrice);
	}

	@Override
	void add() {
		System.out.println("--�����л���Ĩ��");
		SnacksAndDesserts.foodList.add("Ĩ��");
	}
	
	@Override
	public void mixing() {
		add();
		System.out.println("--Ĩ����뿧���н���");
	}
}

/**
 * �ɿ�����
 */

class Chocolate extends SnacksAndDesserts{

	public Chocolate(CoffeeTaste coffeeTaste, double additionalPrice) {
		super(coffeeTaste, additionalPrice);
		System.out.println("O(��_��)O~~�ɿ����ļ۸��ǣ�"+additionalPrice);
	}

	@Override
	void add() {
		System.out.println("--�����м����ɿ���");
		SnacksAndDesserts.foodList.add("�ɿ���");
	}
	
	@Override
	public void mixing() {
		add();
		System.out.println("--���ȼ��뿧���н���");
	}
}
