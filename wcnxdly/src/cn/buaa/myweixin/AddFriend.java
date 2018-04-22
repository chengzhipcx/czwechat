package cn.buaa.myweixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.buaa.model.User;
import cn.buaa.utils.NetUtils;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class AddFriend extends Activity {  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.addfriend);  
        ListView listView = (ListView) this.findViewById(R.id.listView_friend);  
//          
        //获取到集合数据  
        List<HashMap<String, Object>> data =NetUtils.getFriendData(MainWeixin.userId);

       //创建SimpleAdapter适配器将数据绑定到item显示控件上  
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item,
				new String[] { "name", "phone", "amount" }, new int[] {
						R.id.name, R.id.phone, 1 });
		// 实现列表的显示
		listView.setAdapter(adapter);
		// 条目点击事件
		listView.setOnItemClickListener(new ItemClickListener());
	}

	// 获取点击事件
	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView
					.getItemAtPosition(position);
			String personid = data.get("id").toString();
			System.out.println(""+personid);
			// 添加好友
			String state = NetUtils.addfriend(MainWeixin.userId, Integer.parseInt(personid));
			Toast.makeText(getApplicationContext(), state, 1).show();
		}
    }  
}  
