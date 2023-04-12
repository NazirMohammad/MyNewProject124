package com.example.mynewproject.ui.alcoholiccontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewproject.R
import com.example.mynewproject.data.model.alcoholic.AlcoholicContentModel
import com.example.mynewproject.data.model.alcoholic.DrinkModelAlcoholic
import com.example.mynewproject.databinding.FragmentAlcoholicBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlcoholicFragment : Fragment() {

    private var _binding: FragmentAlcoholicBinding? = null
    private  val viewModel by viewModels<AlcoholicconViewModel>()
    private var alcoholicAdapter : AlcoholicContentModelAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentAlcoholicBinding.inflate(inflater, container, false)
       viewModel.alcohol.observe(viewLifecycleOwner){
           it?.let {
               setupUI(it)
           }
       }

       viewModel.getAlcoholContent()
        return binding.root

    }

    private fun setupUI(alcohol: AlcoholicContentModel) {
        alcoholicAdapter=AlcoholicContentModelAdapter(alcohol.drinks as List<DrinkModelAlcoholic>?)
        binding.fragmentalcohol.apply {
            layoutManager=LinearLayoutManager(context)
            adapter= alcoholicAdapter

        }



        alcoholicAdapter!!.onItemClick = {

            val bundle = Bundle().apply {

                putSerializable("drinks", it)
            }

            findNavController().navigate(R.id.action_navigation_alcoholic_to_detailsFragment, bundle)

        }

    }

}






