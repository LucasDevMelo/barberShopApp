package com.example.barbershopapp.view

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.ActivityAgendamentoBinding

class Agendamento : AppCompatActivity() {

    private lateinit var binding:ActivityAgendamentoBinding
    privatre val calendar: Calendar = Calendar.getInstance()
    private var data: String=  ""
    private var hora: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener{ _, year, monthOfYear, dayOfMonth ->
            calendar.setWeekData()
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            var dia = dayOfMonth.toString()
            val mes: String

            if (dayOfMonth < 10){
                dia = "0$dayOfMonth"
            }
            if (monthOfYear < 10){
                mes = "" + (monthOfYear+1)
            } else{
                mes = (monthOfYear+1).toString()
            }

            data = "$dia / $mes / $year"
        }

        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val minuto: String

            if (minute < 10){
                minuto = "0$minute"
            }else{
                minuto = minute.toString()
            }

            hora = "$hourOfDay:$minuto"
        }
        binding.timePicker.setIs24HourView(true) //formato de 24 goras

        binding.btAgendar.setOnClickListener {
            val barbeiro1 = binding.barbeiro1
            val barbeiro2 = binding.barbeiro2
            val barbeiro3 = binding.barbeiro3

            //54
        }
    }
}