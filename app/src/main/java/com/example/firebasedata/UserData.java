package com.example.firebasedata;

import java.util.HashMap;

public class UserData {
    private String phoneNumber;
    private HashMap<String, String> documents;
    private String kyc;
    private String username;

    public UserData(String phoneNumber,HashMap<String,String> documents, String kyc, String username) {
        this.phoneNumber = phoneNumber;
        this.documents = documents;
        this.kyc = kyc;
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public HashMap<String, String> getDocuments() {
        return documents;
    }

    public void setDocuments(HashMap<String, String> documents) {
        this.documents = documents;
    }

    public String getKyc() {
        return kyc;
    }

    public void setKyc(String kyc) {
        this.kyc = kyc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
