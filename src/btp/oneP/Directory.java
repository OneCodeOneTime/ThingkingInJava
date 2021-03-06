package btp.oneP;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
	public static File[] local(File dir,final String regex){
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
			
		});
	}
	
	public static File[] local(String path,final String regex){
		return local(new File(path),regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		@Override
		public Iterator<File> iterator() {
			// TODO Auto-generated method stub
			return files.iterator();
		}
		
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("dirs: \n");
			for(File f : dirs){
				sb.append(f.getPath()+"\n");
			}
			sb.append("files: \n");
			for(File f : files){
				sb.append(f.getPath()+"\n");
			}
			return sb.toString();
		}
	}
	
	public static TreeInfo walk(String start,String regex){
		return recurseDirs(new File(start),regex);
	}
	public static TreeInfo walk(File start,String regex){
		return recurseDirs(start,regex);
	}
	public static TreeInfo walk(File start){
		return recurseDirs(start,".*");
	}
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start),".*");
	}

	private static TreeInfo recurseDirs(File file, String regex) {
		TreeInfo result = new TreeInfo();
		for(File item : file.listFiles()){
			if(item.isDirectory()){
				result.dirs.add(item);
				result.addAll(recurseDirs(item,regex));
			}else{
				if(item.getName().matches(regex))
					result.files.add(item);
			}
		}
		return result;
	}
	public static void main(String...args){
		System.out.println(walk("C:\\Users\\dell\\Desktop\\pdf.js"));
	}
}
