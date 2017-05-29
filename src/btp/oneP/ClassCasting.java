package btp.oneP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ClassCasting {
	
	public void f(String...args) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(args[0]));
		//List<Widget> lwl = List<Widget>.class.ClassCasting(in.readObject());
		//List<Widget> lw2 = (List<Widget>)List.class.cast(in.readObject());
		List<Widget> lw2 = List.class.cast(in.readObject());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Widget{}
