package btp.oneP;

public class AssociativeArray<K,V>{

	public static void main(String[] args) {
		AssociativeArray<String,String> map = new AssociativeArray<String,String>(6);
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("sun", "warm");
		try{
			map.put("extra", "object");
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(map);
		System.out.println(map.get("ocean"));
	}
	
	private Object[][] pair;
	private int index;
	public AssociativeArray(int length){
		pair = new Object[length][2];
	}
	
	public void put(K key,V value){
		if(index >= pair.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		pair[index++] = new Object[]{key,value}; 
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key){
		for(int i=0;i<pair.length;i++){
			if(key.equals(pair[i][0])){
				return (V)pair[i][1];
			}
		}
		return null;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<index;i++){
			sb.append(pair[i][0].toString());
			sb.append(" : ");
			sb.append(pair[i][1].toString());
			if(i<index-1){
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
