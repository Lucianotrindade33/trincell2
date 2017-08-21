package com.example.lucia.trincell;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by lucia on 28/07/2017.
 */

public class FireBase {

    private static DatabaseReference referenceFireBase;
    private static FirebaseAuth autentication;

    public static DatabaseReference getFirebase() {
        if (referenceFireBase == null) {
            referenceFireBase = FirebaseDatabase.getInstance().getReference();
        }
        return referenceFireBase;
    }

    public static FirebaseAuth getFirebaseAutenticacao() {
        if (autentication == null) {
            autentication = FirebaseAuth.getInstance();
        }
        return  autentication;
    }
}
