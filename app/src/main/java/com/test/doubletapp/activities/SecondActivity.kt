package com.test.doubletapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.test.doubletapp.R
import com.test.doubletapp.supportClasses.Settings

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var countChangeConf = "0"
        if (intent.extras?.containsKey(Settings.KEY_COUNT_CHANGE_CONF) == true)
            countChangeConf = intent.extras?.getString(Settings.KEY_COUNT_CHANGE_CONF) ?: "0"
        val countChangeConfInt = countChangeConf.toInt()

        val countChangeConfSquareView: TextView = findViewById(R.id.count_change_conf_square)
        countChangeConfSquareView.text = (countChangeConfInt * countChangeConfInt).toString()

        val btnBackToFirstActivity: Button = findViewById(R.id.btn_back_to_first)
        btnBackToFirstActivity.setOnClickListener { finish() }

        Log.i(Settings.LOG_TAG, "Second activity: Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Settings.LOG_TAG, "Second activity: Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Settings.LOG_TAG, "Second activity: Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Settings.LOG_TAG, "Second activity: Paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(Settings.LOG_TAG, "Second activity: Restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Settings.LOG_TAG, "Second activity: Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Settings.LOG_TAG, "Second activity: Destroyed")
    }
}