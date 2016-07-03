package com.example.sergey.serializationexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person = new Person();
        person.setName("Yoav");
        person.setAddress("Texas Dallas (Gaming capitol of the world)");
        person.setNumber("134679");

        //save the object
        saveObject(person);

        // Get the Object
        Person person1 = (Person)loadSerializedObject(new File("/sdcard/save_object.bin")); //get the serialized object from the sdcard and caste it into the Person class.
        System.out.println("Name : " + person1.getName());
    }

    public void saveObject(Person p){
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/sdcard/save_object.bin"))); //Select where you wish to save the file...
            oos.writeObject(p); // write the class as an 'object'
            oos.flush(); // flush the stream to insure all of the information was written to 'save_object.bin'
            oos.close();// close the stream
        }
        catch(Exception ex)
        {
            Log.v("Serialization E: ",ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Object loadSerializedObject(File f)
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            Object o = ois.readObject();
            return o;
        }
        catch(Exception ex)
        {
            Log.v("Serialization Error : ",ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
