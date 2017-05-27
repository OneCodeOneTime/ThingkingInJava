package btp.oneP;

import java.util.Formatter;

public class Turtle {
	private String name;
	private Formatter f;
	public Turtle(String name,Formatter f){
		this.name = name;
		this.f = f;
	}
	public void move(int x,int y){
		f.format("%s The Turtle is at (%d,%d)\n", name,x,y);
	}
	public static void main(String[] args) {
		Turtle t = new Turtle("James",new Formatter(System.err));
		t.move(0, 0);
		t.move(1, 1);
		t.move(1, 2);
		t.move(2, 2);
		t.move(2, 3);
	}

}
