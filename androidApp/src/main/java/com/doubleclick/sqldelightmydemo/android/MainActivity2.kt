package com.doubleclick.sqldelightmydemo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.doubleclick.sqldelightmydemo.database.JobQueries
import com.doubleclick.sqldelightmydemo.database.NameQueries

class MainActivity2 : AppCompatActivity() {

    private lateinit var name: NameQueries
    private lateinit var job: JobQueries
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        name = MyDB(createDriver()).nameQueries
        job = MyDB(createDriver()).jobQueries
        job.updateFields("Android ", "alex Eg", 5)

    }
}