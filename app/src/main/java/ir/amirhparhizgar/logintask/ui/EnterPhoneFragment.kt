package ir.amirhparhizgar.logintask.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import ir.amirhparhizgar.logintask.R
import ir.amirhparhizgar.logintask.databinding.FragmentEnterPhoneBinding

class EnterPhoneFragment : ViewBindingFragment<FragmentEnterPhoneBinding>() {

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentEnterPhoneBinding> =
        FragmentEnterPhoneBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_enterPhoneFragment_to_enterOTPFragment)
            }
        }
    }
}