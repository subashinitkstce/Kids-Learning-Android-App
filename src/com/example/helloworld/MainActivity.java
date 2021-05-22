package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
	public final static String LOAD_FILE = "com.example.helloworld.FILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message);
    	//String message = editText.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    public void loadFruits(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message);
    	//String message = editText.getText().toString();
    	intent.putExtra(LOAD_FILE, "fruits.xml");
    	startActivity(intent);
    }
    public void onClickHandler (View v) 
    {
    	System.out.println("onClickHandler>>>>");
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
        switch (v.getId()) {
        	case R.id.fruits:
        		intent.putExtra(LOAD_FILE, "fruits.xml");
        		break;
        	case R.id.vegetables:
        		intent.putExtra(LOAD_FILE, "vegetables.xml");
        		break;
        	case R.id.animals:
        		intent.putExtra(LOAD_FILE, "fruits.xml");
        		break;
        	/*case R.id.birds:
        		intent.putExtra(LOAD_FILE, "fruits.xml");
        		break;
        	case R.id.colors:
        		intent.putExtra(LOAD_FILE, "fruits.xml");
        		break;
        	case R.id.alphabets:
        		intent.putExtra(LOAD_FILE, "fruits.xml");
        		break;*/
        	default:
        		intent.putExtra(LOAD_FILE, "fruits.xml");
        		break;
        }

        startActivity(intent);
    }
}

