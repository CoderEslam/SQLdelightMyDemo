package com.doubleclick.sqldelightmydemo.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.doubleclick.sqldelightmydemo.Greeting
import com.doubleclick.sqldelightmydemo.database.JobQueries
import com.doubleclick.sqldelightmydemo.database.Name
import com.doubleclick.sqldelightmydemo.database.NameQueries
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.stream.Collectors.toList

class MainActivity : AppCompatActivity() {

    private lateinit var name: NameQueries
    private lateinit var job: JobQueries
    private val TAG = "MainActivity"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.click).setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
//        name = MyDB(createDriver()).nameQueries
//        job = MyDB(createDriver()).jobQueries


//        name.insertPasoOneById(null, "eslam", "12")
//        name.insertPasoOneById(null, "ghazy", "25")
//        name.insertPasoOneById(null, "ali", "36")
//        name.insertPasoOneById(null, "ahmed", "85")
//        name.insertPasoOneById(null, "mona", "96")
//        name.insertPasoOneById(null, "omnia", "14")
//        name.insertPasoOneById(null, "bag", "56")

//        job.insertPasoOneById(null, "android", "alex")
//        job.insertPasoOneById(null, "h", "sd")
//        job.insertPasoOneById(null, "f", "fef")
//        job.insertPasoOneById(null, "u", "ef")
//        job.insertPasoOneById(null, "o", "rg")
//        job.insertPasoOneById(null, "p", "rh")

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}


