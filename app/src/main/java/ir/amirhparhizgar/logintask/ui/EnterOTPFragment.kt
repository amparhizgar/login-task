package ir.amirhparhizgar.logintask.ui

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.amirhparhizgar.logintask.R
import ir.amirhparhizgar.logintask.databinding.FragmentEnterOTPBinding
import ir.amirhparhizgar.logintask.ext.collectWithinLifecycle
import ir.amirhparhizgar.logintask.presentation.EnterOTPViewModel
import ir.amirhparhizgar.logintask.ui.EnterPhoneFragment.Companion.EXTRA_PHONE_NUMBER

@AndroidEntryPoint
class EnterOTPFragment : ViewBindingFragment<FragmentEnterOTPBinding>() {

    private val viewModel: EnterOTPViewModel by viewModels()

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentEnterOTPBinding> =
        FragmentEnterOTPBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvOtpSent.text =
                getString(R.string.otp_sent, requireArguments().getString(EXTRA_PHONE_NUMBER))
            pinView.requestFocus()
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnResend.setOnClickListener {
                viewModel.onResendClicked()
            }
            btnSignIn.setOnClickListener {
                if (viewModel.userAuth.oTP == pinView.text.toString().toIntOrNull())
                    findNavController().navigate(R.id.action_enterOTPFragment_to_helloFragment)
                else
                    Toast.makeText(requireContext(), R.string.otp_wrong, Toast.LENGTH_SHORT).show()
            }
            pinView.doOnTextChanged { text, _, _, _ ->
                btnSignIn.setTypeface(
                    null,
                    if (viewModel.userAuth.oTP == text.toString().toIntOrNull())
                        Typeface.BOLD
                    else
                        Typeface.NORMAL
                )
            }
            viewModel.timeToSendAgain.collectWithinLifecycle(viewLifecycleOwner) {
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