package com.wj.wj24game;

import java.util.ArrayList;

import com.wj.wj24game.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
public class Answers extends ActionBarActivity {
	
	private TextView textview_Answers;
	private Button back;
	private ArrayList<String> answers;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answers);
		
		textview_Answers = (TextView) findViewById(R.id.answers);
		back = (Button) findViewById(R.id.back);
		
		
		Bundle bundle = getIntent().getExtras();
		answers = bundle.getStringArrayList("answers");
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<answers.size(); i++){
			sb.append(answers.get(i));
			sb.append("\n");
		}
		
		textview_Answers.setText(sb.toString());

		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Answers.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.answers, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_answers,
					container, false);
			return rootView;
		}
	}

}
