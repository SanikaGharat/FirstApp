package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.StringRequestListener
import com.example.firstapp.MyAdapter

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goto_profile_button = findViewById<Button>(R.id.main_profile_button)
        goto_profile_button.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
        val textview1= findViewById<TextView>(R.id.textview1)

        AndroidNetworking.initialize((applicationContext))

        AndroidNetworking.get("http://www.kishankpatel.me/")
            .build()
            .getAsString(object : StringRequestListener {

                override fun onResponse(response: String?) {
                    Log.d("MainActivity","Response from server: $response")
                    textview1.text = response

                }

                override fun onError(anError: ANError?) {
                    Log.e("MainActivity","Error: ${anError.toString()}")

                }
            })
        val int = listOf("1")

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        val intent = Intent(this, MainActivity::class.java)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(int)
    }
        //val colorDao = ColorDatabase.getInstance(applicationContext).colorDao()

       // val new_color = Color(hex = "#FFFFFFF", name = "WHITE", _id = 1)
       // launch{}
        //colorDao.insert(new_color)
       // Log.d("MainActivity", colorDao.getAll().toString())
    }




