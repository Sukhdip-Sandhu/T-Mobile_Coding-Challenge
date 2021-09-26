package com.example.tmobilecodingchallenge.adapters

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

        fun bind(card: Cards) {
            handleCardTypeVisibility(card.cardType)

            when (card.cardType) {
                "text" -> {
                    with(itemCardBinding.title) {
                        text = card.card.value
                        textSize = card.card.attributes!!.font.size.toFloat()
                        setTextColor(Color.parseColor(card.card.attributes.textColor))
                    }
                }

                "title_description" -> {
                    with(itemCardBinding.title) {
                        text = card.card.title!!.value
                        textSize = card.card.title.attributes.font.size.toFloat()
                        setTextColor(Color.parseColor(card.card.title.attributes.textColor))
                    }
                    with(itemCardBinding.description) {
                        text = card.card.description!!.value
                        textSize = card.card.description.attributes.font.size.toFloat()
                        setTextColor(Color.parseColor(card.card.description.attributes.textColor))
                    }
                }

                "image_title_description" -> {
                    with(itemCardBinding.title) {
                        text = card.card.title!!.value
                        textSize = card.card.title.attributes.font.size.toFloat()
                        setTextColor(Color.parseColor(card.card.title.attributes.textColor))
                    }
                    with(itemCardBinding.description) {
                        text = card.card.description!!.value
                        textSize = card.card.description.attributes.font.size.toFloat()
                        setTextColor(Color.parseColor(card.card.description.attributes.textColor))
                    }

                    Glide.with(this.itemView.context)
                        .load(card.card.image!!.url)
                        .into(itemCardBinding.image)
                }

            }
        }

        private fun handleCardTypeVisibility(cardType: String) {
            when (cardType) {
                "text" -> {
                    itemCardBinding.title.visibility = View.VISIBLE
                    itemCardBinding.description.visibility = View.GONE
                    itemCardBinding.image.visibility = View.GONE
                }
                "title_description" -> {
                    itemCardBinding.title.visibility = View.VISIBLE
                    itemCardBinding.description.visibility = View.VISIBLE
                    itemCardBinding.image.visibility = View.GONE
                }
                "image_title_description" -> {
                    itemCardBinding.title.visibility = View.VISIBLE
                    itemCardBinding.description.visibility = View.VISIBLE
                    itemCardBinding.image.visibility = View.VISIBLE
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