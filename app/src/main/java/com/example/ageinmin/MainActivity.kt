package com.example.ageinmin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

import java.util.*


class MainActivity : AppCompatActivity() {
    private var tvSelectedDate : TextView?=null
    private var tvAgeInMinutes:TextView?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate=findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes=findViewById(R.id.tvAgeInMinutes)
        btnDatePicker.setOnClickListener {

            clickDatePicker()

        }

    }


    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this,
            {view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this,
                    "year was $selectedYear,month was ${selectedMonth+1},day is $selectedDayOfMonth", Toast.LENGTH_LONG).show()

                val selectedDate ="$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theDate =sdf.parse(selectedDate)
                theDate?.let{
                    var selectedDateInMinutes=theDate.time /60000
                    val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let{
                        val currentDateInMinutes=currentDate.time/60
                        val differenceInMinutes=currentDateInMinutes - selectedDateInMinutes
                        tvAgeInMinutes?.text=differenceInMinutes.toString()
                    }

                }


            },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()


    }
}