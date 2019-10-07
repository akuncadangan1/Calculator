package com.kotlin.w.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener{appendOnExpression("1",true)}
        two.setOnClickListener{appendOnExpression("2",true)}
        three.setOnClickListener{appendOnExpression("3",true)}
        four.setOnClickListener{appendOnExpression("4",true)}
        five.setOnClickListener{appendOnExpression("5",true)}
        six.setOnClickListener{appendOnExpression("6",true)}
        seven.setOnClickListener{appendOnExpression("7",true)}
        eight.setOnClickListener{appendOnExpression("8",true)}
        nine.setOnClickListener{appendOnExpression("9",true)}

        plus.setOnClickListener{appendOnExpression("+",true)}
        minus.setOnClickListener{appendOnExpression("-",true)}
        times.setOnClickListener{appendOnExpression("*",true)}
        divide.setOnClickListener{appendOnExpression("/",true)}
        un1.setOnClickListener{appendOnExpression("(",true)}
        un2.setOnClickListener{appendOnExpression(")",true)}

        ce.setOnClickListener {
            textinput.text = ""
            textoutput.text = ""
        }
        erase.setOnClickListener {
            val string = textinput.text.toString()
            if (string.isNotEmpty()){
                textinput.text = string.substring(0,string.length-1)
            }
            textoutput.text=""
        }
        equal.setOnClickListener {
           try {
               val expression = ExpressionBuilder(textinput.text.toString()).build()
               val result = expression.evaluate()
               val longResult = result.toLong()
               if (result == longResult.toDouble())
                   textoutput.text = longResult.toString()
               else
                   textoutput.text = result.toString()
           } catch (e:Exception){
               Log.d("Exception","message : " +e.message)
           }
        }

    }
    fun appendOnExpression(string: String,canClear : Boolean){
        if (canClear){
            textoutput.text=""
            textinput.append(string)
        }else{
            textinput.append(textinput.text)
            textinput.append(string)
            textoutput.text=""
        }
    }
}
