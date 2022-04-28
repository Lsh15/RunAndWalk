package com.androiddevs.runningapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.androiddevs.runningapp.R
import com.androiddevs.runningapp.ui.viewmodels.MainViewModel
import com.androiddevs.runningapp.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {

    private val viewModel: StatisticsViewModel by viewModels()
}