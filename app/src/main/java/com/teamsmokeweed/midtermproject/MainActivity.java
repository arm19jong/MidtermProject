package com.teamsmokeweed.midtermproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2, sendText, resultText;
    TextView textview1, textview2, checktext1, checktext2, checktext3, textview3;
    Button button1, activity_2;
    CheckBox checkBox1,checkBox2,checkBox3;
    ToggleButton toggleButton1;
    Switch switch1;
    SeekBar seekbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get
        editText1 = (EditText)findViewById(R.id.editText1);
        textview1 = (TextView)findViewById(R.id.textView1);
        editText2 = (EditText)findViewById(R.id.editText2);
        textview2 = (TextView)findViewById(R.id.textView2);
        button1 = (Button)findViewById(R.id.button1);
        checkBox1 = (CheckBox)findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkbox3);
        checktext1 = (TextView)findViewById(R.id.checktext1);
        checktext2 = (TextView)findViewById(R.id.checktext2);
        checktext3 = (TextView)findViewById(R.id.checktext3);
        toggleButton1 = (ToggleButton)findViewById(R.id.ToggleButton1);
        switch1 = (Switch)findViewById(R.id.Switch1);
        seekbar1 = (SeekBar)findViewById(R.id.seekbar1);
        textview3 = (TextView)findViewById(R.id.textView3);
        activity_2 = (Button)findViewById(R.id.ToActivity2);
        sendText = (EditText)findViewById(R.id.SendText);
        resultText = (EditText)findViewById(R.id.ResultText);


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                showToast("beforeTextChanged");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //showToast("onTextChanged");
                textview1.setText(editText1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                showToast(editText1.getText().toString());
            }
        });


        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textview2.setText(editText2.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
                showToast(editText2.getText().toString());
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editText1.setText("");
                editText2.setText("");
            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast("s1");
                CheckCheckbox();
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast("s2");
                CheckCheckbox();
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast("s3");
                CheckCheckbox();
            }
        });

        toggleButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch1.setChecked(toggleButton1.isChecked());
            }
        });
        switch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toggleButton1.setChecked(switch1.isChecked());
            }
        });

        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                textview3.setText("Covered: " + progress + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textview3.setText("Covered: " + progress + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }

        });

        activity_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                i.putExtra("sendTextStr",sendText.getText().toString() );
                startActivityForResult(i, 1);

            }
        });

    }

    void CheckCheckbox(){
        if(checkBox1.isChecked()){
            checktext1.setTextColor(Color.parseColor("#00ff00"));
        }
        else{
            checktext1.setTextColor(Color.parseColor("#ff0000"));
        }
        if(checkBox2.isChecked()){
            checktext2.setTextColor(Color.parseColor("#00ff00"));
        }
        else{
            checktext2.setTextColor(Color.parseColor("#ff0000"));
        }
        if(checkBox3.isChecked()){
            checktext3.setTextColor(Color.parseColor("#00ff00"));
        }
        else{
            checktext3.setTextColor(Color.parseColor("#ff0000"));
        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == RESULT_OK){
            resultText.setText(data.getStringExtra("resultTextStr"));
        }

    }
}
