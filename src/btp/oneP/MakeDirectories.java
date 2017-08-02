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
		File file1 = new File("C:\\Users\\dell\\Desktop\\idea\\�ļ�1.txt");
		File file2 = new File("C:\\Users\\dell\\Desktop\\idea\\�ļ�3.txt");
		fileData(file1);
		//���file2�����˾ͷ���false�����file2��֪·�������ڣ�����file2�ľ���·�������Ұ�file1�ļ��������滻��file2
		System.out.println(file1.renameTo(file2));
		fileData(file2);
		
		File file3 = new File("C:\\Users\\dell\\Desktop\\idea\\�ļ���1");
		File file4 = new File("C:\\Users\\dell\\Desktop\\idea\\�ļ���2");
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
