package btp.oneP;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCtreater {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> cl = Class.forName("btp.oneP.Member");
		DBTable dbTable = cl.getAnnotation(DBTable.class);
		if(null == dbTable){
			System.out.println("found no DBTable");
		}else{
			String tableName = dbTable.name();
			List<String> columnDefs = new ArrayList<String>();
			for(Field field:cl.getDeclaredFields()){
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				if(anns.length<1)continue;
				if(anns[0] instanceof SQLInteger){
					SQLInteger sInt = (SQLInteger)anns[0];
					if(sInt.name().length() < 1){
						columnName = field.getName().toUpperCase();
					}else{
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
				}
				if(anns[0] instanceof SQLString){
					SQLString sString = (SQLString)anns[0];
					if(sString.name().length() < 1){
						columnName = field.getName().toUpperCase();
					}else{
						columnName = sString.name();
					}
					columnDefs.add(columnName + " VARCHAR(" +sString.value()+")" +getConstraints(sString.constraints()));
				}
				
				StringBuilder sb = new StringBuilder("CREATE TABLE "+tableName+"(");
				for(String columnDef:columnDefs){
					sb.append("\n    "+columnDef+",");
				}
				sb = new StringBuilder(sb.substring(0, sb.length()-1)).append(")");
				System.out.println(sb.toString());
				
			}
		}
	}

	private static String getConstraints(Constraints con) {
		String constraints = "";
		if(!con.allowNull()){
			constraints += " NOT NULL";
		}
		if(con.primaryKey()){
			constraints += " PRIMARY KEY";
		}
		if(con.unique()){
			constraints += " UNIQUE";
		}
		return constraints;
	}

}
