package com.example.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private View button;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://fir-test-a5456.firebaseio.com");

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Firebase childFireBase = mFirebase.child("key");
                childFireBase.setValue(editText.getText().toString());
            }
        });
    }
}
