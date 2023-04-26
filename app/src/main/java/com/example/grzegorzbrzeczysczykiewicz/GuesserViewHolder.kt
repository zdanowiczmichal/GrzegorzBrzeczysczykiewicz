package com.example.grzegorzbrzeczysczykiewicz

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.grzegorzbrzeczysczykiewicz.databinding.ListItemBinding

class GuesserViewHolder (val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentGuesser: Guesser

    fun bindGuesser(guesser: Guesser) {
        //val imageView: ImageView = binding.imageView as ImageView
        //Glide.with(imageView).load(currentBook.uri).into(imageView)
    }

}