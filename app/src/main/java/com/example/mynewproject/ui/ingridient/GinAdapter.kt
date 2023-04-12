package com.example.mynewproject.ui.ingridient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mynewproject.R
import com.example.mynewproject.data.model.ingredient.DrinkModelGin
import com.example.mynewproject.databinding.ItemGinBinding


class GinAdapter(val gin: List<DrinkModelGin>?) :
            RecyclerView.Adapter<GinAdapter.ViewHolder>() {
    //new
    var onItemClick: ((DrinkModelGin) -> Unit)? = null

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
                 val binding = ItemGinBinding.bind(view)
                fun handleData(item: DrinkModelGin?) {
                    item?.let{
                        with(it){

                            binding.people2.text = strDrink
                            binding.imageView.load(
                                data = "$strDrinkThumb"
                            )
                        }
                    }
                }


            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_gin, parent, false)
                return ViewHolder(view)
            }

            override fun getItemCount(): Int = gin?.size ?: 0



            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.handleData(gin?.get(position))
                
                //new


                holder.itemView.setOnClickListener {
                    gin?.get(position)?.let{
                        onItemClick?.invoke(it)
                    }
                }
            }
                
            }



