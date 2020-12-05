package br.com.desafio03ws

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.register_body.view.*


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_register, container, false)
        callLogin(view)
        callHomeHQ(view)
        return view
    }


     fun callLogin(view: View){
        view.toolbarRegister.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)

        }

}
    private fun callHomeHQ(view: View){
        view.btnSave.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_homeHQFragment)

        }
}

}