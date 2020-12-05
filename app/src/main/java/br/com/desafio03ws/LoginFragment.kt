package br.com.desafio03ws

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_body.view.*


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        callHomeHQ(view)
        callRegister(view)

        return view
    }

    fun callHomeHQ(view: View) {
        view.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeHQFragment)
        }
    }

    fun callRegister(view: View) {
        view.btnCadastro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

}
}