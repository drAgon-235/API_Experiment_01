package com.example.api_experiment_01.data.ui.mainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_experiment_01.data.model.Breed
import com.example.api_experiment_01.databinding.BreedItemBinding

class BreedListRVMainAdapter(
    private val datasetBreedList: List<Breed>
) : RecyclerView.Adapter<BreedListRVMainAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: BreedItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = BreedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datasetBreedList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // EINEN Breed aus der Liste holen:
        val breed = datasetBreedList[position]

        // Daten in die View einsetzen: XML-View = Object.Attribute (caution! the datatypes! (here String, all) )
        holder.binding.breedsTV.text = breed.breed
        holder.binding.countryTV.text = breed.country
        holder.binding.originTV.text = breed.origin
        holder.binding.coatTV.text = breed.coat
        holder.binding.patternTV.text = breed.pattern
    }
}