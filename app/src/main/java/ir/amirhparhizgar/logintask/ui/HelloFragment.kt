package ir.amirhparhizgar.logintask.ui

import ir.amirhparhizgar.logintask.databinding.FragmentHelloBinding

class HelloFragment : ViewBindingFragment<FragmentHelloBinding>() {

    override fun getViewBindingInflater(): ViewBindingInflater<FragmentHelloBinding> =
        FragmentHelloBinding::inflate

}