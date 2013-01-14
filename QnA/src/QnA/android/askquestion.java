package QnA.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class askquestion extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.askquestion);

		Button upload = (Button) findViewById(R.id.upload);
		Button ok_upload = (Button) findViewById(R.id.ok_upload);
		Button cancel_upload = (Button) findViewById(R.id.cancel_upload);

		
		upload.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent up_intent = new Intent(Intent.ACTION_PICK);
				up_intent.setType("image/*");
				up_intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(up_intent, 0);
			}
		});
		
		
		ok_upload.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
		
		
		cancel_upload.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				finish();
				
			}
		});
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent){
		
	}

}
