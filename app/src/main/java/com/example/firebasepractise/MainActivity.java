package com.example.firebasepractise;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();
        myRef.child("child_1").child("pinku").setValue("9820682522");

        //Creating and initializing User class object
        User user = new User("user1234", "abc", "xyz", "First", "January", "2001");

        //Getting Instance of Firebase realtime database
       // FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();

        //Getting Reference to a User node, (it will be created if not already there)
        DatabaseReference userNode = database.getReference();

        //Writing the User class object to that reference
        userNode.child("user").setValue(user);


        //Reading database object from firebase realtime database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    //Getting User object from dataSnapshot
                    User user = data.getValue(User.class);
                    String username = user.getUserName();
                    String firstName = user.getFirstName();
                    String lastName = user.getLastName();
//                    Date dob = user.getDob();
//                    String day = dob.getDay();
//                    String month = dob.getMonth();
//                    String year = dob.getYear();

                    Log.i("TAG", "onDataChange: " + username);
                    Toast.makeText(MainActivity.this, "onDataChange: " + username, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Log.i("TAG", "onCancelled: Error: " + databaseError.getMessage());

            }
        });

        }
    }
