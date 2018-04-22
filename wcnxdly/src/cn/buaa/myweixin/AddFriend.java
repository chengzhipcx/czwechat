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
        //��ȡ����������  
        List<HashMap<String, Object>> data =NetUtils.getFriendData(MainWeixin.userId);

       //����SimpleAdapter�����������ݰ󶨵�item��ʾ�ؼ���  
		SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item,
				new String[] { "name", "phone", "amount" }, new int[] {
						R.id.name, R.id.phone, 1 });
		// ʵ���б����ʾ
		listView.setAdapter(adapter);
		// ��Ŀ����¼�
		listView.setOnItemClickListener(new ItemClickListener());
	}

	// ��ȡ����¼�
	private final class ItemClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView listView = (ListView) parent;
			HashMap<String, Object> data = (HashMap<String, Object>) listView
					.getItemAtPosition(position);
			String personid = data.get("id").toString();
			System.out.println(""+personid);
			// ��Ӻ���
			String state = NetUtils.addfriend(MainWeixin.userId, Integer.parseInt(personid));
			Toast.makeText(getApplicationContext(), state, 1).show();
		}
    }  
}  
