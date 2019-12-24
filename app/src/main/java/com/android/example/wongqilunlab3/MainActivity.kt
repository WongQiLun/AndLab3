package com.android.example.wongqilunlab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var genderString :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton =findViewById<Button>(R.id.buttonCalculate)
        calculateButton.setOnClickListener{calculateTicketPrice()}

    }
    fun calculateTicketPrice(){
        val SpinnerAge = (findViewById<Spinner>(R.id.spinnerAge))
        var age  = SpinnerAge.selectedItem.toString()
        var premium = 0
        val GenderRadio : RadioGroup= (findViewById<RadioGroup>(R.id.radioGroupGender))
        var Gender:Int = GenderRadio.checkedRadioButtonId
        var checkBox:CheckBox = findViewById(R.id.checkBoxSmoker)
        var  smoker =checkBox.isChecked
        if( Gender !=-1 ){
            val radio:RadioButton = findViewById(Gender)
            genderString="${radio.text}"

        }


        if (age =="More than 55"){
            premium += 150
            if(genderString == "Male"){
                premium += 200
            }
            if(smoker){
                premium += 300
            }
        }else if (age=="41 to 55"){
            premium += 150
            if(genderString == "Male"){
                premium += 200
            }
            if(smoker){
                premium += 250
            }
        }else if(age =="31 to 40"){
            premium += 120
            if(genderString == "Male"){
                premium += 150
            }
            if(smoker){
                premium += 200
            }
        }else if( age=="26 to 30"){
            premium += 90
            if(genderString == "Male"){
                premium += 100
            }
            if(smoker){
                premium += 150
            }
        }else if (age == "17 to 25"){
            premium += 70
            if(genderString == "Male"){
                premium += 50

            }
            if(smoker){
                premium += 100
            }
        }else{
            premium += 60
        }
        val textView:TextView = findViewById(R.id.textViewPremium)
        textView.text = resources.getString(R.string.insurance_premium) +": "+premium
    }
}
