package com.github.astat1cc.livetodo.feature_todolist.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.astat1cc.livetodo.core.Const
import com.github.astat1cc.livetodo.core.ResourceProvider
import com.github.astat1cc.livetodo.feature_todolist.databinding.FragmentToDoListBinding
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.ToDoListEpoxyController
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ScreenItemToEpoxyModelMapper
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoListFragment : Fragment() {

    private lateinit var binding: FragmentToDoListBinding

    private val viewModel by viewModel<ToDoListViewModel>()

    private val epoxyController by lazy {
        ToDoListEpoxyController(
            ScreenItemToEpoxyModelMapper.Impl(ResourceProvider.Impl(requireContext())) // todo maybe inject
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentToDoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListeners()
        setupEpoxyRecyclerView()
        observe()
    }

    private fun observe() {
        with(viewModel) {
            screenItems.observe(viewLifecycleOwner) {
                updateUi(it)
            }
        }
    }

    private fun updateUi(screenItems: List<ToDoListScreenItem>) {
        epoxyController.setData(screenItems)
    }

    private fun setupEpoxyRecyclerView() {
        with(binding) {
            epoxyRV.setController(
                epoxyController // todo maybe inject
            )
        }
    }

    private fun setOnClickListeners() {
        binding.createToDoFAB.setOnClickListener {
            navigateToCreateToDo()
        }
    }

    private fun navigateToCreateToDo() {
        val uri = Uri.parse(Const.CREATE_TO_DO_DEEPLINK)
        findNavController().navigate(uri)
    }
}