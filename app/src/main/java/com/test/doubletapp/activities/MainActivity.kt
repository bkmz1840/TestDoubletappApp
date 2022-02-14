package com.test.doubletapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.test.doubletapp.R
import com.test.doubletapp.supportClasses.Settings

class MainActivity : AppCompatActivity() {
    private lateinit var textCountChangeConfView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textCountChangeConfView = findViewById(R.id.count_change_conf)
        var countChangeConf = "0"
        if (savedInstanceState != null)
            countChangeConf = savedInstanceState.getString(Settings.KEY_COUNT_CHANGE_CONF) ?: "0"
        textCountChangeConfView.text = countChangeConf

        val btnToSecondActivity: Button = findViewById(R.id.btn_go_to_second)
        btnToSecondActivity.setOnClickListener {
            val switchToSecondActivity = Intent(this, SecondActivity::class.java)
            switchToSecondActivity.putExtra(Settings.KEY_COUNT_CHANGE_CONF, countChangeConf)
            startActivity(switchToSecondActivity)
        }

        Log.i(Settings.LOG_TAG, "First activity: Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Settings.LOG_TAG, "First activity: Started")
    }

    override fun onResume() {
        super.onResume()
        Log.i(Settings.LOG_TAG, "First activity: Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(Settings.LOG_TAG, "First activity: Paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(Settings.LOG_TAG, "First activity: Restarted")
    }

    override fun onStop() {
        super.onStop()
        Log.i(Settings.LOG_TAG, "First activity: Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(Settings.LOG_TAG, "First activity: Destroyed")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val curCountChangeConf = textCountChangeConfView.text.toString().toInt() + 1
        outState.putString(Settings.KEY_COUNT_CHANGE_CONF, curCountChangeConf.toString())
        super.onSaveInstanceState(outState)
    }
}