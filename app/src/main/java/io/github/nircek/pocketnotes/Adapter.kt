package io.github.nircek.pocketnotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.nircek.pocketnotes.databinding.ItemBinding

class Adapter(val list: ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /*
    val abc = arrayListOf(list)
    val cba = ArrayList<ArrayList<T>>()
    init {
        cba.add(list)
    }
    */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        holder.bind(list[position])
    }

    class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.text = item
            binding.executePendingBindings()
        }
    }
}