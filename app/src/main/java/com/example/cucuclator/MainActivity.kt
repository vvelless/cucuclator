package com.example.cucuclator

import com.example.cucuclator.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.b0.setOnClickListener { setText("0") }
        binding.b1.setOnClickListener { setText("1") }
        binding.b2.setOnClickListener { setText("2") }
        binding.b3.setOnClickListener { setText("3") }
        binding.b4.setOnClickListener { setText("4") }
        binding.b5.setOnClickListener { setText("5") }
        binding.b6.setOnClickListener { setText("6") }
        binding.b7.setOnClickListener { setText("7") }
        binding.b8.setOnClickListener { setText("8") }
        binding.b9.setOnClickListener { setText("9") }
        binding.bMinus.setOnClickListener { setText("-") }
        binding.bPlus.setOnClickListener { setText("+") }
        binding.bMultiply.setOnClickListener { setText("*") }
        binding.bDevide.setOnClickListener { setText("/") }
        binding.bLeftBrace.setOnClickListener { setText("(") }
        binding.bRightBrace.setOnClickListener { setText(")") }

        binding.btnClear.setOnClickListener {
            binding.mathOp.text = ""
            binding.textResult.text = ""
        }

        binding.bBackSpace.setOnClickListener {
            val text : String = binding.mathOp.text.toString()
            if(text.isNotEmpty()){
                binding.mathOp.text = text.substring(0, text.length - 1)
            }
            binding.textResult.text = ""
        }

        binding.bEqual.setOnClickListener {
            try{
                val exp = ExpressionBuilder(binding.mathOp.text.toString()).build()
                val res = exp.evaluate()
                val lRes = res.toLong()
                if(res == lRes.toDouble())
                    binding.textResult.text = lRes.toString()
                else
                    binding.textResult.text = res.toString()

            }catch(e:Exception) {
                Log.d("Error", "Message: ${e.message}")
            }
        }
    }

    fun setText(str: String){

        if(binding.textResult.text != ""){
            binding.mathOp.text = binding.textResult.text
            binding.textResult.text = ""
        }

        binding.mathOp.append(str)
    }


}