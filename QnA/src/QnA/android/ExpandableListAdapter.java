package QnA.android;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandableListAdapter extends BaseExpandableListAdapter{
	
    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    private Context context;
    private ArrayList<String> groups;
    private ArrayList<ArrayList<Vehicle>> children;
    private Activity activity;

    public ExpandableListAdapter(Context context, ArrayList<String> groups,
            ArrayList<ArrayList<Vehicle>> children) {
        this.context = context;
        this.groups = groups;
        this.children = children;
    }

    public void addItem(Vehicle vehicle) {
        if (!groups.contains(vehicle.getGroup())) {
            groups.add(vehicle.getGroup());
        }
        int index = groups.indexOf(vehicle.getGroup());
        if (children.size() < index + 1) {
            children.add(new ArrayList<Vehicle>());
        }
        children.get(index).add(vehicle);
    }


    public Object getChild(int groupPosition, int childPosition) {
        return children.get(groupPosition).get(childPosition);
    }


    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    
    // Return a child view. You can load your custom layout here.

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent) {
    	
        Vehicle vehicle = (Vehicle) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout, null);
        }
        
        
    	ImageView child = (ImageView)convertView.findViewById(R.id.ImageView01);
    	if(vehicle.getName().equals("����")){
    		child.setBackgroundResource(R.drawable.a1);
        }
    	else if(vehicle.getName().equals("����")){
    		child.setBackgroundResource(R.drawable.a2);
    	}
    	else if(vehicle.getName().equals("����")){
    		child.setBackgroundResource(R.drawable.sang);
    	}
    	else if(vehicle.getName().equals("����")){
    		child.setBackgroundResource(R.drawable.cho);
    	}
    	else if(vehicle.getName().equals("���")){
    		child.setBackgroundResource(R.drawable.woo);
    	}
    	else if(vehicle.getName().equals("����")){
    		child.setBackgroundResource(R.drawable.a3);
    	}
    	else{
    		child.setBackgroundResource(R.drawable.a1);
    	}
    	
        TextView tv = (TextView) convertView.findViewById(R.id.tvChild);
        tv.setText("   " + vehicle.getName());
        
        
        
        // Depending upon the child type, set the imageTextView01
        return convertView;
    }


    public int getChildrenCount(int groupPosition) {
        return children.get(groupPosition).size();
    }


    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }


    public int getGroupCount() {
        return groups.size();
    }
    

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // Return a group view. You can load your custom layout here.

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
            ViewGroup parent) {
        String vehicle = (String) getGroup(groupPosition);
        
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_layout, null);
        }
        
        ImageView group = (ImageView)convertView.findViewById(R.id.groupimage);
    	if(vehicle.equals("����������а�")){
    		group.setBackgroundResource(R.drawable.a1);
        }
    	else if(vehicle.equals("��ǻ�Ͱ��а�")){
    		group.setBackgroundResource(R.drawable.a2);
    	}
    	else if(vehicle.equals("�����а�")){
    		group.setBackgroundResource(R.drawable.sang);
    	}
    	else if(vehicle.equals("����濵���а�")){
    		group.setBackgroundResource(R.drawable.cho);
    	}
    	else if(vehicle.equals("���а�")){
    		group.setBackgroundResource(R.drawable.woo);
    	}
    	else if(vehicle.equals("ȭ�а�")){
    		group.setBackgroundResource(R.drawable.a3);
    	}
    	else if(vehicle.equals("�����а�")){
    		group.setBackgroundResource(R.drawable.a3);
    	}
    	else if(vehicle.equals("������а�")){
    		group.setBackgroundResource(R.drawable.a3);
    	}
    	else if(vehicle.equals("ȭ�а��а�")){
    		group.setBackgroundResource(R.drawable.a3);
    	}
    	else if(vehicle.equals("â��IT���հ��а�")){
    		group.setBackgroundResource(R.drawable.a3);
    	}
    	else{
    		group.setBackgroundResource(R.drawable.a1);
    	}
    	
        TextView tv = (TextView) convertView.findViewById(R.id.tvGroup);
        tv.setText(vehicle);
        return convertView;
    }


    public boolean hasStableIds() {
        return true;
    }


    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }


}
