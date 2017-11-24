package iak.example.alikhsan778.recyclerviewcontact;

import java.util.ArrayList;

/**
 * Created by ASUS on 11/12/2017.
 */

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String mName, boolean mOnline) {
        this.mName = mName;
        this.mOnline = mOnline;
    }

    public String getmName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (int i = 1; i <= numContacts; i++) {
            int updateContacId = lastContactId++ + 1;
            contacts.add(new Contact("Person " + updateContacId,i<=numContacts/5));
        }
        return contacts;
    }

}
