package com.example.helloworld;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class DisplayMessageActivity extends Activity {
	public static int count = 0;
	public static List<Objects> objects = new ArrayList<Objects>();
	public static int total;
	public static String lang="en";
	public static MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		Intent intent = getIntent();
	    String fileName = intent.getStringExtra(MainActivity.LOAD_FILE);
	    lang = "en";
		mp = new MediaPlayer();
		try {
			objects = SAXXMLParser.parse(getAssets().open(fileName));//"fruits.xml"));
		} catch (IOException e) {
            e.printStackTrace();
        }

		
	    total = objects.size();
		
		loadValues();
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/*switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);*/
		switch (item.getItemId()) {
			case R.id.menu_en:
				lang = "en";
				loadValues();
				return true;
			case R.id.menu_ta:
				lang = "ta";
				loadValues();
				return true;
			default:
	            return super.onOptionsItemSelected(item);
		}
	}

	public void loadNext(View view) {
		if(total > 0) {
			if(count < total - 1) { 
				count++;
			} else {
				count = 0;
			}
			loadValues();
		}
    }
	
	public void loadPrevious(View view) {
		if(total > 0) {
			if(count > 0) { 
				count--;
			} else {
				count = total - 1;
			}
			loadValues();
		}
    }
	private void loadValues(){
		
		Objects obj = (Objects)objects.get(count);
		
		TextView textView= (TextView) findViewById(R.id.text);
		System.out.println("b4 textview-"+obj.getName());
		System.out.println("lang>>>>"+lang);
		System.out.println("textView>>>>"+textView);
		if (lang.equalsIgnoreCase("en")) {
			textView.setText(obj.getName());
		} else if (lang.equalsIgnoreCase("ta")) {
			textView.setText(Html.fromHtml(obj.getNameta()).toString());
		}
		System.out.println("gettext-"+textView.getText());

		ImageView img= (ImageView) findViewById(R.id.image);
		int resID = getResources().getIdentifier(obj.getImage(), "drawable", getPackageName());
	    img.setImageResource(resID);
	    
	    if(mp!=null && mp.isPlaying()){//If music is playing already
            mp.stop();//Stop playing the music
        }
	    
        try{
        	//mp.setDataSource("file://res/raw/ring.mp3");//Write your location here
            //mp.setDataSource("android.resource://com.example.helloworld/raw/ring.mp3");
            //mp.setDataSource("res/raw/ring.mp3");
            //mp.setDataSource(this, Uri.parse("res/raw/ring.mp3"));
        	//int resID=getResources().getIdentifier("ring.mp3", "raw", getPackageName());
        	/*if(mPlayer!=null && mPlayer.isPlaying()){//If music is playing already
                mPlayer.stop();//Stop playing the music
            }*/
            //mp=MediaPlayer.create(this, R.raw.ring);
            resID = getResources().getIdentifier(obj.getAudio(), "raw", getPackageName());
            mp=MediaPlayer.create(this, resID);
            mp.start();
            mp.setOnCompletionListener(new OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // TODO Auto-generated method stub
                    mp.reset();
                    mp.release();
                    mp=null;
                }

            });
              
              
        }catch(Exception e){e.printStackTrace();}
        
	}
	
}
