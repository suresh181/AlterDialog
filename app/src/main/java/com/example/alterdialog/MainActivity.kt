package com.example.alterdialog

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var alertDialog: AlertDialog? = null

    private var emailPatterns: String
        get() = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        set(value) = TODO()
    private var numberPattern = "[0-9]{10}"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val email = editText1.text.toString().trim()
            val number = editText3.text.toString().trim()
            if (email.matches(emailPatterns.toRegex())) {
                Toast.makeText(this, "Valid Email Address", Toast.LENGTH_SHORT).show()
            } else {
                showDialogAt()
            }

            if (number.matches(numberPattern.toRegex())) {
                Toast.makeText(this, "Valid Number", Toast.LENGTH_SHORT).show()
            } else {
                showDialogPh()
            }


        }
    }


        //            val email = editText1.text.toString().trim()
//            val password = editText2.text.toString().trim()
//            val mobileNo = editText3.text.toString().trim()
//            if (email.isEmpty()){
//                editText1.error = "Email Required"
//                return@setOnClickListener
//            }else if (password.isEmpty()){
//                editText2.error = "Password Required"
//            }else if (mobileNo.isEmpty()){
//                editText3.error = "Mobile Number is Required"
//            }else{
//                Toast.makeText(this,"Validation Completed",Toast.LENGTH_SHORT).show()
//            }


//    private fun mobileNum() {
//
//        editText3.addTextChangedListener(object : TextWatcher{
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                if (p0.isValidPhoneNumber()){
//                    editText3.error = null
//                }else
//                    showDialogAt()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })
//    }
//

        private fun showDialogAt() {

            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle(" Email Address")
            alertDialogBuilder.setMessage("Invalid Email address ")
            alertDialogBuilder.setPositiveButton("Ok") { _: DialogInterface, i: Int ->
                Log.d("Valid", "Positive")
                Log.d("Valid", i.toString())
            }
            alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, i: Int ->

                Log.d("Cancel", "Negative")
                Log.d("Cancel", i.toString())
            }

            alertDialog = alertDialogBuilder.create()
            alertDialog?.show()


        }

    private fun showDialogPh(){
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Phone Number")
        alertDialogBuilder.setMessage("Invalid phone Number ")
        alertDialogBuilder.setPositiveButton("Ok") { _: DialogInterface, i: Int ->
            Log.d("Valid", "Positive")
            Log.d("Valid", i.toString())
        }
        alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, i: Int ->

            Log.d("Cancel", "Negative")
            Log.d("Cancel", i.toString())
        }

        alertDialog = alertDialogBuilder.create()
        alertDialog?.show()
    }



    private fun isValidPhoneNumber(number: String) {
        !TextUtils.isEmpty(number) && Patterns.PHONE.matcher(number).matches();
    }
}

