package com.example.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.covid_19.databinding.ActivityScrollingTextBinding
import kotlinx.android.synthetic.main.activity_scrolling_text.*


class ScrollingText : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingTextBinding
    var title: String = "Virus"
    var subtitle: String = "¿Que es Coronavirus?"
    var description: String =
        "Los coronavirus son una extensa familia de virus que pueden causar enfermedades tanto en animales como en humanos. En los humanos, se sabe que varios coronavirus causan infecciones respiratorias que pueden ir desde el resfriado común hasta enfermedades más graves como el síndrome respiratorio de Oriente Medio (MERS) y el síndrome respiratorio agudo severo (SRAS).El coronavirus que se ha descubierto más recientemente causa la enfermedad por coronavirus COVID-19." // Info de la OMS

    private val myData: Calculadora =
        Calculadora(title, subtitle, description)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_scrolling_text
        )
        binding.myData = myData

        var com: Button = findViewById(R.id.comentar)
        com.setOnClickListener {
            atras()
        }
    }

    fun atras(){
        val menu = Intent(this, MainActivity::class.java)
        val comment: String=log.text.toString()
        menu.putExtra("comment",comment)
        startActivity(menu)
    }

}




