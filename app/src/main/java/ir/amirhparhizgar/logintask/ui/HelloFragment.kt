package ir.amirhparhizgar.logintask.ui

import dagger.hilt.android.AndroidEntryPoint
import ir.amirhparhizgar.logintask.databinding.FragmentHelloBinding

@AndroidEntryPoint
class HelloFragment : ViewBindingFragment<FragmentHelloBinding>() {

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentHelloBinding> =
        FragmentHelloBinding::inflate

}