package btp.oneP;

public class ComparablePet implements Comparable<ComparablePet> {

	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}

}

//�����Ǵ���ģ�����ͬʱ�������Ͳ���
//class Cat extends ComparablePet implements Comparable<Cat>{}


class Hamster extends ComparablePet implements Comparable<ComparablePet>{
	//��ʵ��͵�����д������Hamster��д�˸���ComparablePet�ķ���
	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}
}

//Gecko��Hanster��Ч��һ��
class Gecko extends ComparablePet{
	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}
}