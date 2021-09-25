package com.example.tmobilecodingchallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobilecodingchallenge.databinding.ItemCardBinding
import com.example.tmobilecodingchallenge.models.Cards

class HomePageFeedAdapter : RecyclerView.Adapter<HomePageFeedAdapter.ViewHolder>() {

    private var listOfCards = emptyList<Cards>()

    class ViewHolder(private val itemCardBinding: ItemCardBinding) : RecyclerView.ViewHolder(itemCardBinding.root) {
        fun bind(card: Cards) {
            itemCardBinding.title.text = card.card.title?.value
            itemCardBinding.description.text = card.card.description?.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemCardBinding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemCardBinding = itemCardBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = listOfCards[position]
        holder.bind(card)
    }

    override fun getItemCount(): Int {
        return listOfCards.size
    }

    fun setCardsList(cardsList: List<Cards>?) {
        this.listOfCards = cardsList!!
        notifyDataSetChanged()
    }

}