package com.example.sqrcomplexnumbers

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
const val EXTRA_MESSAGE = "com.example.SqrComplexNumbers.MESSAGE"
class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val funs : Array<String> = arrayOf("Сложение","Вычитание","Умножение","Деление","Возведение в степень","Извлечение из корня")
        val lvMain:ListView = findViewById(R.id.lvMain)
        val adapterArray:ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, funs)
        lvMain.adapter = adapterArray

        lvMain.setOnItemClickListener{parent, view, position, id ->
            when(position) {
                0 -> intent = Intent(this, AdditionActivity::class.java)
                1 -> intent = Intent(this, SubtractionActivity::class.java)
                2 -> intent = Intent(this, MultiplyActivity::class.java)
                3 -> intent = Intent(this, DivideActivity::class.java)
                4 -> intent = Intent(this, SqrActivity::class.java)
                5 -> intent = Intent(this, SqrtActivity::class.java)

            }
            startActivity(intent)
        }
    }
}