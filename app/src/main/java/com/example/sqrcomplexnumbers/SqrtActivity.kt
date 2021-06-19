package com.example.sqrcomplexnumbers

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.NumberFormatException
import kotlin.math.*

class SqrtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqrt)
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
            x = java.lang.Double.parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editCoordY).text.toString()
            y = java.lang.Double.parseDouble(stringa)
            stringa = findViewById<EditText>(R.id.editDegree).text.toString()
            degree = java.lang.Double.parseDouble(stringa)
            ro = sqrt(x.pow(2.0) + y.pow(2.0))
            findViewById<TextView>(R.id.textRo).text = "ρ = $ro"
            argZ = if ((x.equals(0)) and (!y.equals(0))) {
                if (y > 0) Math.PI / 2 else -(Math.PI / 2)
            } else if ((!x.equals(0)) and (y.equals(0))) {
                Math.PI
            } else {
                atan2(y, x)
            }
            findViewById<TextView>(R.id.textArgZ).text = "ArgZ = $argZ + 2πk, k∈Z"
            when(argZ){
                PI/4 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/4 + 2πk) + isin(π/4 + 2πk))"
                PI/2 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/2 + 2πk) + isin(π/2 + 2πk))"
                PI/3 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/3 + 2πk) + isin(π/3 + 2πk))"
                PI/6 -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π/6 + 2πk) + isin(π/6 + 2πk))"
                PI -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos(π + 2πk) + isin(π + 2πk))"
                else -> findViewById<TextView>(R.id.textZ).text = "Z = $ro (cos($argZ + 2πk) + isin($argZ + 2πk))"
            }
            var txtViews = arrayOfNulls<TextView>(degree.toInt())
            val zs = findViewById<LinearLayout>(R.id.zs)
            for(k in 0 until degree.toInt()){
                val rowTextView: TextView = TextView(this)
                rowTextView.textSize = 18f
                rowTextView.typeface = Typeface.DEFAULT_BOLD
                rowTextView.text = "k = $k, Z${k+1} = ${(ro.pow(1/degree) * cos((argZ + 2 * PI * k)/degree)).roundToInt()} + ${(ro.pow(1/degree) * sin((argZ + 2 * PI * k)/degree)).roundToInt()}i"
                zs.addView(rowTextView)
                txtViews[k] = rowTextView;
            }
        }
        catch (e: NumberFormatException){
            findViewById<TextView>(R.id.textRo).text = "Всё ли введено?"
            findViewById<TextView>(R.id.textArgZ).text = ""
            findViewById<TextView>(R.id.textZ).text = ""
            findViewById<TextView>(R.id.textDegreeZ).text = ""
        }
    }
}