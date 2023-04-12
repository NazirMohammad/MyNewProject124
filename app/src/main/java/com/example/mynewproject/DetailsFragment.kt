package com.example.mynewproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.mynewproject.data.model.alcoholic.DrinkModelAlcoholic
import com.example.mynewproject.data.model.ingredient.DrinkModelGin
import com.example.mynewproject.databinding.FragmentDetailsBinding
import com.example.mynewproject.ui.ingridient.IngridientFragment
import com.example.mynewproject.ui.ingridient.IngridientViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null

    private val binding get()= _binding!!
    private lateinit var viewModel: DetailsViewModel

//    //new ingrideint
//    private lateinit var viewModel1: IngridientViewModel



    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?
    ): View? {

    viewModel =
        ViewModelProvider(this)[DetailsViewModel::class.java]
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)


//        //new
//
//        viewModel1 =
//            ViewModelProvider(this)[IngridientViewModel::class.java]
//        _binding = FragmentDetailsBinding.inflate(inflater,container,false)
//
//
////new
//
//
//        val gin = arguments?.getSerializable("gin") as DrinkModelGin?
//
//        gin?.let{
//            with(it) {
//                binding.people1.text = gin?.strDrink
//                binding.imageView.load(
//                    data = "$strDrinkThumb"
//                )
//
//
//            }}




        val drinks = arguments?.getSerializable("drinks") as DrinkModelAlcoholic?

        drinks?.let{
            with(it) {
                binding.people1.text = drinks?.strDrink
                binding.imageView.load(
                    data = "$strDrinkThumb"
                )

            }}
        return binding.root


    }
}