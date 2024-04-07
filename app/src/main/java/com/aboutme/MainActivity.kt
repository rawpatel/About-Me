package com.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var myName: MyName = MyName("Surendra Patel")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickName(it)
        }
    }
        private fun addNickName(view: View){
           // val editText = findViewById<EditText>(R.id.nickName_edit)
          //  val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

           // nicknameTextView.text = editText.text
          //  editText.visibility = View.GONE
          //  view.visibility = View.GONE
          //  nicknameTextView.visibility = View.VISIBLE

            binding.apply {
                // Set the text for nicknameText to the value in nicknameEdit
                myName?.nickname = nickNameEdit.text.toString()

                //
                invalidateAll()

                nickNameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE

                // Make the TextView with the nickname visible
                nicknameText.visibility = View.VISIBLE
            }

            // Hide Keyboard
            val imm  = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken,0)

        }

}