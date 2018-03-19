package com.example.kotlinandroid_p16_alertdialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog_custom.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Обрабатываем нажатия в методах
        btnClick.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this@MainActivity)

            dialogBuilder.setTitle("Hey There!")
            dialogBuilder.setMessage("I am an Alert Dialog")

            dialogBuilder.setPositiveButton(R.string.button_positive,
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this@MainActivity, "Okay", Toast.LENGTH_SHORT).show()
                    })

            dialogBuilder.setNegativeButton(R.string.button_negative,
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this@MainActivity, "Cancel", Toast.LENGTH_SHORT).show()
                    })

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

        }

//        Пишем обработчик отдельно (dialogListener)
        btnClickSecondDialog.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this@MainActivity)

            dialogBuilder.setTitle("Hey There!")
            dialogBuilder.setMessage("I am an Alert Dialog")

            dialogBuilder.setPositiveButton(R.string.button_positive, dialogListener)

            dialogBuilder.setNegativeButton(R.string.button_negative, dialogListener)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

        }

//        Custom Alert Dialog
        btnCustomDialog.setOnClickListener {

            val dialogBuilder = AlertDialog.Builder(this@MainActivity)

            dialogBuilder.setTitle("Hey I am a Custom Alert Dialog")

            val view = layoutInflater.inflate(R.layout.alert_dialog_custom, null)

            dialogBuilder.setView(view)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            view.btnClickCustom.setOnClickListener {

                val name = view.edNameCustom.text.toString()
                Toast.makeText(this, "Hello $name", Toast.LENGTH_SHORT).show()

                alertDialog.dismiss()

            }

        }

    }

    val dialogListener = DialogInterface.OnClickListener { dialog, which ->
        when(which){
            AlertDialog.BUTTON_POSITIVE ->
                Toast.makeText(this@MainActivity, "Okay New Dialog", Toast.LENGTH_SHORT).show()
            AlertDialog.BUTTON_NEGATIVE ->
                Toast.makeText(this@MainActivity, "Cancel New Dialog", Toast.LENGTH_SHORT).show()
        }
    }


}
