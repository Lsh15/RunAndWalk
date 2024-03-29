package com.androiddevs.runningapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.androiddevs.runningapp.R
import com.androiddevs.runningapp.other.Constants.KEY_FIRST_TIME_TOGGLE
import com.androiddevs.runningapp.other.Constants.KEY_NAME
import com.androiddevs.runningapp.other.Constants.KEY_TYPE
import com.androiddevs.runningapp.other.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_setup.*
import javax.inject.Inject

@AndroidEntryPoint
class SetupFragment : Fragment(R.layout.fragment_setup) {

    @Inject
    lateinit var sharedPref : SharedPreferences

    @set: Inject
    var isFirstAppOpen = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isFirstAppOpen){
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.setupFragment, true)
                .build()
            findNavController().navigate(
                R.id.action_setupFragment_to_runFragment,
                savedInstanceState,
                navOptions
            )
        }
        walkToggleBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                Log.d("RunBtn","Run")
                sharedPref.edit()
                    .putBoolean(KEY_TYPE,isChecked)
                    .apply()
            }else {
                Log.d("WalkBtn","Walk")
                sharedPref.edit()
                    .putBoolean(KEY_TYPE,isChecked)
                    .apply()
            }
        }
        tvContinue.setOnClickListener {
            val success = writePersonalDataToSharePref()
            if (success){
                findNavController().navigate(R.id.action_setupFragment_to_runFragment)
            }
            else{
                Snackbar.make(requireView(),getString(R.string.enter_fields),Snackbar.LENGTH_SHORT).show()
            }
        }
    }


    private fun writePersonalDataToSharePref() : Boolean{
        val name = etName.text.toString()
        val weight = etWeight.text.toString()
        if (name.isEmpty() || weight.isEmpty()){
            return false
        }   
        sharedPref.edit()
            .putString(KEY_NAME, name)
            .putFloat(KEY_WEIGHT, weight.toFloat())
            .putBoolean(KEY_FIRST_TIME_TOGGLE, false)
            .apply()
        val toolbarText = getString(R.string.HELLO) + " " + name + "!"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }

}