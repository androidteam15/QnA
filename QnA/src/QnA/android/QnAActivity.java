package QnA.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QnAActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button lec = (Button)findViewById(R.id.lec);
        Button qna = (Button)findViewById(R.id.qna);
        
        
        lec.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent1 = new Intent(QnAActivity.this, lec.class);
				startActivity(intent1);
			}	
        });
        
        qna.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent2 = new Intent(QnAActivity.this, qna.class);
				startActivity(intent2);
			}
        	
        	
        });
        
    }
}