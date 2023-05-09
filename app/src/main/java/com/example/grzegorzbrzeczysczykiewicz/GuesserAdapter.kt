package com.example.grzegorzbrzeczysczykiewicz
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.grzegorzbrzeczysczykiewicz.databinding.ListItemBinding
//
//class GuesserAdapter(val guessers: List<Guesser>) : RecyclerView.Adapter<GuesserViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuesserViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
//        return GuesserViewHolder(binding)
//
//    }
//
//    override fun onBindViewHolder(holder: GuesserViewHolder, position: Int) {
//        val guesser = guessers[position]
//        holder.bindGuesser(guesser)
//    }
//
//    override fun getItemCount(): Int {
//        return guessers.size
//    }
//}