package QnA.android;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class showquestion extends Activity implements OnClickListener {

	ArrayList<Content> content_list = new ArrayList<Content>();
	ArrayList<Content> content_sort = new ArrayList<Content>();
	private ContentAdapter mAdapter;
	private ListView mListView;
	private String[] spinner_item = { "번호", "글쓴이", "교재", "제목" };
	int textlength = 0;
	ContentAdapter adapter;
	EditText input;
	Spinner spinner;
	Button q_button;
	String selItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showqestion);

		Content content;

		content = new Content("1", "아이유", "플밍", "플밍입문");
		content_list.add(content);
		content = new Content("1", "티파니", "네트", "워크");
		content_list.add(content);
		Log.d("TAG",""+content_list.size());

		mListView = (ListView) findViewById(R.id.q_list);
		input = (EditText) findViewById(R.id.input);
		spinner = (Spinner) findViewById(R.id.spinner);
		q_button = (Button) findViewById(R.id.ask);

		q_button.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				Intent intent2 = new Intent(showquestion.this,
						askquestion.class);
				startActivity(intent2);

			}
		});

		/* spinner part */
		spinner.setPrompt("선택할 항목을 지정해주세요");
		ArrayAdapter<String> list1;
		list1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, spinner_item);
		spinner.setAdapter(list1);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				selItem = (String)spinner.getSelectedItem();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		
		/* search content */
		adapter = new ContentAdapter(this,R.layout.question_list_item, content_list);
		mListView.setAdapter(adapter);

		input.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

				textlength = input.getText().length();
				content_sort.clear();
				
				for(int i=0; i<content_list.size(); i++){
					
					if(selItem.equals("글쓴이")){
						Log.d("TAG","1");
						if(input.getText().toString().equalsIgnoreCase(content_list.get(i).getWriter()))
							content_sort.add(content_list.get(i));
					}
					else if(selItem.equals("교재")){
						if(input.getText().toString().equalsIgnoreCase(content_list.get(i).getBook()))
							content_sort.add(content_list.get(i));
						Log.d("TAG","2");
					}
					else if(selItem.equals("제목")){
						if(input.getText().toString().equalsIgnoreCase(content_list.get(i).getTitle()))
							content_sort.add(content_list.get(i));
						Log.d("TAG","3");
					}
					else{
						if(input.getText().toString().equalsIgnoreCase(content_list.get(i).getNumber()))
							content_sort.add(content_list.get(i));
						Log.d("TAG","4");
					}
				}
				ContentAdapter adapter1 = new ContentAdapter(showquestion.this, R.layout.question_list_item, content_sort);
				mListView.setAdapter(adapter1);
				adapter1.notifyDataSetChanged();
				

			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
