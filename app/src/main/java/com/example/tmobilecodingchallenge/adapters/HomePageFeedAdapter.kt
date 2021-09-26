package com.example.tmobilecodingchallenge.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmobilecodingchallenge.databinding.ItemCardBinding
import com.example.tmobilecodingchallenge.models.Cards

class HomePageFeedAdapter : RecyclerView.Adapter<HomePageFeedAdapter.ViewHolder>() {

    private var listOfCards = emptyList<Cards>()

    class ViewHolder(private val itemCardBinding: ItemCardBinding) :
        RecyclerView.ViewHolder(itemCardBinding.root) {

        fun bind(card: Cards, context: Context) {
            when (card.cardType) {

                "text" -> {
                    itemCardBinding.title.text = card.card.value
                    itemCardBinding.title.textSize = card.card.attributes!!.font.size.toFloat()
                    itemCardBinding.title.setTextColor(Color.parseColor(card.card.attributes.textColor))

                    itemCardBinding.description.visibility = View.GONE
                }

                "title_description" -> {
                    itemCardBinding.title.text = card.card.title!!.value
                    itemCardBinding.title.textSize = card.card.title.attributes.font.size.toFloat()
                    itemCardBinding.title.setTextColor(Color.parseColor(card.card.title.attributes.textColor))

                    itemCardBinding.description.text = card.card.description!!.value
                    itemCardBinding.description.textSize =
                        card.card.description.attributes.font.size.toFloat()
                    itemCardBinding.description.setTextColor(Color.parseColor(card.card.description.attributes.textColor))
                }

                "image_title_description" -> {
                    itemCardBinding.title.text = card.card.title!!.value
                    itemCardBinding.title.textSize = card.card.title.attributes.font.size.toFloat()
                    itemCardBinding.title.setTextColor(Color.parseColor(card.card.title.attributes.textColor))

                    itemCardBinding.description.text = card.card.description!!.value
                    itemCardBinding.description.textSize =
                        card.card.description.attributes.font.size.toFloat()
                    itemCardBinding.description.setTextColor(Color.parseColor(card.card.description.attributes.textColor))

                    Glide.with(context)
                        .load(card.card.image!!.url)
                        .into(itemCardBinding.image)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemCardBinding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemCardBinding = itemCardBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = listOfCards[position]
        holder.bind(card, holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return listOfCards.size
    }

    fun setCardsList(cardsList: List<Cards>?) {
        this.listOfCards = cardsList!!
        notifyDataSetChanged()
    }

}