package com.ggonzales.firebasedemo

import com.google.firebase.analytics.FirebaseAnalytics
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

private var mFirebaseAnalytics : FirebaseAnalytics? = null
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
    }
}
