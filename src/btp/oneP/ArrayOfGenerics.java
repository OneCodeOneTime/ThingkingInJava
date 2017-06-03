package btp.oneP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {

	public static void main(String[] args) {
		//编译期不能实例化泛型数组，但是可以创建泛型数组的引用
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[])la;
		ls[0] = new ArrayList<String>(Arrays.asList("hehe","keke","xixi"));
		//ls[1] = new ArrayList<Integer>();
		
		Object[] objects = ls;
		objects[1] = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		System.out.println(Arrays.toString(la));
		System.out.println(la.getClass().getName());
		System.out.println(Arrays.toString(ls));
		System.out.println(ls.getClass().getName());
		System.out.println(Arrays.toString(objects));
		System.out.println(objects.getClass().getName());
		List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
		for(int i=0;i<10;i++){
			spheres[i] = new ArrayList<BerylliumSphere>();
		}
	}

}
