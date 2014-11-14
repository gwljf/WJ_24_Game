package com.wj.wj24game;

import java.util.ArrayList;
import java.util.Random;

import com.wj.wj24game.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Math_24_game_MainActivity extends ActionBarActivity {
	
	private Button add;
	private Button sub;
	private Button mul;
	private Button div;
	private Button left;
	private Button right;
	private Button clear;
	private Button check;
	private Button exit;
	private Button next;
	private ImageView c1;
	private ImageView c2;
	private ImageView c3;
	private ImageView c4;
	private TextView textview;
	private Button show_answers;
	private int[] random4 = new int[4];
	private ArrayList<String> answers = new ArrayList<String>();
	private Random rm = new Random();
	private StringBuilder sbText = new StringBuilder();
	private boolean preIsCard = false;
	private boolean[] cardUsed = new boolean[4];
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math_24_game_main);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        clear = (Button) findViewById(R.id.clear);
        check = (Button) findViewById(R.id.check);
        show_answers = (Button) findViewById(R.id.showallanswers);
        next = (Button) findViewById(R.id.next);
        exit = (Button) findViewById(R.id.exit);
        c1 = (ImageView) findViewById(R.id.image1);
        c2 = (ImageView) findViewById(R.id.image2);
        c3 = (ImageView) findViewById(R.id.image3);
        c4 = (ImageView) findViewById(R.id.image4);
        textview = (TextView) findViewById(R.id.textview);
        
        
        
        while(true){
    		random4[0] = rm.nextInt(13)+1;
    		random4[1] = rm.nextInt(13)+1;
    		random4[2] = rm.nextInt(13)+1;
    		random4[3] = rm.nextInt(13)+1;
            Checker checker = new Checker(random4);
            answers = checker.check();
            if(answers.size()!=0){
            	break;
            }
        }

        setPorker(random4);
        
        c1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!preIsCard && !cardUsed[0]){
					sbText.append(String.valueOf(random4[0]));
					Math_24_game_MainActivity.this.textview.setText(sbText);
					c1.setImageResource(R.drawable.back);
					preIsCard=true;
					cardUsed[0]=true;
				}else{
					Toast.makeText(Math_24_game_MainActivity.this, "There must be at least one operator between them and one card can be used only one time!", Toast.LENGTH_SHORT).show();;
				}
			}
		});
        
        c2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				if(!preIsCard && !cardUsed[1]){
					sbText.append(String.valueOf(random4[1]));
					Math_24_game_MainActivity.this.textview.setText(sbText);
					c2.setImageResource(R.drawable.back);
					preIsCard = true;
					cardUsed[1] = true;
				}else{
					Toast.makeText(Math_24_game_MainActivity.this, "There must be at least one operator between them!", Toast.LENGTH_SHORT).show();;
				}
			}
		});
        
        c3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!preIsCard && !cardUsed[2]){
					sbText.append(String.valueOf(random4[2]));
					Math_24_game_MainActivity.this.textview.setText(sbText);
					c3.setImageResource(R.drawable.back);
					preIsCard=true;
					cardUsed[2]=true;
				}else{
					Toast.makeText(Math_24_game_MainActivity.this, "There must be at least one operator between them!", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        c4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!preIsCard  && !cardUsed[3]){
					sbText.append(String.valueOf(random4[3]));
					Math_24_game_MainActivity.this.textview.setText(sbText);
					c4.setImageResource(R.drawable.back);
					preIsCard = true;
					cardUsed[3]=true;
				}else{
					Toast.makeText(Math_24_game_MainActivity.this, "There must be at least one operator between them!", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.append("+");
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
			}
		});
        
		sub.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.append("-");
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
			}
		});
		
		
		mul.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.append("*");
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
			}
		});
		
		div.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.append("/");
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
			}
		});
        
		left.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.append("(");
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
			}
		});
		
		right.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.append(")");
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
			}
		});
		
		clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sbText.delete(0, sbText.length());
				Math_24_game_MainActivity.this.textview.setText(sbText);
				Math_24_game_MainActivity.this.setPorker(random4);
				preIsCard = false;
				cardUsed[0]=cardUsed[1]=cardUsed[2]=cardUsed[3]=false;
			}
		});	
        
		
		show_answers.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
				bundle.putStringArrayList("answers", answers);
				Intent i = new Intent(Math_24_game_MainActivity.this, Answers.class);
				i.putExtras(bundle);
				startActivity(i);
			}
		});
		
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				while(true){
		    		random4[0] = rm.nextInt(13)+1;
		    		random4[1] = rm.nextInt(13)+1;
		    		random4[2] = rm.nextInt(13)+1;
		    		random4[3] = rm.nextInt(13)+1;
		            Checker checker = new Checker(random4);
		            answers = checker.check();
		            if(answers.size()!=0){
		            	break;
		            }
		        }
		        setPorker(random4);
		        sbText.delete(0, sbText.length());
				Math_24_game_MainActivity.this.textview.setText(sbText);
				preIsCard = false;
				cardUsed[0]=cardUsed[1]=cardUsed[2]=cardUsed[3]=false;
			}
		});
		
		exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Math_24_game_MainActivity.this.finish();
			}
		});
		
		check.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calculator calculator = new Calculator();
				try {
					if(calculator.analysis(sbText.toString())==24){
						Toast.makeText(Math_24_game_MainActivity.this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();;
					}else{
						Toast.makeText(Math_24_game_MainActivity.this, "Sorry, You are wrong!", Toast.LENGTH_SHORT).show();;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(Math_24_game_MainActivity.this, "Sorry, the expresstion is wrong or number is divided by 0.", Toast.LENGTH_SHORT).show();;
				}
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.math_24_game__main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_math_24_game__main, container, false);
            return rootView;
        }
    }
    
    public void setPorker(int[] random4){
    	switch(random4[0]){
    		case 1:
    			c1.setImageResource(R.drawable.c1);
    			break;
    		case 2:
    			c1.setImageResource(R.drawable.c2);
    			break;
    		case 3:
    			c1.setImageResource(R.drawable.c3);
    			break;
    		case 4:
    			c1.setImageResource(R.drawable.c4);
    			break;
    		case 5:
    			c1.setImageResource(R.drawable.c5);
    			break;
    		case 6:	
    			c1.setImageResource(R.drawable.c6);
    			break;
			case 7:
				c1.setImageResource(R.drawable.c7);
				break;
			case 8:
				c1.setImageResource(R.drawable.c8);
				break;
			case 9:
				c1.setImageResource(R.drawable.c9);
				break;
			case 10:
				c1.setImageResource(R.drawable.c10);
				break;
			case 11:
				c1.setImageResource(R.drawable.c11);
				break;
			case 12:
				c1.setImageResource(R.drawable.c12);
				break;
			case 13:
				c1.setImageResource(R.drawable.c13);
				break;
    		default:
    			break;
    	}
    	
    	switch(random4[1]){
			case 1:
				c2.setImageResource(R.drawable.c1);
				break;
			case 2:
				c2.setImageResource(R.drawable.c2);
				break;
			case 3:
				c2.setImageResource(R.drawable.c3);
				break;
			case 4:
				c2.setImageResource(R.drawable.c4);
				break;
			case 5:
				c2.setImageResource(R.drawable.c5);
				break;
			case 6:	
				c2.setImageResource(R.drawable.c6);
				break;
			case 7:
				c2.setImageResource(R.drawable.c7);
				break;
			case 8:
				c2.setImageResource(R.drawable.c8);
				break;
			case 9:
				c2.setImageResource(R.drawable.c9);
				break;
			case 10:
				c2.setImageResource(R.drawable.c10);
				break;
			case 11:
				c2.setImageResource(R.drawable.c11);
				break;
			case 12:
				c2.setImageResource(R.drawable.c12);
				break;
			case 13:
				c2.setImageResource(R.drawable.c13);
				break;
			default:
				break;
    	}
    	
    	switch(random4[2]){
			case 1:
				c3.setImageResource(R.drawable.c1);
				break;
			case 2:
				c3.setImageResource(R.drawable.c2);
				break;
			case 3:
				c3.setImageResource(R.drawable.c3);
				break;
			case 4:
				c3.setImageResource(R.drawable.c4);
				break;
			case 5:
				c3.setImageResource(R.drawable.c5);
				break;
			case 6:	
				c3.setImageResource(R.drawable.c6);
				break;
			case 7:
				c3.setImageResource(R.drawable.c7);
				break;
			case 8:
				c3.setImageResource(R.drawable.c8);
				break;
			case 9:
				c3.setImageResource(R.drawable.c9);
				break;
			case 10:
				c3.setImageResource(R.drawable.c10);
				break;
			case 11:
				c3.setImageResource(R.drawable.c11);
				break;
			case 12:
				c3.setImageResource(R.drawable.c12);
				break;
			case 13:
				c3.setImageResource(R.drawable.c13);
				break;
			default:
				break;
    	}
    	
    	switch(random4[3]){
			case 1:
				c4.setImageResource(R.drawable.c1);
				break;
			case 2:
				c4.setImageResource(R.drawable.c2);
				break;
			case 3:
				c4.setImageResource(R.drawable.c3);
				break;
			case 4:
				c4.setImageResource(R.drawable.c4);
				break;
			case 5:
				c4.setImageResource(R.drawable.c5);
				break;
			case 6:	
				c4.setImageResource(R.drawable.c6);
				break;
			case 7:
				c4.setImageResource(R.drawable.c7);
				break;
			case 8:
				c4.setImageResource(R.drawable.c8);
				break;
			case 9:
				c4.setImageResource(R.drawable.c9);
				break;
			case 10:
				c4.setImageResource(R.drawable.c10);
				break;
			case 11:
				c4.setImageResource(R.drawable.c11);
				break;
			case 12:
				c4.setImageResource(R.drawable.c12);
				break;
			case 13:
				c4.setImageResource(R.drawable.c13);
				break;
			default:
				break;
    	}
    }

}
