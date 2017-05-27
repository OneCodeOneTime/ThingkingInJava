package btp.oneP;

import java.util.ArrayList;
import java.util.Random;

public class Store extends ArrayList<Aisle>{
	private ArrayList<CheckoutStand> checkouts = 
			new ArrayList<CheckoutStand>();
	private Office office = new Office();
	public Store(int nAsiles,int nShelves,int nProducts){
		for(int i=0;i<nAsiles;i++){
			this.add(new Aisle(nShelves,nProducts));
		}
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Aisle as:this){
			for(Shelf s:as){
				for(Product p : s){
					sb.append(p);
					sb.append("\n");
				}
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Store(14,5,10));
	}

}


interface GeneratorB<T>{
	T next();
}
class Product{
	private final int id;
	private String description;
	private double price;
	public Product(int IDnumber,String descr,double price){
		this.id = IDnumber;
		this.description = descr;
		this.price = price;
		System.out.println(this);
	}
	public String toString(){
		return this.id+": "+this.description+",price:$"+price;
	}
	public void priceChange(double change){
		price += change;
	}
	public static GeneratorB<Product> generator = new GeneratorB<Product>(){
		private Random rand = new Random(47);
		@Override
		public Product next() {
			return new Product(rand.nextInt(1000),"Test",Math.round(rand.nextDouble()*1000.0)+0.99);
		}
		
	};
}

class Shelf extends ArrayList<Product>{
	public Shelf(int nProducts){
		for(int i = 0;i<nProducts;i++){
			this.add(Product.generator.next());
		}
	}
}

class Aisle extends ArrayList<Shelf>{
	public Aisle(int nShelves,int nProducts){
		for(int i=0;i<nShelves;i++){
			add(new Shelf(nProducts));
		}
	}
}

class CheckoutStand{}
class Office{}
