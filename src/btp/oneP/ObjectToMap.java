package btp.oneP;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMap {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Map<String,Object> toMap = new HashMap<>();;
		ActivityX a = new ActivityX();
		a.setActivity_id("23232");
		a.setActivity_code("dsjdgjks");
		toMap = objectToMap(toMap,a,ActivityX.class);
		System.out.println(toMap);
	}
	
	//对象转为map对象
	private static <T> Map<String,Object> objectToMap(Map<String,Object> toMap,T t,Class<T> clazz) throws IllegalArgumentException, IllegalAccessException {
		if(null == clazz) {
			throw new RuntimeException("error from ActicityServiceImpl.objectToMap");
		}else {
			if(null != t && clazz.isInstance(t)) {
				if(null == toMap) {
					toMap = new HashMap<String,Object>();
				}
				Field[] fileds = clazz.getDeclaredFields();
				for(Field f : fileds) {
					f.setAccessible(true);
					toMap.put(f.getName(), null == f.get(t)?"":f.get(t));
				}
				return toMap;
			}else {
				throw new RuntimeException("error from ActicityServiceImpl.objectToMap");
			}
		}
	}
}


class ActivityX {

	
	public String activity_id;
	
	private String activity_code;
	
	private String activity_name;
	
	private String effective_start_str;
	
	private String effective_end_str;
	
	private String status;
	
	private String description;
	
	private String access_url;
	
	private String en_branch_no;
	
	private String show_flag;
	
	private String icon_abstract;
	
	private String icon_url;
	
	private String busi_content;
	
	private String event_id;

	public String getActivity_id(){
		return activity_id;
	};
	
	public void setActivity_id(String activity_id){
		this.activity_id = activity_id;
	};
	public String getActivity_code(){
		return activity_code;
	};
	
	public void setActivity_code(String activity_code){
		this.activity_code = activity_code;
	};
	public String getActivity_name(){
		return activity_name;
	};
	
	public void setActivity_name(String activity_name){
		this.activity_name = activity_name;
	};
	public String getEffective_start_str(){
		return effective_start_str;
	};
	
	public void setEffective_start_str(String effective_start_str){
		this.effective_start_str = effective_start_str;
	};
	public String getEffective_end_str(){
		return effective_end_str;
	};
	
	public void setEffective_end_str(String effective_end_str){
		this.effective_end_str = effective_end_str;
	};
	public String getStatus(){
		return status;
	};
	
	public void setStatus(String status){
		this.status = status;
	};
	public String getDescription(){
		return description;
	};
	
	public void setDescription(String description){
		this.description = description;
	};
	public String getAccess_url(){
		return access_url;
	};
	
	public void setAccess_url(String access_url){
		this.access_url = access_url;
	};
	public String getEn_branch_no(){
		return en_branch_no;
	};
	
	public void setEn_branch_no(String en_branch_no){
		this.en_branch_no = en_branch_no;
	};
	public String getShow_flag(){
		return show_flag;
	};
	
	public void setShow_flag(String show_flag){
		this.show_flag = show_flag;
	};
	public String getIcon_abstract(){
		return icon_abstract;
	};
	
	public void setIcon_abstract(String icon_abstract){
		this.icon_abstract = icon_abstract;
	};
	public String getIcon_url(){
		return icon_url;
	};
	
	public void setIcon_url(String icon_url){
		this.icon_url = icon_url;
	};
	public String getBusi_content(){
		return busi_content;
	};
	
	public void setBusi_content(String busi_content){
		this.busi_content = busi_content;
	};
	public String getEvent_id(){
		return event_id;
	};
	
	public void setEvent_id(String event_id){
		this.event_id = event_id;
	};
}