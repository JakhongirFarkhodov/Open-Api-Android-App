package com.example.openapiandroidapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.openapiandroidapp.R
import com.example.openapiandroidapp.ui.BaseActivity
import dagger.android.support.DaggerAppCompatActivity

class AuthActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}