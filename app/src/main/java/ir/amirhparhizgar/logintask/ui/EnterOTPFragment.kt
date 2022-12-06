package ir.amirhparhizgar.logintask.ui

import dagger.hilt.android.AndroidEntryPoint
import ir.amirhparhizgar.logintask.databinding.FragmentEnterOTPBinding

@AndroidEntryPoint
class EnterOTPFragment : ViewBindingFragment<FragmentEnterOTPBinding>() {

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentEnterOTPBinding> =
        FragmentEnterOTPBinding::inflate

}