package btp.oneP;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(name).matches();
			}
			
		};
	}
	public static void main(final String[] args) {
		File path = new File("E:\\workspaces\\NewWork\\Study\\src\\btp\\oneP");
		String[] list;
		if(args.length == 0){
			list = path.list();
		}else{
			//list = path.list(filter(args[0]));
			list = path.list(new FilenameFilter(){
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return pattern.matcher(name).matches();
				}
				
			});
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list){
			System.out.println(dirItem);
		}
	}

}
