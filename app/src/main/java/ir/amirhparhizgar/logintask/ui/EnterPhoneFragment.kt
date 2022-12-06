package ir.amirhparhizgar.logintask.ui

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.amirhparhizgar.logintask.R
import ir.amirhparhizgar.logintask.databinding.FragmentEnterPhoneBinding
import ir.amirhparhizgar.logintask.presentation.EnterPhoneViewModel

@AndroidEntryPoint
class EnterPhoneFragment : ViewBindingFragment<FragmentEnterPhoneBinding>() {

    companion object {
        const val EXTRA_PHONE_NUMBER = "phone_number"
    }

    val viewModel: EnterPhoneViewModel by viewModels()

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentEnterPhoneBinding> =
        FragmentEnterPhoneBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnSignIn.isEnabled = false
            btnSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_enterPhoneFragment_to_enterOTPFragment, Bundle().apply {
                    putString(EXTRA_PHONE_NUMBER, etPhone.text.toString())
                })
            }
            etPhone.doOnTextChanged { text, _, _, _ ->
                tlPhone.error = viewModel.getMessage(text.toString())?.let { getString(it) }
                btnSignIn.isEnabled = viewModel.isPhoneValid(text.toString())
            }
            btnSignIn.setOnClickListener {
                viewModel.onSendClicked(etPhone.text.toString())
                findNavController().navigate(R.id.action_enterPhoneFragment_to_enterOTPFragment)
            }
        }
    }
}