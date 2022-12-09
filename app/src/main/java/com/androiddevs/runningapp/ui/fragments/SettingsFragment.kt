package com.androiddevs.runningapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.androiddevs.runningapp.R
import com.androiddevs.runningapp.other.Constants
import com.androiddevs.runningapp.other.Constants.KEY_NAME
import com.androiddevs.runningapp.other.Constants.KEY_TYPE
import com.androiddevs.runningapp.other.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.etName
import kotlinx.android.synthetic.main.fragment_settings.etWeight
import kotlinx.android.synthetic.main.fragment_setup.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    // 현재 line 색상
    private var colorState : Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFieldsFromSharedPref()
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Log.d("RunBtn","Run")
                sharedPreferences.edit()
                    .putBoolean(KEY_TYPE,isChecked)
                    .apply()
            }else {
                Log.d("WalkBtn","Walk")
                sharedPreferences.edit()
                    .putBoolean(KEY_TYPE,isChecked)
                    .apply()
            }
        }
        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if(success) {
                Snackbar.make(view, "Saved changes", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Please fill out all the fields", Snackbar.LENGTH_LONG).show()
            }
        }

        // 색상 원 선택 시
        redCircle.setOnClickListener {
            colorState = 1
            selectColorCircle()
        }
        blueCircle.setOnClickListener {
            colorState = 2
            selectColorCircle()
        }
        greenCircle.setOnClickListener {
            colorState = 3
            selectColorCircle()
        }
        blackCircle.setOnClickListener {
            colorState = 4
            selectColorCircle()
        }
        // 선 색 변경 버튼 클릭 시
        btnLineChanges.setOnClickListener {
            val success = changingColor()
            if(success){
                Snackbar.make(view,"Line color changed.",Snackbar.LENGTH_SHORT).show()
            }
            else{
                Snackbar.make(view,"Please choose again.",Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    private fun loadFieldsFromSharedPref() {
        val name = sharedPreferences.getString(KEY_NAME, "")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        val walkrunType = sharedPreferences.getBoolean(KEY_TYPE,true)
        etName.setText(name)
        etWeight.setText(weight.toString())
        Log.d("WALKTYPE", "typerun $walkrunType")
        if (walkrunType){
            toggleButton.setChecked(true)
        }else{
            toggleButton.setChecked(false)
        }
    }

    private fun applyChangesToSharedPref(): Boolean {
        val nameText = etName.text.toString()
        val weightText = etWeight.text.toString()
        if(nameText.isEmpty() || weightText.isEmpty()) {
            return false
        }
        sharedPreferences.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT, weightText.toFloat())
            .apply()
//        val toolbarText = "Let's go $nameText"
        val toolbarText = getString(R.string.HELLO) + " " + nameText + "!"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }

    // 색상 원 선택 체크
    private fun selectColorCircle(){
            when (colorState) {
                1 -> {
                    redCheck.visibility = View.VISIBLE
                    blueCheck.visibility = View.GONE
                    greenCheck.visibility = View.GONE
                    blackCheck.visibility = View.GONE
                }
                2 -> {
                    redCheck.visibility = View.GONE
                    blueCheck.visibility = View.VISIBLE
                    greenCheck.visibility = View.GONE
                    blackCheck.visibility = View.GONE
                }
                3 -> {
                    redCheck.visibility = View.GONE
                    blueCheck.visibility = View.GONE
                    greenCheck.visibility = View.VISIBLE
                    blackCheck.visibility = View.GONE
                }
                4 -> {
                    redCheck.visibility = View.GONE
                    blueCheck.visibility = View.GONE
                    greenCheck.visibility = View.GONE
                    blackCheck.visibility = View.VISIBLE
            }
         }
    }

    // 선 색상 변경
    private fun changingColor() : Boolean {
            // 선 색상 정보 저장
        sharedPreferences.edit()
            .putInt(Constants.KEY_COLOR, colorState)
            .apply()
            return true
    }
}