package QnA.android;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContentAdapter extends ArrayAdapter<Content> {
	
	private Context mContext;
	private int mResource;
	private LayoutInflater mInflater;
	private ArrayList<Content> items;

	public ContentAdapter(Context context, int textViewResourceId,
			ArrayList<Content> items) {
		super(context, textViewResourceId, items);
		this. mContext = context;
		this.items = items;
		this.mResource = textViewResourceId;
		this.mInflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// TODO Auto-generated constructor stub
	}
	
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = mInflater.inflate(mResource, null);
        }
        Content p = items.get(position);
        if (p != null) {
                TextView nb = (TextView) v.findViewById(R.id.number);
                TextView wt = (TextView) v.findViewById(R.id.writer);
                TextView bk = (TextView) v.findViewById(R.id.book);
                TextView tt = (TextView) v.findViewById(R.id.title);
                if (nb != null){
                	nb.setText(p.getNumber());                            
                }
                if (wt != null){
                	wt.setText(p.getWriter());                            
                }
                if (bk != null){
                	bk.setText(p.getBook());                            
                }
                if (tt != null){
                	tt.setText(p.getTitle());                            
                }
                
        }
        return v;
    }


}
