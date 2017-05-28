package btp.oneP;

public class Employee implements Payable{

	@Override
	public void getPay() {
		// TODO Auto-generated method stub
		
	}

}


interface Payable<T>{
	void getPay();
}

class Hourly extends Employee implements Payable{}



/*public class Employee implements Payable<Employee>{

	@Override
	public void getPay() {
		// TODO Auto-generated method stub
		
	}

}


class Hourly extends Employee implements Payable<Hourly>{}*/