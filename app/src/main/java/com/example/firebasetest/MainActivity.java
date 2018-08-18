package com.example.firebasetest;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText editTextKey, editTextValue;
    private View button;
    Firebase mFirebase;

    String deviceId = "";
    private TextView textViewReadFromFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get device id.
        deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://fir-test-a5456.firebaseio.com");

        //Listener for change on firebase.
        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.child("key").getValue().toString();
                textViewReadFromFirebase.setText(data);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        button = findViewById(R.id.button);
        textViewReadFromFirebase = findViewById(R.id.textViewReadFromFirebase);

    }
}
