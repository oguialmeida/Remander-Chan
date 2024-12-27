package com.example.agendinha_chan.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendinha_chan.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupEditText()
    }

    private fun setupRecyclerView() {
        todoAdapter = TodoAdapter()
        binding.recyclerViewTodos.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoAdapter
        }
    }

    private fun setupEditText() {
        binding.editTextTodo.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = textView.text.toString().trim()
                if (text.isNotEmpty()) {
                    todoAdapter.addTodo(TodoItem(text))
                    textView.text = ""
                }
                true
            } else {
                false
            }
        }
    }

    fun clearCompletedTodos() {
        todoAdapter.clearCompleted()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}