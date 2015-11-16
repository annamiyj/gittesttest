package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//不显示title，必须在setContentView()之前执行
		setContentView(R.layout.first_layout);
		Button button1 = (Button)findViewById(R.id.button_1);
		
//		button1.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
//			}
//		});
		
//		//退出应用
//		button1.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				//销毁活动
//				finish();	
//			}
//		});
		
		//启动其他活动，显性intent
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//启动其他活动
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
		
		//启动其他活动，隐性intent
				button1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						//启动其他活动
						Intent intent = new Intent("com.example.activitytest.ACTION_START");
						intent.addCategory("com.example.activitytest.MY_GATEGORY");
						startActivity(intent);
					}
				});
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch(item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
		case R.id.test_item:
			Toast.makeText(this, "You clicked test", Toast.LENGTH_LONG).show();
		default:
		}
		return true;
	}
	
}



