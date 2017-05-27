package btp.oneP;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
	//JSON是一种与开发语言无关的，轻量级的数据格式。全称：JavaScript Object Notation
	//易读易编写，易于程序解析与生产
	//key : value存储方式，key为字符串，value可为string，number，true，false，null等数据结构或数据结构
	//{}表示对象，[]表示数组array
	//json解析网址：json.cn
	public static void main(String...args){
		//标准的json里面是没有注释的
		
		//一个简单json例子
		String aPersonJson = "                                  "
				+ "          {                                  "
				+ "            'name' : '王小二',                 "
				+ "            'age' : 25,                      "
				+ "            'birthday' : '1990-01-01',       "
				+ "            'school' : '蓝翔',                "
				+ "            'major' : ['理发','发掘机'],        "
				+ "            'hasGirlfriend' : false,         "
				+ "            'car' : {                        "
				+ "					'name' : 'BMW',				"
				+ "                 'price' : 500000            "
				+ "				},                              "
				+ "            'house' : null                   "
				+ "          }                                  ";
		
		JSONObject jo = new JSONObject();
		jo = JSONObject.fromObject(aPersonJson);
		//添加项
		jo.put("idol", "btp");
		Object name = jo.get("name");
		Object car = jo.get("car");
		Object major = jo.get("major");
		
		System.out.println(name);//输出：王小二
		System.out.println(car);//输出：{"name":"BMW","price":500000}
		//major的类型是JSONArray
		System.out.println(major.getClass().getSimpleName());//输出：JSONArray
		//car的类型是JSONObject
		System.out.println(car.getClass().getSimpleName());//输出：JSONObject
		
		//输出：
		//{"name":"王小二","age":25,"birthday":"1990-01-01","school":"蓝翔","major":["理发","发掘机"],"hasGirlfriend":false,"car":{"name":"BMW","price":500000},"house":null,"idol":"btp"}
		System.out.println(jo);
		
		System.out.println("-------------------------------分割线------------------------------------------");
		
		
		//也可以使用put来构建json
		JSONObject xiaomi6 = new JSONObject();
		xiaomi6.put("名字", "小米6");
		xiaomi6.put("价格", 2499);
		xiaomi6.put("主屏尺寸", "5.15英寸");
		xiaomi6.put("主屏分辨率", "1920 x 1080像素");
		xiaomi6.put("电池容量", "3350mAh");
		JSONArray camera = new JSONArray();
		JSONObject backCamera = new JSONObject();
		backCamera.put("主", "1200万像素");
		backCamera.put("副", "1200万像素");
		camera.add(backCamera);
		camera.add("800万像素");
		xiaomi6.put("摄像头", camera);
		JSONArray competitor = new JSONArray();
		competitor.add("samsung S8");
		competitor.add("huawei P10");
		competitor.add("Iphone7 red");
		xiaomi6.put("友商", competitor);
		
		Map<String,Object> leijunMap = new HashMap<String,Object>();
		leijunMap.put("姓名", "Mr.雷");
		leijunMap.put("年龄", 48);
		leijunMap.put("职位", new String[]{"小米总裁","流行音乐引导者","小米之家创始人"});
		leijunMap.put("爱好", "Are you OK？");
		
		//JSONObject leijunOB = JSONObject.fromObject(leijunMap);
		xiaomi6.put("promulgator", leijunMap);
		System.out.println(xiaomi6);
		//格式化xiaomi6
		/*
		{
		    "名字": "小米6",
		    "价格": 2499,
		    "主屏尺寸": "5.15英寸",
		    "主屏分辨率": "1920 x 1080像素",
		    "电池容量": "3350mAh",
		    "摄像头": [
		        {
		            "主": "1200万像素",
		            "副": "1200万像素"
		        },
		        "800万像素"
		    ],
		    "友商": [
		        "samsung S8",
		        "huawei P10",
		        "Iphone7 red"
		    ],
		    "promulgator": {
		        "姓名": "Mr.雷",
		        "爱好": "Are you OK？",
		        "年龄": 48,
		        "职位": [
		            "小米总裁",
		            "流行音乐引导者",
		            "小米之家创始人"
		        ]
		    }
		}
		*/
		
		//net.sf.json对json和bean相互转化不大友好，Gson在bean和json转化方面做得更为出色
	}
}
