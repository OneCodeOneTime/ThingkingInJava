package btp.oneP;

public class Covarance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseX bx = new BaseX();
		DerivedX dx = new DerivedX();
		DerivedSetter d = new DerivedSetter();
		d.set(dx);
		d.set(bx);
		//----------------
		DerivedGS dgs = new DerivedGS();
		dgs.set(bx);
		dgs.set(dx);
		
	}

}

class BaseX{}
class DerivedX extends BaseX{}

interface OrdinaryGetter{
	BaseX get();
}

interface DerivedGetter extends OrdinaryGetter{
	DerivedX get();
}

class CovariantReturnTypes{
	void test(DerivedGetter d){
		DerivedX d2 = d.get();
	}
}

interface GenericGetter<T extends GenericGetter<T>>{
	T get();
}

interface Getter extends GenericGetter<Getter>{
	
}

class GenericsAndReturnTypes{
	void test(Getter g){
		Getter result = g.get();
		GenericGetter gg = g.get();
	}
}


class OrdinarySetter{
	void set(BaseX base){
		System.out.println("OrdinarySetter.set(BaseX)");
	}
}

class DerivedSetter extends OrdinarySetter{
	//这不是重写，这是重载
	void set(DerivedX derived){
		System.out.println("DerivedSetter.set(Derived)");
	}
}

interface SelfBoundSetter<T extends SelfBoundSetter<T>>{
	void set(T arg);
}

interface GSetter extends SelfBoundSetter<GSetter>{}

class SelfBoundingAndCovariantArgument{
	void testA(GSetter s1,GSetter s2,SelfBoundSetter sbs){
		s1.set(s2);
		//s1.set(sbs);
	}
}

class GenericSetter<T>{
	void set(T t){
		System.out.println("GenericSetter.set(Base)");
	}
}

class DerivedGS extends GenericSetter<BaseX>{
	void set(DerivedX derivedx){
		System.out.println("DerivedGS.set(Derived)");
	}
}