package com.example.mynewproject.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewproject.R
import com.example.mynewproject.data.model.category.DrinkModel
import com.example.mynewproject.data.model.category.Ordinary_DrinkModel
import com.example.mynewproject.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {

    private val viewModel by viewModels<CategoryViewModel>()
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private var categoryAdapter: CategoryAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        viewModel.category.observe(viewLifecycleOwner){
            it?.let {
                setupUI(it)
            }

        }


      viewModel.getOrdinarydrink()
        return binding.root

        }

    private fun setupUI(category: Ordinary_DrinkModel) {

        categoryAdapter= CategoryAdapter(category.drinks as List<DrinkModel>?)
        binding.fragmentcategory.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = categoryAdapter
        }
        categoryAdapter!!.onItemClick = {

            val bundle = Bundle().apply {

                putSerializable("category", it)
            }

            findNavController().navigate(R.id.action_navigation_category_to_detailsFragment, bundle)

        }

    }

}


