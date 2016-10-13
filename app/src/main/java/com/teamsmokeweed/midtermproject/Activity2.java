package com.teamsmokeweed.midtermproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jongzazaal on 15/9/2559.
 */

public class Activity2 extends Activity {
    TextView textView4;
    EditText result;
    Spinner spinner;
    String[] countryNames={"India","China","Australia"};
    int flags[] = {R.drawable.ic_favorite_border_black_48dp,R.drawable.ic_favorite_border_black_48dp,R.drawable.ic_favorite_border_black_48dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textView4 = (TextView)findViewById(R.id.textView4);
        result = (EditText)findViewById(R.id.ResultSample);
        Intent i = getIntent();
        String a = i.getStringExtra("sendTextStr");
        textView4.setText("Sent: "+a);

        String[] items = {"bat", "cat", "rat"};
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("COEN268", "Position selected: " + position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("COEN268", "Nothing selected");
            }
        });
        //spinner.set

        Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //Performing action onItemSelected and onNothing selected
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
                Toast.makeText(getApplicationContext(), countryNames[position], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }

        });

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,countryNames);
        spin.setAdapter(customAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        //spinner.getId();
        Log.d("ccccccccccccccccccccc", spinner.getSelectedItem().toString() + " --- "+spinner.getSelectedItemPosition());
        returnIntent.putExtra("resultTextStr", result.getText().toString());
        setResult(RESULT_OK,returnIntent);
        finish();
    }

    Toast m_currentToast;
    void showToast(String text)
    {
        if(m_currentToast == null)
        {
            m_currentToast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        }

        m_currentToast.setText(text);
        m_currentToast.setDuration(Toast.LENGTH_LONG);
        m_currentToast.show();
    }
}
