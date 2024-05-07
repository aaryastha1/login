package com.example.task1



import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.adapter.RecyclerViewAdapter

class DashboardActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var nameList = ArrayList<String>()
    var desriptionList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        nameList.add("Apple")
        nameList.add("Mango")
        desriptionList.add("This is apple")
        desriptionList.add("This is mango")

        var adapter = RecyclerViewAdapter(nameList,desriptionList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.checkBoxOne)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

