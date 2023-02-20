package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvOne).setOnClickListener {
            evaluateExpression("1", clear = true)
        }
        findViewById<TextView>(R.id.tvTwo).setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        findViewById<TextView>(R.id.tvThree).setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        findViewById<TextView>(R.id.tvFour).setOnClickListener {
            evaluateExpression("4", clear = true)
        }
        findViewById<TextView>(R.id.tvFive).setOnClickListener {
            evaluateExpression("5", clear = true)
        }
        findViewById<TextView>(R.id.tvSix).setOnClickListener {
            evaluateExpression("6", clear = true)
        }
        findViewById<TextView>(R.id.tvSeven).setOnClickListener {
            evaluateExpression("7", clear = true)
        }
        findViewById<TextView>(R.id.tvEight).setOnClickListener {
            evaluateExpression("8", clear = true)
        }
        findViewById<TextView>(R.id.tvNine).setOnClickListener {
            evaluateExpression("9", clear = true)
        }
        findViewById<TextView>(R.id.tvZero).setOnClickListener {
            evaluateExpression("0", clear = true)
        }
        findViewById<TextView>(R.id.tvPlus).setOnClickListener {
            evaluateExpression("+", clear = false)
        }
        findViewById<TextView>(R.id.tvMinus).setOnClickListener {
            evaluateExpression("-", clear = false)
        }
        findViewById<TextView>(R.id.tvMul).setOnClickListener {
            evaluateExpression("*", clear = false)
        }
        findViewById<TextView>(R.id.tvDivide).setOnClickListener {
            evaluateExpression("/", clear = false)
        }
        findViewById<TextView>(R.id.tvDot).setOnClickListener {
            evaluateExpression(".", clear = true)
        }
        findViewById<TextView>(R.id.tvClear).setOnClickListener {
            findViewById<TextView>(R.id.tvExpression).text =""
            findViewById<TextView>(R.id.tvResult).text=""
        }
        findViewById<TextView>(R.id.tvEquals).setOnClickListener {

            try  {
                val text = findViewById<TextView>(R.id.tvExpression).text.toString()
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()

                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    findViewById<TextView>(R.id.tvResult).text = longResult.toString()
                } else {
                    findViewById<TextView>(R.id.tvResult).text = result.toString()
                }
            }catch (e:Exception){
                findViewById<TextView>(R.id.tvResult).text = "Error"
                findViewById<TextView>(R.id.tvExpression).text = ""
                Log.d("Exception"," message : " + e.message )
            }
        }
        findViewById<TextView>(R.id.tvClear).setOnClickListener {
            val text = findViewById<TextView>(R.id.tvExpression).text.toString()
            if(text.isNotEmpty())
            {
                findViewById<TextView>(R.id.tvExpression).text = text.drop(1)
            }
            findViewById<TextView>(R.id.tvResult).text = ""
        }




    }

    private fun evaluateExpression(s: String, clear: Boolean) {
        if(findViewById<TextView>(R.id.tvResult).text.isNotEmpty())
        {
            findViewById<TextView>(R.id.tvExpression).text = ""
        }
        if (clear)
        {
            findViewById<TextView>(R.id.tvResult).text = ""
            findViewById<TextView>(R.id.tvExpression).append(s)

        }
        else {
            findViewById<TextView>(R.id.tvExpression).append(findViewById<TextView>(R.id.tvResult).text)
            findViewById<TextView>(R.id.tvExpression).append(s)
            findViewById<TextView>(R.id.tvResult).text = ""
        }
    }
}