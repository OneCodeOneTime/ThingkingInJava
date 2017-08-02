package btp.oneP;

import java.io.File;
import java.io.IOException;

public class MakeDirectories {
	private static void usage(){
		System.err.println(
				"Usage:MakeDirectories path1 ...\n"+
				"Creates each path\n"+
				"Usage:MakeDirectories -d path1 ...\n"+
				"Deletes each path\n"+
				"Usage:MakeDirectories -r path1 path2\n"+
				"Renames from path1 to path2");
		System.exit(1);
	}
	private static void fileData(File f){
		System.out.println(
				"Absolute path: "+f.getAbsolutePath()+
				"\n Can read: "+f.canRead()+
				"\n Can write: "+f.canWrite()+
				"\n getName: "+f.getName()+
				"\n getParent: "+f.getParent()+
				"\n length: "+f.length()+
				"\n lastModified: "+f.lastModified());
		if(f.isFile()){
			System.out.println("It's a file");
		}else if(f.isDirectory()){
			System.out.println("It's a directory");
		}
	}
	public static void main(String[] args) throws IOException {
		File file1 = new File("C:\\Users\\dell\\Desktop\\idea\\文件1.txt");
		File file2 = new File("C:\\Users\\dell\\Desktop\\idea\\文件3.txt");
		fileData(file1);
		//如果file2存在了就返回false，如果file2所知路径不存在，创建file2的具体路径，并且把file1文件的内容替换成file2
		System.out.println(file1.renameTo(file2));
		fileData(file2);
		
		File file3 = new File("C:\\Users\\dell\\Desktop\\idea\\文件夹1");
		File file4 = new File("C:\\Users\\dell\\Desktop\\idea\\文件夹2");
		fileData(file3);
		System.out.println(file3.renameTo(file4));
		fileData(file3);
		fileData(file4);
		
		File file5 = new File("C:\\Users\\dell\\Desktop\\idea\\1\\2\\1.txt");
		if(!file5.exists()){
			file5.createNewFile();
		}
		System.out.println(file2.renameTo(file5));
		System.out.println(file5.delete());
	}

}
