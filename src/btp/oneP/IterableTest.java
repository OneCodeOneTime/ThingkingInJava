package btp.oneP;

import java.util.Arrays;
import java.util.Iterator;

public class IterableTest {

	public static void main(String[] args) {
		Players playes = new Players(5);
		playes.add(new Player("Jordan",23,100));
		playes.add(new Player("Kobe",24,99));
		playes.add(new Player("James",23,98));
		playes.add(new Player("Kuru",30,97));
		playes.add(new Player("Durant",35,96));
		for(Player p:playes){
			System.out.println(p);
		}
		
		System.out.println("-------------------");
		Iterator<Player> it=playes.iterator();
		while(it.hasNext()){
			Player p = it.next();
			
			if("James".equals(p.getName())){
				it.remove();
			}
		}
		System.out.println(playes);
	}

}

class Player{
	private String name;
	private int age;
	private int score;
	public Player(String n,int a,int s){
		this.name=n;
		this.age=a;
		this.score=s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString(){
		return "name:"+name+";age:"+age+";score:"+score;
	}
}

class Players implements Iterable<Player>{
	private Player[] players;
	private int capicity;
	
	private int index=0;
	public Player[] getPlayes() {
		return players;
	}

	public void setPlayes(Player[] players) {
		this.players = players;
	}
	
	public Players(){
		
	}
	public Players(int catapicityy){
		players = new Player[(this.capicity=catapicityy)];
	}
	
	public void add(Player p){
		if(index == capicity){
			throw new IndexOutOfBoundsException();
		}else{
			players[index++]=p;
		}
	}

	
	@Override
	public Iterator<Player> iterator() {
		return new Iterator<Player>(){
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index != Players.this.capicity;
			}

			@Override
			public Player next() {
				if(hasNext()){
					return players[index++];
				}
				return null;
			}
			public void remove(){
				int lastRead=index-1;
				
				if(lastRead<0){
					throw new IndexOutOfBoundsException();
				}else{
					for(int i=lastRead;i<Players.this.capicity-1;i++){
						players[i]=players[i+1];
					}
					players[--Players.this.capicity]=null;
				}
			}
			
		};
	}
	
	public String toString(){
		return Arrays.toString(players);
	}
	
}
