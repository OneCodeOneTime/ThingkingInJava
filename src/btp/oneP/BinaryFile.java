package btp.oneP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BinaryFile {
	public static byte[] read(File bFile) throws IOException{
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
		try{
			byte[] data = new byte[bf.available()];
			bf.read(data);
			return data;
		}finally{
			bf.close();
		}
	}
	
	public static byte[] read(String bFile) throws IOException{
		return read(new File(bFile).getAbsoluteFile());
	}
	public static void main(String[] args) throws IOException {
		byte[] bytes = read("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP\\BinaryFile.java");
		Map<Byte,Integer> map = new HashMap<Byte,Integer>();
		for(byte b : bytes){
			if(null == map.get(b)){
				map.put(b, 1);
			}else{
				map.put(b, map.get(b)+1);
			}
		}
		System.out.println(map);
	}

}
