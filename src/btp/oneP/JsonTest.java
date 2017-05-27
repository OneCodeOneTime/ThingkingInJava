package btp.oneP;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
	//JSON��һ���뿪�������޹صģ������������ݸ�ʽ��ȫ�ƣ�JavaScript Object Notation
	//�׶��ױ�д�����ڳ������������
	//key : value�洢��ʽ��keyΪ�ַ�����value��Ϊstring��number��true��false��null�����ݽṹ�����ݽṹ
	//{}��ʾ����[]��ʾ����array
	//json������ַ��json.cn
	public static void main(String...args){
		//��׼��json������û��ע�͵�
		
		//һ����json����
		String aPersonJson = "                                  "
				+ "          {                                  "
				+ "            'name' : '��С��',                 "
				+ "            'age' : 25,                      "
				+ "            'birthday' : '1990-01-01',       "
				+ "            'school' : '����',                "
				+ "            'major' : ['��','�����'],        "
				+ "            'hasGirlfriend' : false,         "
				+ "            'car' : {                        "
				+ "					'name' : 'BMW',				"
				+ "                 'price' : 500000            "
				+ "				},                              "
				+ "            'house' : null                   "
				+ "          }                                  ";
		
		JSONObject jo = new JSONObject();
		jo = JSONObject.fromObject(aPersonJson);
		//�����
		jo.put("idol", "btp");
		Object name = jo.get("name");
		Object car = jo.get("car");
		Object major = jo.get("major");
		
		System.out.println(name);//�������С��
		System.out.println(car);//�����{"name":"BMW","price":500000}
		//major��������JSONArray
		System.out.println(major.getClass().getSimpleName());//�����JSONArray
		//car��������JSONObject
		System.out.println(car.getClass().getSimpleName());//�����JSONObject
		
		//�����
		//{"name":"��С��","age":25,"birthday":"1990-01-01","school":"����","major":["��","�����"],"hasGirlfriend":false,"car":{"name":"BMW","price":500000},"house":null,"idol":"btp"}
		System.out.println(jo);
		
		System.out.println("-------------------------------�ָ���------------------------------------------");
		
		
		//Ҳ����ʹ��put������json
		JSONObject xiaomi6 = new JSONObject();
		xiaomi6.put("����", "С��6");
		xiaomi6.put("�۸�", 2499);
		xiaomi6.put("�����ߴ�", "5.15Ӣ��");
		xiaomi6.put("�����ֱ���", "1920 x 1080����");
		xiaomi6.put("�������", "3350mAh");
		JSONArray camera = new JSONArray();
		JSONObject backCamera = new JSONObject();
		backCamera.put("��", "1200������");
		backCamera.put("��", "1200������");
		camera.add(backCamera);
		camera.add("800������");
		xiaomi6.put("����ͷ", camera);
		JSONArray competitor = new JSONArray();
		competitor.add("samsung S8");
		competitor.add("huawei P10");
		competitor.add("Iphone7 red");
		xiaomi6.put("����", competitor);
		
		Map<String,Object> leijunMap = new HashMap<String,Object>();
		leijunMap.put("����", "Mr.��");
		leijunMap.put("����", 48);
		leijunMap.put("ְλ", new String[]{"С���ܲ�","��������������","С��֮�Ҵ�ʼ��"});
		leijunMap.put("����", "Are you OK��");
		
		//JSONObject leijunOB = JSONObject.fromObject(leijunMap);
		xiaomi6.put("promulgator", leijunMap);
		System.out.println(xiaomi6);
		//��ʽ��xiaomi6
		/*
		{
		    "����": "С��6",
		    "�۸�": 2499,
		    "�����ߴ�": "5.15Ӣ��",
		    "�����ֱ���": "1920 x 1080����",
		    "�������": "3350mAh",
		    "����ͷ": [
		        {
		            "��": "1200������",
		            "��": "1200������"
		        },
		        "800������"
		    ],
		    "����": [
		        "samsung S8",
		        "huawei P10",
		        "Iphone7 red"
		    ],
		    "promulgator": {
		        "����": "Mr.��",
		        "����": "Are you OK��",
		        "����": 48,
		        "ְλ": [
		            "С���ܲ�",
		            "��������������",
		            "С��֮�Ҵ�ʼ��"
		        ]
		    }
		}
		*/
		
		//net.sf.json��json��bean�໥ת�������Ѻã�Gson��bean��jsonת���������ø�Ϊ��ɫ
	}
}
