package com.example.iteration1_profile_settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class newProfile extends AppCompatActivity {


    protected String userName = "";
    protected String userEmail = "";
    protected String userPass ="";
    protected String userConfirmed = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_profile);
    }

    public void clickBack(View view) {
        Intent intent = new Intent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private String getName()
    {
        EditText editText = findViewById(R.id.edittextName);
        return String.valueOf(editText.getText());
    }

    private String getEmail()
    {
        EditText editText = findViewById(R.id.edittextEmail);
        return String.valueOf(editText.getText());
    }


    private String getPass()
    {
        EditText editText = findViewById(R.id.edittextPass);
        return String.valueOf(editText.getText());

    }

    private String getConfirmedPass()
    {
        EditText editText = findViewById(R.id.edittextConfirm);
        return String.valueOf(editText.getText());
    }
    public void clickDone(View view) {
        userName = getName();
        userEmail = getEmail();
        userPass = getPass();
        userConfirmed = getConfirmedPass();

        try{

            if(userName.compareTo("")==0 || userEmail.compareTo("")==0 || userPass.compareTo("")==0 || userConfirmed.compareTo("")==0) {
                throw new Exception("Input field(s) either contain illegal or no data.");
            }
            if ((!userEmail.contains(String.valueOf('@'))) && ((!userEmail.contains(".com")) || (!userEmail.contains(".org")) || (!userEmail.contains(".net")))) {
                throw new Exception("Email format invalid!");
            }
            if(userPass.compareTo(userConfirmed) != 0) {
                throw new Exception("The passwords do not match!");
            }


            Intent intent = new Intent();
            intent.putExtra("name", userName);
            intent.putExtra("pass", userPass);
            intent.putExtra("email", userEmail);
            setResult(RESULT_OK, intent);
            finish();
        }catch(Exception e) {
            Toast t = Toast.makeText(this, e.toString(), Toast.LENGTH_LONG);
            t.show();
        }
    }
}
