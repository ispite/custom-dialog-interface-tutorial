package ru.skillbox.custom_dialog_interface_tutorial

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), ExampleDialog.ExampleDialogListener {
    private var textViewUsername: TextView? = null
    private var textViewPassword: TextView? = null
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewUsername = findViewById<View>(R.id.textview_username) as TextView
        textViewPassword = findViewById<View>(R.id.textview_password) as TextView
        button = findViewById<View>(R.id.button) as Button
        button!!.setOnClickListener { openDialog() }
        /*button.setOnClickListener(object : View.OnClickListener() {
            fun onClick(v: View?) {
                openDialog()
            }
        })*/
    }

    private fun openDialog() {
        val exampleDialog = ExampleDialog()
        exampleDialog.show(supportFragmentManager, "example dialog")
    }

    override fun applyTexts(username: String?, password: String?) {
        textViewUsername!!.text = username
        textViewPassword!!.text = password
    }
}