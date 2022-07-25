package com.example.custom_listview;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomAdapter extends BaseAdapter implements OnClickListener
{
    /*********** Declare Used Variables *********/
    private Activity activity;
    private ArrayList arrayList;
    private static LayoutInflater inflater = null;
    public Resources resources;
    ListModel tempValues = null;
    int i = 0;
    /************* CustomAdapter Constructor *****************/
    public CustomAdapter(Activity activity, ArrayList arrayList, Resources resLocal)
    {
        /********** Take ed values **********/
        this.activity = activity;
        this.arrayList = arrayList;
        resources = resLocal;
        /*********** Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    /******** What is the size of ed Arraylist Size ************/
    public int getCount()
    {
        if (arrayList.size() <= 0)
            return 1;
        return arrayList.size();
    }
    public Object getItem(int position)
    {
        return position;
    }
    public long getItemId(int position)
    {
        return position;
    }
    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class Viewholder
    {
        public TextView text;
        public TextView text1;
        public TextView textWide;
        public ImageView image;
    }
    //****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertview, ViewGroup viewGroup)
    {
        View view = convertview;
        Viewholder holder;
        if (convertview == null)
        {
            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            view = inflater.inflate(R.layout.customadapter, null);
            /****** View Holder Object to contain tabitem.xml file elements ******/
            holder = new Viewholder();
            holder.text = (TextView) view.findViewById(R.id.text);
            holder.text1 = (TextView) view.findViewById(R.id.text1);
            holder.image = (ImageView) view.findViewById(R.id.image);
            /************ Set holder with LayoutInflater ************/
            view.setTag(holder);
        }
        else
            holder = (Viewholder) view.getTag();
        if (arrayList.size() <= 0)
        {
            holder.text.setText("No Data");
        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues = null;
            tempValues = (ListModel) arrayList.get(position);
            /************ Set Model values in Holder elements ***********/
            holder.text.setText(tempValues.getCompanyName());
            holder.text1.setText(tempValues.getUrl());
            holder.image.setImageResource(
                    resources.getIdentifier(
                            "com.customlistview:drawable/" + tempValues.getImage(), null, null));
            /******** Set Item Click Listner for LayoutInflater for each row *******/
            view.setOnClickListener(new OnItemClickListener(position));
        }
        return view;
    }
    @Override
    public void onClick(View v)
    {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }
    /********* Called when Item click in ListView ************/
    private class OnItemClickListener implements OnClickListener
    {
        private int myPosition;
        OnItemClickListener(int position)
        {
            myPosition = position;
        }
        @Override
        public void onClick(View arg0)
        {
            MainActivity sct = (MainActivity) activity;
            /**** Call onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
            sct.onItemClick(myPosition);
        }
    }
}