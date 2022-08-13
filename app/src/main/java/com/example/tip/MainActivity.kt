package com.example.tip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tip.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.jvm.internal.Intrinsics

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener { calculateTip() }
    }
    private fun calculateTip() {
        // Input User
        val stringCost = binding.tfInput.text.toString()
        val cost = stringCost.toDouble()

        //Radio Button
        val selectedPercent = binding.rgTipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedPercent){
            R.id.rbTwentyPercent -> 0.2
            R.id.rbEighteenPercent -> 0.18
            else -> 0.1
        }

        //Hitung Tip
        var tip = tipPercentage * cost
        val roundUp = binding.swRound.isChecked
        if (roundUp) tip = kotlin.math.ceil(tip)
        val formatted = NumberFormat.getCurrencyInstance().format(tip)

        //Tampilkan Hasil
        binding.tvResult.text = formatted
    }
}