package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()


        val saveBtn = findViewById<Button>(R.id.save_button)
        val loadBtn  = findViewById<Button>(R.id.load_button)
        val editTextName = findViewById<EditText>(R.id.editText)
        val checkboxVaccinated = findViewById<CheckBox>(R.id.checkbox)

        saveBtn.setOnClickListener{
            val name = editTextName.text.toString()
            val isVaccinated = checkboxVaccinated.isChecked

            editor.apply {
                putString("name",name)
                putBoolean("isVaccinated",isVaccinated)
                apply()
            }
        }

        loadBtn.setOnClickListener{
            val name = sharedPref.getString("name",null)
            val isVaccinated = sharedPref.getBoolean("isVaccinated",false)

            editTextName.setText(name)
            checkboxVaccinated.isChecked = isVaccinated
        }
    }
}