package ir.amirhparhizgar.logintask.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import ir.amirhparhizgar.logintask.R
import ir.amirhparhizgar.logintask.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : ViewBindingFragment<FragmentSplashBinding>() {

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentSplashBinding> =
        FragmentSplashBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            delay(5_000)
            findNavController().navigate(R.id.action_splashFragment_to_enterPhoneFragment)
        }
    }
}