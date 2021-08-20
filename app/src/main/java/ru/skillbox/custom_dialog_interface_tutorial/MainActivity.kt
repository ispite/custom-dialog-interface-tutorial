package ru.skillbox.custom_dialog_interface_tutorial

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ExampleDialog.ExampleDialogListener {
    private var textViewUsername: TextView? = null
    private var textViewPassword: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewUsername = textview_username
        textViewPassword = textview_password

        //You can use the old search method
        //val button = findViewById<View>(R.id.button) as Button

        //Or use the synthetic library. Don't forget to add
        //'kotlin-android-extensions' plugin in gradle
        button.setOnClickListener { openDialog() }

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