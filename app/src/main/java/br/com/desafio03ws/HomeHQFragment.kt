package br.com.desafio03ws

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafio03ws.repo.service
import kotlinx.android.synthetic.main.fragment_home_h_q.view.*


class HomeHQFragment : Fragment(),HomeHQAdapter.onClickHQ {


    var offset = 1
    private lateinit var adapterHQ: HomeHQAdapter
    private lateinit var layoutManagerHQ: GridLayoutManager


    private val viewModel by viewModels<HomeHQViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeHQViewModel(service) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_h_q, container, false)

        layoutManagerHQ = GridLayoutManager(context, 3)
        view.rv_fragment.layoutManager = layoutManagerHQ


        viewModel.listComics.observe(viewLifecycleOwner, {
            adapterHQ = HomeHQAdapter(it, this)
            view.rv_fragment.adapter = adapterHQ
        })

        viewModel.getHQs(offset)
        setScrollView(view)

        return view
    }

    override fun hqClick(position: Int) {
        viewModel.listComics.observe(this, {
            val selectHQ = it[position]

            val bundle = bundleOf("key" to selectHQ)
            findNavController().navigate(R.id.action_homeHQFragment_to_detalhesHQFragment, bundle)
        })
    }

     fun setScrollView(view: View) {
        view.rv_fragment?.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val itensTotal = adapterHQ.itemCount
                    val itensVisible = layoutManagerHQ.childCount
                    val itensPass = layoutManagerHQ.findFirstVisibleItemPosition()

                    if (itensTotal==(itensVisible + itensPass) ) {
                        offset++
                        viewModel.getHQs(offset)
                    }
                }
            })
        }
    }

}