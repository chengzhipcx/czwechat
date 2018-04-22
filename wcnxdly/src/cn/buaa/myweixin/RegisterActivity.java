package cn.buaa.myweixin;

import java.util.HashMap;
import java.util.Map;

import cn.buaa.utils.Constant;
import cn.buaa.utils.GetPostUrl;
import android.app.Activity;
import android.content.Intent; 
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author chengzhi
 * 注册界面
 */
public  class RegisterActivity extends Activity {
	private EditText number,password,okpassword;
	private Button zhuce,cancel;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		zhuce = (Button)findViewById(R.id.button1);
		cancel= (Button)findViewById(R.id.button2);
		number = (EditText)findViewById(R.id.editText1);
		password = (EditText)findViewById(R.id.editText2);
		okpassword = (EditText)findViewById(R.id.editText3);
		zhuce.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				if(number.getText().toString().equals("")||password.getText().toString().equals("")||okpassword.getText().toString().equals("")){
					Toast toast = Toast.makeText(getApplicationContext(), "请输入完整信息", Toast.LENGTH_SHORT);
					toast.show();
				}if(number.getText().toString().length()!=11){
					Toast toast = Toast.makeText(getApplicationContext(), "请输入正确的手机号", Toast.LENGTH_SHORT);
					toast.show();
				}if(!password.getText().toString().equals(okpassword.getText().toString())){
					Toast toast = Toast.makeText(getApplicationContext(), "两次密码输入不一致请重新输入", Toast.LENGTH_SHORT);
					toast.show();
				}else{
					Map<String, String> map = new HashMap<String, String>();
					map.put("username", number.getText().toString());
					map.put("password", password.getText().toString());
					GetPostUrl.post(Constant.URL_Register, map);
					Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(RegisterActivity.this,Login.class);
					startActivity(intent);
				}
			}
		});
		cancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(RegisterActivity.this,Welcome.class);
				startActivity(intent);
			}
		});
	}
	
}

