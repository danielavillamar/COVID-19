package com.example.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.covid_19.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import com.example.covid_19.activities.ScrollingText
import com.example.covid_19.activities.ScrollingText2
import com.example.covid_19.activities.ScrollingText3
import com.example.covid_19.models.Calculadora


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myData = Calculadora("Daniela", "19")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val comment = intent.getStringExtra("comment")
        if (comment!=null && comment!="")
        {
            Toast.makeText(applicationContext, comment, Toast.LENGTH_SHORT).show()
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myData = myData

        binding.star.setOnClickListener {
            addName(it)
        }
        binding.Virus.setOnClickListener {
            startActivity(Intent(this, ScrollingText::class.java))
        }
        binding.Symptoms.setOnClickListener {
            startActivity(Intent(this, ScrollingText2::class.java))
        }
        binding.Indications.setOnClickListener {
            startActivity(Intent(this, ScrollingText3::class.java))
        }


    }

    // Ingresar nombre del usuario y esconder ciertos textos
    private fun addName(view: View) {
        binding.apply {

            val name: String = nameEdit.text.toString()
            val age: String = ageEdit.text.toString()

            val num: Int = age.toInt()
            var infom: String
            // Se corre un if para la especificación del mensaje a deesplegar tanto como de como funciona el boton de la estrella
            infom = if (num.toInt() in 0..9){
                "Tu tasa de mortalidad es de 0%. Sin embargo, debes de ser precavido por que si podrias contagiarte"
            }else if (num.toInt() in 9..39){
            "Tu tasa de mortalidad es de 0.2%. Estas en peligro de contraer el virus y ser portador de el. Por favor #QuedateEnCasa y procura seguir las reglas de higiene establecidad en tu país."
            }else if (num.toInt() in 39..59){
                "Tu tasa de mortalidad es de 1.3%. Estas en peligro de contraer el virus y ser portador de el. Por favor #QuedateEnCasa y procura seguir las reglas de higiene establecidad en tu país."
            }else if (num.toInt() in 59..69){
                "Tu tasa de mortalidad es de 3.6%. Estas en peligro de contraer el virus y ser portador de el. Por favor #QuedateEnCasa y procura seguir las reglas de higiene establecidad en tu país."
            }else if (num.toInt() in 69..79){
                "Tu tasa de mortalidad es de 8.0%. Estas en peligro de contraer el virus y ser portador de el. Por favor debes de tener mas cuidado que nunca, #QuedateEnCasa y procura seguir las reglas de higiene establecidad en tu país."
            }else if (num.toInt() in 79..99) {
                "Tu tasa de mortalidad es de 14.8%. Estas en peligro de contraer el virus y ser portador de el. Por favor debes de tener mas cuidado que nunca, #QuedateEnCasa y procura seguir las reglas de higiene establecidad en tu país."
            }else{
                "Esta calculadora solo funciona con edades entre 0 a 99 años..."
            }
             info.text= "$name, $infom"
            if(info.visibility== View.GONE){
                myData?.name = nameEdit.text.toString()
                myData?.age = ageEdit.text.toString()
                invalidateAll()
                nameText.visibility=View.GONE
                ageText.visibility=View.GONE
                info.visibility=View.VISIBLE
            } else{
                myData?.name = nameEdit.text.toString()
                myData?.age = ageEdit.text.toString()
                invalidateAll()
                nameText.visibility=View.VISIBLE
                ageText.visibility=View.VISIBLE
                info.visibility=View.GONE
            }

            // KEYBOARD
            // Para esconder el teclado
            val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            key.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }


}
