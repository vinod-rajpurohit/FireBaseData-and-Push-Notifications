package com.example.firebasedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.textclassifier.ConversationActions;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class PushNotifications extends AppCompatActivity {
    String deviceToken = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notifications);


        Task<String> task = FirebaseMessaging.getInstance().getToken();
        task.addOnSuccessListener(new OnSuccessListener<String>() {
            @Override
            public void onSuccess(String result) {
                deviceToken = result;
            }
        });


    }
}