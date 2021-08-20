package ru.skillbox.custom_dialog_interface_tutorial

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment


class ExampleDialog : AppCompatDialogFragment() {
    private var listener: ExampleDialogListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog, null)

        val editTextUsername = view.findViewById<EditText>(R.id.edit_username)
        val editTextPassword = view.findViewById<EditText>(R.id.edit_password)

        return AlertDialog.Builder(requireActivity())
            .setView(view)
            .setTitle("Login")
            .setNegativeButton("Cancel") {_, _, ->}
            .setPositiveButton("Ok") {_, _, ->
                val username = editTextUsername.text.toString()
                val password = editTextPassword.text.toString()
                listener!!.applyTexts(
                    editTextUsername.text.toString(),
                    editTextPassword.text.toString()
                )
            }
            .create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as ExampleDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }

    interface ExampleDialogListener {
        fun applyTexts(username: String?, password: String?)
    }
}