package ir.amirhparhizgar.logintask.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.amirhparhizgar.logintask.R
import ir.amirhparhizgar.logintask.databinding.FragmentEnterOTPBinding
import ir.amirhparhizgar.logintask.ext.collectWithinLifecycle
import ir.amirhparhizgar.logintask.presentation.EnterOTPViewModel
import ir.amirhparhizgar.logintask.presentation.EnterPhoneViewModel
import ir.amirhparhizgar.logintask.ui.EnterPhoneFragment.Companion.EXTRA_PHONE_NUMBER

@AndroidEntryPoint
class EnterOTPFragment : ViewBindingFragment<FragmentEnterOTPBinding>() {

    private val viewmodel: EnterOTPViewModel by viewModels()

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentEnterOTPBinding> =
        FragmentEnterOTPBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvOtpSent.text = getString(R.string.otp_sent, requireArguments().getString(EXTRA_PHONE_NUMBER))
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnResend.setOnClickListener {
                viewmodel.onResendClicked()
            }
            btnSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_enterOTPFragment_to_helloFragment)
            }
            viewmodel.timeToSendAgain.collectWithinLifecycle(viewLifecycleOwner) {
                btnResend.text =
                    if (it > 0) {
                        btnResend.isEnabled = false
                        val minute = it / 60
                        val second = it % 60
                        "%02d:%02d".format(minute, second)
                    } else {
                        btnResend.isEnabled = true
                        getString(R.string.resend)
                    }
            }
        }
    }
}