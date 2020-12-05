package br.com.desafio03ws

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import br.com.desafio03ws.R
import br.com.desafio03ws.entities.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detalhes_h_q.view.*

class DetalhesHQFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detalhes_h_q, container, false)

        val process_img = Picasso.get()
        val detalhesHQ = getObjetoHQ()

        exibeDetalhes(detalhesHQ, view, process_img)

        return view
    }


    fun exibeDetalhes(
        hqDetail: Result,
        view: View,
        picasso: Picasso
    ) {
        view.tv_titulo.text = hqDetail.title
        view.tv_descricao.text = hqDetail.description
        view.tv_preco.text = hqDetail.prices[0].price
        view.tv_paginas.text = hqDetail.pageCount.toString()
        view.tv_publicacao.text = hqDetail.dates[0].date

        picasso.load(
            hqDetail.thumbnail.path.replace("http://", "https://")
                    + "." + hqDetail.thumbnail.extension
        ).into(view.img_quadrinho)
    }

    private fun getObjetoHQ(): Result {
        return arguments?.get("key") as Result
    }

}

