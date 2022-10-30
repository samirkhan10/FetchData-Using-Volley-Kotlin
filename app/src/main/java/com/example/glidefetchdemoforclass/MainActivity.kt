package com.example.glidefetchdemoforclass

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    val apiUrl = "https://api.github.com/users"
    var userInfoItem = arrayOf<userInfoItem>()
    var userInfor = userInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rec = findViewById<RecyclerView>(R.id.recyclerView)

        val stringRequest = StringRequest(apiUrl, Response.Listener {

            val gsonB = GsonBuilder()
            val gson = gsonB.create()
            userInfoItem=gson.fromJson(it,Array<userInfoItem>::class.java)
            userInfoItem.forEach {
                userInfor.add(it)
            }

            val adaptor  = Adaptor(this,userInfor)
            rec.layoutManager=LinearLayoutManager(this)
            rec.adapter=adaptor

        },Response.ErrorListener {
            Toast.makeText(this@MainActivity, "Error"+it.toString(), Toast.LENGTH_SHORT).show()
        })

        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }
}