package com.example.covid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.covid_19.databinding.ActivityScrollingTextBinding
import kotlinx.android.synthetic.main.activity_scrolling_text.*


class ScrollingText3 : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingTextBinding
    var title: String = "Indications"
    var subtitle: String = "¿Cuales son las indicaciones a seguir?"
    var description: String =
        "Manténgase al día de la información más reciente sobre el brote de COVID-19, a la que puede acceder en el sitio web de la OMS y a través de las autoridades de salud pública pertinentes a nivel nacional y local. La COVID-19 sigue afectando principalmente a la población de China, aunque se han producido brotes en otros países. La mayoría de las personas que se infectan padecen una enfermedad leve y se recuperan, pero en otros casos puede ser más grave. Cuide su salud y proteja a los demás a través de las siguientes medidas: Lávese las manos con frecuencia con un desinfectante de manos a base de alcohol o con agua y jabón. Al toser o estornudar, cúbrase la boca y la nariz con el codo flexionado o con un pañuelo; tire el pañuelo inmediatamente y lávese las manos con un desinfectante de manos a base de alcohol, o con agua y jabón. Mantenga al menos 1 metro (3 pies) de distancia entre usted y las demás personas, particularmente aquellas que tosan, estornuden y tengan fiebre. Evite tocarse los ojos, la nariz y la boca. Si tiene fiebre, tos y dificultad para respirar, solicite atención médica a tiempo, indique a su prestador de atención de salud si ha viajado a una zona de China en la que se haya notificado la presencia del Covid-19, o si ha tenido un contacto cercano con alguien que haya viajado desde China y tenga síntomas respiratorios. Manténgase informado sobre las últimas novedades en relación con la COVID-19. Siga los consejos de su dispensador de atención de salud, de las autoridades sanitarias pertinentes a nivel nacional y local o de su empleador sobre la forma de protegerse a sí mismo y a los demás ante la COVID-19." // Info de la OMS
    private val myData: Calculadora =
        Calculadora(title, subtitle, description)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_scrolling_text3
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