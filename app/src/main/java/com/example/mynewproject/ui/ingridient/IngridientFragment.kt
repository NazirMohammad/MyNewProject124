package com.example.mynewproject.ui.ingridient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynewproject.R
import com.example.mynewproject.data.model.ingredient.DrinkModelGin
import com.example.mynewproject.data.model.ingredient.GinModel
import com.example.mynewproject.databinding.FragmentIngridentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngridientFragment : Fragment() {

    private val viewModel by viewModels<IngridientViewModel>()
    private var _binding: FragmentIngridentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var ginAdapter: GinAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentIngridentBinding.inflate(inflater, container, false)
        viewModel.gin.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)

            }

        }
        viewModel.getGinmodel()
        return binding.root
    }

    private fun setupUI(gin: GinModel) {
        ginAdapter = GinAdapter(gin.drinks as List<DrinkModelGin>?)
        binding.fragmentgin.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ginAdapter

        }
//new

        ginAdapter!!.onItemClick = {

            val bundle = Bundle().apply {

                putSerializable("gin", it)
            }

            findNavController().navigate(R.id.action_navigation_ingridient_to_detailsFragment, bundle)

        }

    }

}




