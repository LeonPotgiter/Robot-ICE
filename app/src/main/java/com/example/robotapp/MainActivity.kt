package com.example.robotapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {
    private lateinit var txtMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.4.1/") // replace with your actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        txtMessage = findViewById(R.id.txtMessage)
        val apiService = retrofit.create(RobotCommands::class.java)
        val btnForward = findViewById<Button>(R.id.btnForward)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnSmile = findViewById<Button>(R.id.btnSmile)
        val btnSad = findViewById<Button>(R.id.btnSad)
        val btnLeft = findViewById<Button>(R.id.btnLeft)
        val btnRight = findViewById<Button>(R.id.btnRight)
        val btnShine = findViewById<Button>(R.id.btnShine)
        val btnSing = findViewById<Button>(R.id.btnSing)

        btnForward.setOnClickListener {
            apiService.robotMove().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Move should work"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()
                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnBack.setOnClickListener {
            apiService.robotBack().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Moving Backwards"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()
                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnStop.setOnClickListener {
            apiService.robotStop().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Robot stopped"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnSad.setOnClickListener {
            apiService.robotSad().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Robot sad"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnSmile.setOnClickListener {
            apiService.robotHappy().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Robot is smiling"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnLeft.setOnClickListener {
            apiService.robotLeft().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Turning left"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnRight.setOnClickListener {
            apiService.robotRight().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Turning right"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnShine.setOnClickListener {
            apiService.robotShine().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Robot is shining"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }

        btnSing.setOnClickListener {
            apiService.robotSing().enqueue(object:Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        txtMessage.text ="Robot is singing"
                    }else{
                        txtMessage.text =  "API call failed with response: " + response.errorBody()                    }
                }override fun onFailure(call: Call<Void>, t: Throwable) {

                    txtMessage.text = "Exception: " + t.message
                }
            })
        }



    }
}

interface RobotCommands{
    @GET("forward")
    fun robotMove(): Call<Void>

    @GET("backward")
    fun robotBack(): Call<Void>

    @GET("Stop")
    fun robotStop(): Call<Void>

    @GET("api/Sad")
    fun robotSad(): Call<Void>

    @GET("api/Happy")
    fun robotHappy(): Call<Void>

    @GET("api/Left")
    fun robotLeft(): Call<Void>

    @GET("api/Right")
    fun robotRight(): Call<Void>

    @GET("api/Shine")
    fun robotShine(): Call<Void>

    @GET("api/Sing")
    fun robotSing(): Call<Void>
}