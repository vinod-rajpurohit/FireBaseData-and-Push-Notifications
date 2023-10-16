package com.example.firebasedata;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class DocumentListAdapter extends BaseAdapter {
    private Context context;
    private List<String> documentNames;
    private Map<String, String> documents;

    public DocumentListAdapter(Context context, List<String> documentNames, Map<String, String> documents) {
        this.context = context;
        this.documentNames = documentNames;
        this.documents = documents;
    }


    @Override
    public int getCount() {
        return documentNames.size();
    }

    @Override
    public String getItem(int position) {
        String documentName = documentNames.get(position);
        return documents.get(documentName);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new TextView(context);
        }

        String documentName = documentNames.get(position);
        String documentValue = getItem(position);

        ((TextView) convertView).setText(documentName + ": " + documentValue);

        return convertView;
    }
}