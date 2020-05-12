package com.ggonzales.firebasedemo

import android.content.Intent
import com.google.firebase.analytics.FirebaseAnalytics
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

private var mFirebaseAnalytics : FirebaseAnalytics? = null
private var mAuth : FirebaseAuth? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variable for Analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        //Variable for Authenticator
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
        if(currentUser!= null){
            val intent = Intent(applicationContext, ControlActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginFunction(view: View) {
        val email = emailEditTxt.text.toString()
        val passw = passwordEditTxt.text.toString()
        loginToFirebase(email, passw)
    }

    fun loginToFirebase(email : String, passw : String ){
        mAuth!!.createUserWithEmailAndPassword(email, passw)
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
                    val userID = mAuth!!.currentUser!!.uid
                    Log.d("User Info: ", userID)
                }
                else  {
                    Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
