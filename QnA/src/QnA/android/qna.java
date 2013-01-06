package QnA.android;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.Toast;

public class qna extends Activity implements OnChildClickListener {

	ArrayList<ArrayList<Vehicle>> arr2 = new ArrayList<ArrayList<Vehicle>>();
	ExpandableListView elv;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.qna);
	    
	    ArrayList<String> arr1 = new ArrayList<String>();
		arr1.add("����������а�");
		arr1.add("��ǻ�Ͱ��а�");
		arr1.add("�����а�");
		arr1.add("����濵���а�");
		arr1.add("���а�");
		arr1.add("ȭ�а�");
		arr1.add("�����а�");
		arr1.add("������а�");
		arr1.add("�ż�����а�");
		arr1.add("ȭ�а��а�");
		arr1.add("â��IT���հ��а�");
		
		ArrayList<Vehicle> arrchild = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild2 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild3 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild4 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild5 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild6 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild7 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild8 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild9 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild10 = new ArrayList<Vehicle>();
		ArrayList<Vehicle> arrchild11 = new ArrayList<Vehicle>();
		Vehicle vehicle = new Vehicle("�ݵ�ü���ڰ���", "����������а�");
		Vehicle vehicle2 = new Vehicle("��ȣ �� �ý���","����������а�");
		Vehicle vehicle3 = new Vehicle("���������ڱ�","����������а�");
		Vehicle vehicle4 = new Vehicle("���ڰ���Թ�","��ǻ�Ͱ��а�");
		Vehicle vehicle5 = new Vehicle("���α׷��־��","��ǻ�Ͱ��а�");
		Vehicle vehicle6 = new Vehicle("��Ʈ��ũ","��ǻ�Ͱ��а�");
		arrchild.add(vehicle);
		arrchild.add(vehicle2);
		arrchild.add(vehicle3);
		arrchild2.add(vehicle4);
		arrchild2.add(vehicle5);
		arrchild2.add(vehicle6);
		arr2.add(arrchild);
		arr2.add(arrchild2);
		arr2.add(arrchild3);
		arr2.add(arrchild4);
		arr2.add(arrchild5);
		arr2.add(arrchild6);
		arr2.add(arrchild7);
		arr2.add(arrchild8);
		arr2.add(arrchild9);
		arr2.add(arrchild10);
		arr2.add(arrchild11);
		elv = (ExpandableListView)findViewById(R.id.elv_list);
		elv.setOnGroupCollapseListener(new OnGroupCollapseListener() {
			
			public void onGroupCollapse(int arg0) {
				return;
				
			}
		});
		
		ExpandableListAdapter adapter = new ExpandableListAdapter(this, arr1, arr2);
		elv.setAdapter(adapter);
		int count = adapter.getGroupCount();
		for (int i = 0; i < count; i++) {
			elv.collapseGroup(i);
		}
		elv.setOnChildClickListener(this);

	}
	
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		
		 Toast.makeText(qna.this, ""+groupPosition+childPosition+"",
				    Toast.LENGTH_SHORT).show();
		
		ArrayList<Vehicle> item = arr2.get(groupPosition);
		Vehicle v_item = item.get(childPosition);
		
		Intent intent = new Intent(this, showquestion.class);
		intent.putExtra("GROUP", v_item.getGroup());
		intent.putExtra("CHILD", v_item.getName());
		startActivity(intent);
		
		return true;
	}

}
