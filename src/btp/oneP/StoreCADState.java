package btp.oneP;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreCADState {

	public static void main(String[] args) throws IOException {
		List<Class<? extends ShapeX>> shapeTypes = new ArrayList<Class<? extends ShapeX>>();
		shapeTypes.add(CircleX.class);
		shapeTypes.add(SquareX.class);
		shapeTypes.add(LineX.class);
		
		List<ShapeX> shapes = new ArrayList<ShapeX>();
		for(int i = 0;i < 10; i++){
			shapes.add(ShapeX.randomFactory());
		}
		for(int i = 0;i < 10; i++){
			((ShapeX)shapes.get(i)).setColor(ShapeX.GREEN);
		}
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(shapeTypes);
		LineX.serializeStaticState(out);
		out.writeObject(shapes);
		System.out.println(shapes);
	}

}

abstract class ShapeX implements Serializable{
	public static final int RED = 1,BLUE = 2,GREEN = 3;
	private int xPos,yPos,dimension;
	private static Random rand = new Random();
	private static int counter = 0;
	public abstract void setColor(int newColor);
	public abstract int getColor();
	public ShapeX(int xVal,int yVal,int dim){
		this.xPos = xVal;
		this.yPos = yVal;
		this.dimension = dim;
	}
	public String toString(){
		return this.getClass()+
				"color["+getColor()+"] xPos["+xPos+
				"] yPos["+yPos+"] dim["+dimension+"]\n";
	}
	public static ShapeX randomFactory(){
		int xVal = rand.nextInt(100);
		int yVal = rand.nextInt(100);
		int dim = rand.nextInt(100);
		switch(counter++ % 3){
		default:
		case 0:return new CircleX(xVal,yVal,dim);
		case 1:return new SquareX(xVal,yVal,dim);
		case 2:return new LineX(xVal,yVal,dim);
		}
	}
}

class CircleX extends ShapeX{
	private static int color = RED;
	public CircleX(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		// TODO Auto-generated constructor stub
	}
	public void setColor(int newColor){
		color = newColor;
	}
	public int getColor(){
		return color;
	}
}

class SquareX extends ShapeX{
	private static int color;
	public SquareX(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}
	public void setColor(int newColor){
		color = newColor;
	}
	public int getColor(){
		return color;
	}
}

class LineX extends ShapeX{
	private static int color = RED;
	public static void serializeStaticState(ObjectOutputStream os) throws IOException{
		os.writeInt(color);;
	}
	public static void deserializeStaticState(ObjectInputStream os) throws IOException{
		color = os.readInt();
	}
	public LineX(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		// TODO Auto-generated constructor stub
	}
	public void setColor(int newColor){
		color = newColor;
	}
	public int getColor(){
		return color;
	}
	
}
