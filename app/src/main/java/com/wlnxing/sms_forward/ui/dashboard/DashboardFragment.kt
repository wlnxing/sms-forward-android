package com.wlnxing.sms_forward.ui.dashboard

import DashboardViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.wlnxing.sms_forward.R
import com.wlnxing.sms_forward.Repository.DashboardRepository
import com.wlnxing.sms_forward.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // ViewModel 初始化
        val repository = DashboardRepository(requireContext())
        val viewModelFactory = DashboardViewModelFactory(repository)
        dashboardViewModel = ViewModelProvider(this, viewModelFactory).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubmitButton()
        loadSavedSettings()
    }

    private fun setupSubmitButton() {
        binding.submitButton.setOnClickListener {
            val serverAddress = binding.serverAddress.text.toString()
            val token = binding.token.text.toString()

            dashboardViewModel.saveSettings(serverAddress, token)

            // 显示保存成功的 Toast
            Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show()

            // 跳转到 HomeFragment
            navigateToHomeFragment()
        }
    }

    private fun navigateToHomeFragment() {
        findNavController().navigate(R.id.action_dashboardFragment_to_homeFragment)
    }

    private fun loadSavedSettings() {
        dashboardViewModel.getServerAddress()?.let {
            binding.serverAddress.setText(it)
        }
        dashboardViewModel.getToken()?.let {
            binding.token.setText(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
