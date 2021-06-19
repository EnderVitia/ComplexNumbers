package com.example.sqrcomplexnumbers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.nio.file.attribute.FileAttributeView
import kotlin.math.*
import android.widget.EditText as EditText
import android.widget.Button
import android.widget.Toast
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.lang.NumberFormatException

class SqrActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqr)

    }
    var x: Double = 0.0
    var y: Double = 0.0
    var ro: Double = 0.0
    var argZ: Double = 0.0
    var degree: Double = 0.0

    @SuppressLint("SetTextI18n")
    fun calculate(view: View){
        try {
            var stringa: String = findViewById<EditText>(R.id.editCoordX).text.toString()
            x = parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editCoordY).text.toString()
            y = parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editDegree).text.toString()
            degree = parseDouble(stringa)
            ro = sqrt(x.pow(2.0) + y.pow(2.0))
            findViewById<TextView>(R.id.textRo).text = "ρ = $ro"
            argZ = if ((x.equals(0)) and (!y.equals(0))) {
                if (y > 0) Math.PI / 2 else -(Math.PI / 2)
            } else if ((!x.equals(0)) and (y.equals(0))) {
                Math.PI
            } else {
                atan2(y, x)
            }
            findViewById<TextView>(R.id.textArgZ).text = "ArgZ = $argZ"
            when(argZ){
                PI/4 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/4) + isin(π/4))"
                PI/2 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/2) + isin(π/2))"
                PI/3 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/3) + isin(π/3))"
                PI/6 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/6) + isin(π/6))"
                PI -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π) + isin(π))"
                else -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos($argZ) + isin($argZ))"
            }
            findViewById<TextView>(R.id.textDegreeZ).text = "Z^$degree = ${(ro.pow(degree) * cos(degree * argZ)).roundToInt()} + (${(ro.pow(degree) * sin(degree * argZ)).roundToInt()})i"
        }
        catch (e: NumberFormatException){
            findViewById<TextView>(R.id.textRo).text = "Всё ли введено?"
            findViewById<TextView>(R.id.textArgZ).text = ""
            findViewById<TextView>(R.id.textZ).text = ""
            findViewById<TextView>(R.id.textDegreeZ).text = ""
        }

    }

}