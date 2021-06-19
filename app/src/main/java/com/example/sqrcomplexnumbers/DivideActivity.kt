package com.example.sqrcomplexnumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import kotlin.math.pow

class DivideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divide)
    }
    var x1: Double = 0.0
    var y1: Double = 0.0
    var x2: Double = 0.0
    var y2: Double = 0.0
    var under: Double = 0.0
    var x: Double = 0.0
    var y: Double = 0.0
    fun calculate(view: View){
        try {
            var stringa: String = findViewById<EditText>(R.id.editX1).text.toString()
            x1 = java.lang.Double.parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editY1).text.toString()
            y1 = java.lang.Double.parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editX2).text.toString()
            x2 = java.lang.Double.parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editY2).text.toString()
            y2 = java.lang.Double.parseDouble(stringa)
            x = x1 * x2 + y1 * -y2
            y = x1 * -y2 + y1 * x2
            under = x2.pow(2) + y2.pow(2)
            x /= under
            y /= under
            if(y >=0){
                findViewById<TextView>(R.id.textResult).text = "$x + ${y}i"
            }
            else{
                findViewById<TextView>(R.id.textResult).text = "$x - ${-y}i"
            }
        }
        catch (e: NumberFormatException){
            findViewById<TextView>(R.id.textResult).text = "Всё ли введено?"
        }
    }
}