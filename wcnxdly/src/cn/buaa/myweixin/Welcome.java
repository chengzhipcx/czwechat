package cn.buaa.myweixin;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/**
 * @author chengzhi
 * 
 */
public class Welcome extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }
    public void welcome_login(View v) {  
      	Intent intent = new Intent();
		intent.setClass(Welcome.this,Login.class);
		startActivity(intent);
		//this.finish();
      }  
    public void welcome_register(View v) {  
      	Intent intent = new Intent();
		intent.setClass(Welcome.this,RegisterActivity.class);
		startActivity(intent);
		//this.finish();
      }  
    public void welcome_main(View v) {  
      	Intent intent = new Intent();
		intent.setClass(Welcome.this,MainWeixin.class);
		intent.putExtra("userId", 1);
		startActivity(intent);
		//this.finish();
      }  
}
