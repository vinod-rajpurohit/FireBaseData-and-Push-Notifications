package com.example.firebasedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends ArrayAdapter<UserData> {
    private android.content.Context context;
    private int resource;

    public UserListAdapter(Context context, int resource, List<UserData> userList) {
        super(context, resource, userList);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        UserData user = getItem(position);

        TextView usernameTextView = convertView.findViewById(R.id.usernameTextView);
        TextView ageTextView = convertView.findViewById(R.id.ageTextView);
        ListView documentsListView = convertView.findViewById(R.id.documentsListView);

        usernameTextView.setText("Username: " + user.getUsername());
        ageTextView.setText("Age: " + user.getKyc());

        List<String> documentNames = new ArrayList<>(user.getDocuments().keySet());

        // Use a custom adapter to display the list of documents
        DocumentListAdapter documentAdapter = new DocumentListAdapter(context, documentNames, user.getDocuments());
        documentsListView.setAdapter(documentAdapter);

        return convertView;
    }
}
