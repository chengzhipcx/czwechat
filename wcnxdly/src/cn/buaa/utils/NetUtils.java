package cn.buaa.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class NetUtils {

	public static List<HashMap<String, Object>> getFriendData(int userId) {
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> item = new HashMap<String, Object>();
//		item.put("id", "1");
//		item.put("name", "111");
//		item.put("phone", "111");
//		item.put("amount", "111");
//		data.add(item);
//		HashMap<String, Object> item1 = new HashMap<String, Object>();
//		item1.put("id", "1");
//		item1.put("name", "111");
//		item1.put("phone", "111");
//		item1.put("amount", "111");
//		data.add(item1);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userId+"");
		String s =GetPostUrl.post(Constant.URL_Friends, map);
		HashMap jsonMap = fromJson2Map(s);  
		List<HashMap<String, Object>> configDataList = (List<HashMap<String, Object>>)jsonMap.get("result");  
		return configDataList;
	}

	public static String addfriend(int a, int b) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a_id", a+"");
		map.put("b_id", b+"");
		String s =GetPostUrl.post(Constant.URL_addFriends, map);
		return s;
	}
	
	public static List<HashMap<String, Object>> getOurFriendData(int userId) {
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
//		HashMap<String, Object> item = new HashMap<String, Object>();
//		item.put("id", "1");
//		item.put("name", "111");
//		item.put("phone", "111");
//		item.put("amount", "111");
//		data.add(item);
//		HashMap<String, Object> item1 = new HashMap<String, Object>();
//		item1.put("id", "1");
//		item1.put("name", "111");
//		item1.put("phone", "111");
//		item1.put("amount", "111");
//		data.add(item1);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userId+"");
		String s =GetPostUrl.post(Constant.URL_MyFriends, map);
		HashMap jsonMap = fromJson2Map(s);  
		List<HashMap<String, Object>> configDataList = (List<HashMap<String, Object>>)jsonMap.get("result");  
		return configDataList;
	}  
	
	
	
	
	
	
	
	public static HashMap<String, Object> fromJson2Map(String jsonString) {  
	    HashMap jsonMap = JSON.parseObject(jsonString, HashMap.class);  
	  
	    HashMap<String, Object> resultMap = new HashMap<String, Object>();  
	    for(Iterator iter = jsonMap.keySet().iterator(); iter.hasNext();){  
	        String key = (String)iter.next();  
	        if(jsonMap.get(key) instanceof JSONArray){  
	            JSONArray jsonArray = (JSONArray)jsonMap.get(key);  
	            List list = handleJSONArray(jsonArray);  
	            resultMap.put(key, list);  
	        }else{  
	            resultMap.put(key, jsonMap.get(key));  
	        }  
	    }  
	    return resultMap;  
	}  
	  
	private static List<HashMap<String, Object>> handleJSONArray(JSONArray jsonArray){  
	    List list = new ArrayList();  
	    for (Object object : jsonArray) {  
	        JSONObject jsonObject = (JSONObject) object;  
	        HashMap map = new HashMap<String, Object>();  
	        for (Map.Entry entry : jsonObject.entrySet()) {  
	            if(entry.getValue() instanceof  JSONArray){  
	                map.put((String)entry.getKey(), handleJSONArray((JSONArray)entry.getValue()));  
	            }else{  
	                map.put((String)entry.getKey(), entry.getValue());  
	            }  
	        }  
	        list.add(map);  
	    }  
	    return list;  
	}

	
}
