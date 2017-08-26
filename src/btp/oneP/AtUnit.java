package btp.oneP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AtUnit implements ProcessFiles.Strategy{
	static Class<?> testClass;
	static List<String> failedTests = new ArrayList<String>();
	static long testsRun = 0;
	static long failures = 0;
	
	@Override
	public void process(File file) {
		try{
			String cName = ClassNameFinder.thisClass(BinaryFile.read(file));
			if(!cName.contains(".")){
				return;
			}
			testClass = Class.forName(cName);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

}
