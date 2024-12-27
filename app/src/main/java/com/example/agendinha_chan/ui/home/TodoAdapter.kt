package com.example.agendinha_chan.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendinha_chan.databinding.ItemTodoBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private val todos = mutableListOf<TodoItem>()

    fun addTodo(todo: TodoItem) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun clearCompleted() {
        val iterator = todos.iterator()
        var index = 0
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item.isCompleted) {
                iterator.remove()
                notifyItemRemoved(index)
            } else {
                index++
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size

    inner class TodoViewHolder(private val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: TodoItem) {
            binding.textViewTodo.text = todo.text
            binding.checkBoxTodo.isChecked = todo.isCompleted
            binding.checkBoxTodo.setOnCheckedChangeListener { _, isChecked ->
                todo.isCompleted = isChecked
            }
        }
    }
}
