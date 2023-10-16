package com.example.firebasedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Users");

    ListView listView;
    String kyc,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.list_view);

        List<UserData> userDataList = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userDataList.clear();

                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    String phoneNumber = childSnapshot.getKey();
                    String kyc = childSnapshot.child("KYC").getValue(String.class);
                    String username = childSnapshot.child("USERNAME").getValue(String.class);

                    HashMap<String, String> documents = new HashMap<>();
                    for (DataSnapshot documentSnapshot : childSnapshot.child("DOCUMENTS").getChildren()) {
                        String documentName = documentSnapshot.getKey();
                        String documentValue = documentSnapshot.getValue(String.class);
                        documents.put(documentName, documentValue);
                    }

                    UserData userData = new UserData(phoneNumber, documents, kyc, username);
                    userDataList.add(userData);
                }

                UserListAdapter adapter = new UserListAdapter(MainActivity.this, R.layout.list_item_layout, userDataList);
                listView.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}