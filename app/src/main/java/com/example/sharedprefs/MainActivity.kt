package com.example.sharedprefs

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextmessage: EditText
    private lateinit var saveButton:  Button
    private lateinit var textViewMessage: TextView

    private lateinit var myPrefs: SharedPreferences
    private  val PREF_NAME = "myPref" // Name of the file to store the sharedPrefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextmessage = findViewById(R.id.edit_text_message)
        saveButton  = findViewById(R.id.save_button)
        textViewMessage = findViewById(R.id.text_view_message)

        saveButton.setOnClickListener {
            myPrefs = getSharedPreferences(PREF_NAME, 0)
            val editor = myPrefs.edit()

            editor.putString("message", editTextmessage.text.toString())
            editor.commit()
        }

        val prefs = getSharedPreferences(PREF_NAME, 0)
        if (prefs.contains("message")){
            val message = prefs.getString("message", "not found")
            textViewMessage.text = message
        }
    }
}