package com.example.custom_listview;
import java.util.ArrayList;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends Activity
{
    ListView list;
    CustomAdapter customadapter;
    public MainActivity cActivity = null;
    public ArrayList < ListModel > CustomArrlist = new ArrayList < ListModel > ();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cActivity = this;
        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setDataList();
        Resources res = getResources();
        list = (ListView) findViewById(R.id.list); // List defined in XML ( See Below )
        /**************** Create Custom Adapter *********/
        customadapter = new CustomAdapter(cActivity, CustomArrlist, res);
        list.setAdapter(customadapter);
    }
    /****** Function to set data in ArrayList *************/
    public void setDataList()
    {
        for (int i = 0; i < 11; i++)
        {
            final ListModel listModel = new ListModel();
            /******* First take data in model object ******/
            listModel.setCompanyName("Company " + i);
            listModel.setImage("image" + i);
            listModel.setUrl("http:\\www." + i + ".com");
            /******** Take Model Object in ArrayList **********/
            CustomArrlist.add(listModel);
        }
    }
    /***************** This function used by adapter ****************/
    public void onItemClick(int mPosition)
    {
        ListModel tempValues = (ListModel) CustomArrlist.get(mPosition); // SHOW ALERT
        Toast.makeText(cActivity, "" + tempValues.getCompanyName() + " Image:" + tempValues.getImage() + " Url:" + tempValues.getUrl(), Toast.LENGTH_LONG).show();
    }
}