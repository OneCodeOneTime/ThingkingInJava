package btp.oneP;

public class ComparablePet implements Comparable<ComparablePet> {

	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}

}

//以下是错误的，等于同时两个泛型参数
//class Cat extends ComparablePet implements Comparable<Cat>{}


class Hamster extends ComparablePet implements Comparable<ComparablePet>{
	//其实这就等于重写，子类Hamster重写了父类ComparablePet的方法
	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}
}

//Gecko和Hanster的效果一样
class Gecko extends ComparablePet{
	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}
}