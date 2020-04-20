package com.example.covid_19.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.covid_19.Models.MainActivity
import com.example.covid_19.Models.Calculadora
import com.example.covid_19.R
import com.example.covid_19.databinding.ActivityScrollingTextBinding
import kotlinx.android.synthetic.main.activity_scrolling_text.*


class ScrollingText2 : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingTextBinding
    var title: String = "Symptoms"
    var subtitle: String = "¿Que sintomas puedes presentar?"
    var description: String =
        "\nLos síntomas más comunes de la COVID-19 son fiebre, cansancio y tos seca. Algunos pacientes pueden presentar dolores, congestión nasal, rinorrea, dolor de garganta o diarrea. Estos síntomas suelen ser leves y aparecen de forma gradual. Algunas personas se infectan pero no desarrollan ningún síntoma y no se encuentran mal. La mayoría de las personas (alrededor del 80%) se recupera de la enfermedad sin necesidad de realizar ningún tratamiento especial. Alrededor de 1 de cada 6 personas que contraen la COVID-19 desarrolla una enfermedad grave y tiene dificultad para respirar. Las personas mayores y las que padecen afecciones médicas subyacentes, como hipertensión arterial, problemas cardiacos o diabetes, tienen más probabilidades de desarrollar una enfermedad grave. En torno al 2% de las personas que han contraído la enfermedad han muerto. Las personas que tengan fiebre, tos y dificultad para respirar deben buscar atención médica." // Info de la OMS
    private val myData: Calculadora =
        Calculadora(title, subtitle, description)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_scrolling_text2
        )
        binding.myData = myData

        var com: Button = findViewById(R.id.comentar)
        com.setOnClickListener {
            atras()
        }
    }

    fun atras() {
        val menu = Intent(this, MainActivity::class.java)
        val comment: String = log.text.toString()
        menu.putExtra("comment", comment)
        startActivity(menu)
    }

}
