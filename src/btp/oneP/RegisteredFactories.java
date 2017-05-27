package btp.oneP;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//简单的工厂模式
public class RegisteredFactories {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(Part.createRandom());
		}
	}

}

//抽象工厂 -> 可返回一个特定类型的对象实例
interface Factory<T>{T create();}

class Part{
	public String toString(){
		return this.getClass().getSimpleName();
	}
	//工厂注册写在基类的好处：可以用自身类型来存储
	static List<Factory<? extends Part>> partFactories = 
			new ArrayList<Factory<? extends Part>>();
	static{
		//工厂注册
		//工厂注册最好写在基类中，类型比较好处理
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

//每个类都能产生可以返回自身实例的工厂实例
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
