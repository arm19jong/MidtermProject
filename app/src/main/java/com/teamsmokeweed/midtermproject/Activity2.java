package com.teamsmokeweed.midtermproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
