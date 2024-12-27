package com.example.agendinha_chan.adapters

import android.app.TimePickerDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agendinha_chan.databinding.ItemTodoBinding
import com.example.agendinha_chan.data.TodoItem
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private val todos = mutableListOf<TodoItem>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

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
            binding.textViewTime.text = todo.time.format(timeFormatter)

            binding.checkBoxTodo.setOnCheckedChangeListener { _, isChecked ->
                todo.isCompleted = isChecked
            }

            binding.textViewTime.setOnClickListener {
                showTimePickerDialog(todo)
            }
        }

        private fun showTimePickerDialog(todo: TodoItem) {
            val context = binding.root.context
            TimePickerDialog(
                context,
                { _, hourOfDay, minute ->
                    todo.time = LocalTime.of(hourOfDay, minute)
                    binding.textViewTime.text = todo.time.format(timeFormatter)
                },
                todo.time.hour,
                todo.time.minute,
                true
            ).show()
        }
    }
}
