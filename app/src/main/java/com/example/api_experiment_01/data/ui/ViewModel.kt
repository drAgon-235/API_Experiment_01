package com.example.api_experiment_01.data.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_experiment_01.data.Repository
import com.example.api_experiment_01.data.model.Breed
import com.example.api_experiment_01.data.remote.BreedApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    val repository = Repository(BreedApi.apiService)

    val breedsList: LiveData<List<Breed>> = repository.breedsList


    fun loadBreedListVM(){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("ViewModel", "Load Breed List from Repisitory to VM")
            repository.loadBreedListRepository()
        }

    }
}