package com.example.iteration1_profile_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class editProfile extends AppCompatActivity {
    protected String editPass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }


    private String getPass() {
        EditText editText = findViewById(R.id.edittextPass);
        return String.valueOf(editText.getText());

    }

    public void clickBack(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
    public void clickDone(View view) {
        editPass = getPass();
        try {
            if(editPass.compareTo("")==0) {
                throw new Exception("Input field(s) either contain illegal or no data.");
            }
            Intent intent = new Intent();
            intent.putExtra("pass", editPass);
            setResult(RESULT_OK, intent);
            finish();
        }catch(Exception e) {
            Toast t = Toast.makeText(this, e.toString(), Toast.LENGTH_LONG);
            t.show();
        }
    }
}