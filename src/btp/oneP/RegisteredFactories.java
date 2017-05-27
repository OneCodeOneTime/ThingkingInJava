package btp.oneP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//�򵥵Ĺ���ģʽ
public class RegisteredFactories {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(Part.createRandom());
		}
	}

}

//���󹤳� -> �ɷ���һ���ض����͵Ķ���ʵ��
interface Factory<T>{T create();}

class Part{
	public String toString(){
		return this.getClass().getSimpleName();
	}
	//����ע��д�ڻ���ĺô��������������������洢
	static List<Factory<? extends Part>> partFactories = 
			new ArrayList<Factory<? extends Part>>();
	static{
		//����ע��
		//����ע�����д�ڻ����У����ͱȽϺô���
		partFactories.add(FuelFilter.factory());
		partFactories.add(AirlFilter.factory());
		partFactories.add(CabinAirlFilter.factory());
		partFactories.add(OilFilter.factory());
		partFactories.add(FanBelt.factory());
		partFactories.add(GeneratorBelt.factory());
		partFactories.add(PowerSteeringBelt.factory());
	}
	private static Random rand = new Random(47);
	public static Part createRandom(){
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
	
}

class Filter extends Part{}

//ÿ���඼�ܲ������Է�������ʵ���Ĺ���ʵ��
class FuelFilter extends Filter{
	public static Factory<FuelFilter> factory(){
		return new Factory<FuelFilter>(){
			@Override
			public FuelFilter create() {
				// TODO Auto-generated method stub
				return new FuelFilter();
			}	
		};
	}	
}

class AirlFilter extends Filter{
	public static Factory<AirlFilter> factory(){
		return new Factory<AirlFilter>(){
			@Override
			public AirlFilter create() {
				// TODO Auto-generated method stub
				return new AirlFilter();
			}	
		};
	}	
}
class CabinAirlFilter extends Filter{
	public static Factory<CabinAirlFilter> factory(){
		return new Factory<CabinAirlFilter>(){
			@Override
			public CabinAirlFilter create() {
				// TODO Auto-generated method stub
				return new CabinAirlFilter();
			}	
		};
	}	
}
class OilFilter extends Filter{
	public static Factory<OilFilter> factory(){
		return new Factory<OilFilter>(){
			@Override
			public OilFilter create() {
				// TODO Auto-generated method stub
				return new OilFilter();
			}	
		};
	}	
}

class Belt extends Part{}

class FanBelt extends Belt{
	public static Factory<FanBelt> factory(){
		return new Factory<FanBelt>(){

			@Override
			public FanBelt create() {
				// TODO Auto-generated method stub
				return new FanBelt();
			}
			
		};
	}
}

class GeneratorBelt extends Belt{
	public static Factory<GeneratorBelt> factory(){
		return new Factory<GeneratorBelt>(){

			@Override
			public GeneratorBelt create() {
				// TODO Auto-generated method stub
				return new GeneratorBelt();
			}
			
		};
	}
}

class PowerSteeringBelt extends Belt{
	public static Factory<PowerSteeringBelt> factory(){
		return new Factory<PowerSteeringBelt>(){

			@Override
			public PowerSteeringBelt create() {
				// TODO Auto-generated method stub
				return new PowerSteeringBelt();
			}
			
		};
	}
}
