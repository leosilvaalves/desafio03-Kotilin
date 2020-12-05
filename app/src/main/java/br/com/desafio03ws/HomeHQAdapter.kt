package br.com.desafio03ws

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import br.com.desafio03ws.entities.Result
import kotlinx.android.synthetic.main.item_quadrinho.view.*

class HomeHQAdapter(val listHQ: List<Result>, val listener: HomeHQFragment) :
        RecyclerView.Adapter<HomeHQAdapter.viewHolderHQ>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderHQ {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quadrinho, parent, false)
        return viewHolderHQ(view)
    }

    override fun onBindViewHolder(holder: viewHolderHQ, position: Int) {
        val hq = listHQ[position]

        holder.numHQ.text = hq.title
        Picasso.get().load(hq.thumbnail.path.replace("http://", "https://")
                +"."+ hq.thumbnail.extension)
                .into(holder.imagemCapa)

        holder.itemView.setOnClickListener {
            listener.hqClick(position)
        }
    }

    interface onClickHQ{
        fun hqClick(position: Int)
    }


    override fun getItemCount() = listHQ.size

    inner class viewHolderHQ(view: View) : RecyclerView.ViewHolder(view) {
        val imagemCapa: ImageView = view.img_HQ
        val numHQ: TextView = view.item_HQ

    }
}