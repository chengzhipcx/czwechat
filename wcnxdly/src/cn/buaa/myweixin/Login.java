package cn.buaa.myweixin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.buaa.utils.Constant;
import cn.buaa.utils.GetPostUrl;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author chengzhi
 *	登陆界面
 */
public class Login extends Activity {
	private EditText mUser; // 帐号编辑框
	private EditText mPassword; // 密码编辑框
	private Button loginBt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		mUser = (EditText) findViewById(R.id.login_user_edit);
		mPassword = (EditText) findViewById(R.id.login_passwd_edit);
		loginBt = (Button) findViewById(R.id.login_login_btn);
		loginBt.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				login_mainweixin(v);
			}
		});
	}

	public void login_mainweixin(View v) {
		String user = mUser.getText().toString().trim();
		String pwd = mPassword.getText().toString().trim();

		if (!"".equals(mUser.getText().toString())
				&& !"".equals(mPassword.getText().toString())) // 判断 帐号和密码
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", user);
			map.put("password", pwd);
			String sendPost = GetPostUrl.post(Constant.URL_Login, map);
			System.out.println("------------" + sendPost);
			JSONObject parseObject = JSON.parseObject(sendPost);
			String s = (String) parseObject.get("message");
			int userid =  (Integer) parseObject.get("result");
			System.out.println("------------" + sendPost);
			if ("ok".equals(s)) {
				Toast.makeText(getApplicationContext(), "登录成功",
				Toast.LENGTH_SHORT).show();
				Intent intent = new Intent();
				intent.setClass(Login.this, LoadingActivity.class);
				intent.putExtra("userId", userid);
				startActivity(intent);
			}else{
				Toast.makeText(getApplicationContext(), s,
				Toast.LENGTH_SHORT).show();
			}
			// Toast.makeText(getApplicationContext(), "登录成功",
			// Toast.LENGTH_SHORT).show();
		} else if ("".equals(mUser.getText().toString())
				|| "".equals(mPassword.getText().toString())) // 判断 帐号和密码
		{
			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录错误").setMessage("帐号或者密码不能为空，\n请输入后再登录！")
					.create().show();
		} else {

			new AlertDialog.Builder(Login.this)
					.setIcon(
							getResources().getDrawable(
									R.drawable.login_error_icon))
					.setTitle("登录失败").setMessage("帐号或者密码不正确，\n请检查后重新输入！")
					.create().show();
		}

		// 登录按钮
		/*
		 * Intent intent = new Intent();
		 * intent.setClass(Login.this,Whatsnew.class); startActivity(intent);
		 * Toast.makeText(getApplicationContext(), "登录成功",
		 * Toast.LENGTH_SHORT).show(); this.finish();
		 */
	}

	public void login_back(View v) { // 标题栏 返回按钮
		this.finish();
	}

	public void login_pw(View v) { // 忘记密码按钮
		Uri uri = Uri.parse("http://3g.qq.com");
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);
		// Intent intent = new Intent();
		// intent.setClass(Login.this,Whatsnew.class);
		// startActivity(intent);
	}
}
