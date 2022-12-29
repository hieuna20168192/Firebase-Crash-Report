package com.example.firebasecrashreport

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import coil.load
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.ktx.setCustomKeys
import com.google.firebase.ktx.Firebase

const val defaultUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgqlF93eRI3eINaNzlIuwqjeC9VR1pk4YM4gc4JuxQmwtZYGxFfIjJxERkwAY2NbimkQAHCtWD2zMnG_MeffHpKtxOQGlSSdW60b24jDFY6EGKfjjaxt3GBXEBxWDOpuH--OpB-mPTZrWdLUEUh5tLHWpHQXFcY6RkSUzizPOpUlB0chhtyTk_bvsbhSA/s320/Flower%204_3__jamie%20cardoso%203D.jpg"

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var crashlytics: FirebaseCrashlytics


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics

        crashlytics = Firebase.crashlytics

        crashlytics.setCustomKeys {
            key("current_level", 3)
            key("last_UI_action", "logged_in")
        }

        findViewById<Button>(R.id.btnCrash).setOnClickListener {
            Firebase.crashlytics.setUserId("user123456789")
            Firebase.crashlytics.log("R.id.btnCrash onClick")
            throw IllegalStateException("Woo rose")
        }

        findViewById<ImageView>(R.id.imgAvatar).load(defaultUrl)
    }
}