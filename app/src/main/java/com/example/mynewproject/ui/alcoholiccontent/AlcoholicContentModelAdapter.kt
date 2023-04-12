package com.example.mynewproject.ui.alcoholiccontent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mynewproject.R
import com.example.mynewproject.data.model.alcoholic.AlcoholicContentModel
import com.example.mynewproject.data.model.alcoholic.DrinkModelAlcoholic
import com.example.mynewproject.databinding.ItemAlcoholBinding

class AlcoholicContentModelAdapter(val alcohol: List<DrinkModelAlcoholic>?):
    RecyclerView.Adapter<AlcoholicContentModelAdapter.ViewHolder>() {


   var onItemClick: ((DrinkModelAlcoholic) -> Unit)? = null



    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemAlcoholBinding.bind(view)

        fun handleDate(item: DrinkModelAlcoholic?) {
            item.let {
                with(it) {

                    binding.people2.text = item?.strDrink
                    binding.people3.text=item?.idDrink
                    binding.imageView.load(
                        data = "${this?.strDrinkThumb}"

                    )

                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alcohol, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int = alcohol?.size?: 0



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.handleDate(alcohol?.get(position))

        holder.itemView.setOnClickListener {
            alcohol?.get(position)?.let{
                onItemClick?.invoke(it)
            }
        }
    }

}
