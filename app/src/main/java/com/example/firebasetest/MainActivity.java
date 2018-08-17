package com.example.firebasetest;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText editTextKey, editTextValue;
    private View button;
    Firebase mFirebase;

    String deviceId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get device id.
        deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://fir-test-a5456.firebaseio.com/Users/"+deviceId);

        editTextKey = findViewById(R.id.editTextKey);
        editTextValue = findViewById(R.id.editTextValue);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase childFireBase = mFirebase.child(editTextKey.getText().toString());
                childFireBase.setValue(editTextValue.getText().toString());
            }
        });
    }
}
