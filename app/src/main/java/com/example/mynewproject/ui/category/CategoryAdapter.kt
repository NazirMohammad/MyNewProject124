package com.example.mynewproject.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mynewproject.R
import com.example.mynewproject.data.model.category.DrinkModel
import com.example.mynewproject.data.model.category.Ordinary_DrinkModel
import com.example.mynewproject.databinding.ItemCategoryBinding

class CategoryAdapter(val category: List<DrinkModel>?):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){


     var onItemClick: ((DrinkModel) -> Unit)?= null

    class ViewHolder(val view:View): RecyclerView.ViewHolder(view) {
        val binding = ItemCategoryBinding.bind(view)
        fun handleData(item: DrinkModel?) {
            item?.let{
                with(it){
                    binding.drink1.text=idDrink
                    binding.drink2.text=strDrink
                    binding.imageView.load(
                        data = "$strDrinkThumb"
                    )
                }
            }
        }
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int = category?. size ?: 0



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.handleData(category?.get(position))

        holder.itemView.setOnClickListener {
            category?.get(position)?.let{
                onItemClick?.invoke(it)
            }
        }
    }

}





