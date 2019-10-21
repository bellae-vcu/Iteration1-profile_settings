package com.example.iteration1_profile_settings;

import android.os.Bundle;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private final int profileSettings_REQUEST = 011;

    private String userName = "";
    private String userPass = "";
    private String userEmail = "";
    Button showMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showMenu = (Button) findViewById(R.id.dropdown_homepage);
        showMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), showMenu);
                dropDownMenu.getMenuInflater().inflate(R.menu.dropdown, dropDownMenu.getMenu());

                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getApplicationContext(), "You have clicked " + menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                dropDownMenu.show();
            }
        });

    }

    public void clickProfile(View view) {
        Intent intent = new Intent(this, profileSet_Activity.class);
        startActivityForResult(intent, profileSettings_REQUEST);
    }


    public void showText(String userName, String userEmail, String userPass)
    {
        TextView profileName = findViewById(R.id.profileName);
        TextView profileEmail = findViewById(R.id.profileEmail);
        TextView profilePass = findViewById(R.id.profilePass);
        profileName.setText("Username: " + userName);
        profileEmail.setText("Email: " + userEmail);
        profilePass.setText("Password: " + userPass);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == profileSettings_REQUEST) {
            if(resultCode == RESULT_OK) {
                userName = data.getExtras().getString("Name");
                userEmail = data.getExtras().getString("Email");
                userPass = data.getExtras().getString("Pass");
                showText(userName, userEmail, userPass);
            }
        }
    }
}




