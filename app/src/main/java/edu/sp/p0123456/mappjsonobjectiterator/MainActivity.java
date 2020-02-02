package edu.sp.p0123456.mappjsonobjectiterator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";
    // sample json string to demo
    String jsonStr = "{'id01':{'name':'ABC', 'price':123}, " +
            "'id02':{'name':'XYZ', 'price':987}," +
            "'id03':{'name':'DEF', 'price':555}" +
            "}";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get UI to display text
        tv = findViewById(R.id.mytext);

        // parse the sample json string
        parseJson(jsonStr);
    }

    void parseJson(String s){
        try {
            JSONObject j = new JSONObject(s);
            Log.d(TAG, j.toString());
            // iterate using keys
            Iterator<String> iter = j.keys();
            String txt = "";
            while(iter.hasNext()){
                String key = iter.next();
                JSONObject obj = j.getJSONObject(key);
                //Log.d(TAG, obj.toString());
                txt = txt + key  + " - " +obj.getString("name") +
                        " @ $" + obj.getInt("price") +"\n";
            }
            // display result in UI
            tv.setText(txt);
        }
        catch(Exception ex){
            Log.e(TAG, ex.getMessage());
        }
    }
}
