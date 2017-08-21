/*package btp.oneP;
import static btp.oneP.Input.ABORT_TRANSACTION;
import static btp.oneP.Input.CHIPS;
import static btp.oneP.Input.DIME;
import static btp.oneP.Input.DOLLAR;
import static btp.oneP.Input.NICKEL;
import static btp.oneP.Input.QUARTER;
import static btp.oneP.Input.SOAP;
import static btp.oneP.Input.SODA;
import static btp.oneP.Input.STOP;
import static btp.oneP.Input.TOOTHPASTE;

import java.util.EnumMap;
public class VendingMachine {
	private static State state = State.RESTING;
	private static int amount = 0;
	private static Input selection = null;
	enum State{
		RESTING{
			void next(Input input){
				switch(Category.categorize(input)){
					case MONEY:
						amount += input.amount();
						state = ADDING_MONEY;
						break;
					case SHUT_DOWN:
						state = TERMINAL;
					default:
				}
			}
		},
		ADDING_MONEY{
			void next(Input input){
				switch(Category.categorize(input)){
					case MONEY:
						amount += input.amount();
						break;
					case ITEM_SELECTION:
						selection = input;
						if(amount < selection.amount()){
							System.out.print("Insufficient money for " + selection);
						}else{
							state = DISPENSION;
						}
						break;
					case QUIT_TRANSACTION:
						state = GIVING_CHANGE;
						break;
					case SHUT_DOWN:
						state = TERMINAL;
					default:
				}
			}
		},
		DISPENSING(StateDuration.TRANSIENT){
			void next(){
				
			}
		}
		private boolean isTransient = false;
		State(){}
		State(StateDuration trans){
			isTransient = true;
		}
		void next(Input input){
			throw new RuntimeException("Only call next(Input input) for non-transient states");
		}
		void next(){
			throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
		}
		void output(){
			System.out.print(amount);
		}
	}
}

enum Category{
	MONEY(NICKEL,DIME,QUARTER,DOLLAR),
	ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
	QUIT_TRANSACTION(ABORT_TRANSACTION),
	SHUT_DOWN(STOP);
	
	private Input[] values;
	Category(Input...types){
		this.values = types;
	}
	
	private static EnumMap<Input,Category> categories = new EnumMap<Input,Category>(Input.class);
	
	static{
		for(Category c : Category.class.getEnumConstants()){
			for(Input type : c.values){
				categories.put(type, c);
			}
		}
	}
	public static Category categorize(Input input){
		return categories.get(input);
	}
}*/