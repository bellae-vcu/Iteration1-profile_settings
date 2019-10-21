package com.example.iteration1_profile_settings;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profileSet_Activity extends AppCompatActivity {

    private final int newProfile_REQUEST = 010;
    private final int editProfile_REQUEST = 111;
    private String userName = "";
    private String userPass = "";
    private String userEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_set_);
    }

    public void newProfile(View view) {
        Intent intent = new Intent(this, newProfile.class);
        startActivityForResult(intent, newProfile_REQUEST);
    }


    public void editProfile(View view) {
        Intent intent = new Intent(this, editProfile.class);
        startActivityForResult(intent, editProfile_REQUEST);

    }
    public void clickDone(View view) {
        Intent intent = new Intent();
        intent.putExtra("Name", userName);
        intent.putExtra("Pass", userPass);
        intent.putExtra("Email", userEmail);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Button editButton = findViewById(R.id.buttonEdit);
        Button newButton = findViewById(R.id.newProfile);
        Button doneButton = findViewById(R.id.buttonSubmit);
        if (requestCode == newProfile_REQUEST) {
            if (resultCode == RESULT_OK) {
                userName = data.getExtras().getString("name");
                userPass = data.getExtras().getString("pass");
                userEmail = data.getExtras().getString("email");
                editButton.setVisibility(View.VISIBLE);
                newButton.setVisibility(View.GONE);
                doneButton.setVisibility(View.VISIBLE);
            }
        }
        if(requestCode == editProfile_REQUEST) {
            if(resultCode == RESULT_OK) {
                userPass = data.getExtras().getString("pass");
            }
        }
    }
}
