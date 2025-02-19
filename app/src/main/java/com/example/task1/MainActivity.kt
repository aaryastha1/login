package com.example.task1


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task1.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences


    var username:String?=null
    var password:String?=null
    var Remember: Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(loginBinding.root)


        loginBinding.Register.setOnClickListener {
            Log.d("Message","On resume call")
            sharedPreferences=getSharedPreferences("userdata", MODE_PRIVATE)
            username=sharedPreferences.getString("username","")
            password=sharedPreferences.getString("password","")
//

            if(username.toString() == loginBinding.password.text.toString()
                && password.toString() == loginBinding.password.text.toString()){
                val intent=Intent(this@LoginActivity,
                    DashboardActivity::class.java)


                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Invalid ",Toast.LENGTH_LONG).show()

            }




        }


        loginBinding.Email.setOnClickListener {

            sharedPreferences=getSharedPreferences("userdata", MODE_PRIVATE)
            username=loginBinding.Email.text.toString()
            password=loginBinding.password.text.toString()

            var editor =sharedPreferences.edit()
            editor.putString("username",username)
            editor.putString("password",password)
            editor.putBoolean("Remember",true
            )

            editor.apply()

            Toast.makeText(applicationContext,"Data saved successfully", Toast.LENGTH_LONG).show()


        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Remember)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPause() {
        Log.d("Message","On pause call")
//        sharedPreferences=getSharedPreferences("username", MODE_PRIVATE)
//        username=loginBinding.Email.text.toString()
//        password=loginBinding.password.toString()
//
//        var editor =sharedPreferences.edit()
//        editor.putString("username",username)
//        editor.putString("password",password)
//
//        Toast.makeText(applicationContext,"Data saved", Toast.LENGTH_LONG).show()
//
//


        super.onPause()
    }

    override fun onResume() {

        super.onResume()
    }

}


