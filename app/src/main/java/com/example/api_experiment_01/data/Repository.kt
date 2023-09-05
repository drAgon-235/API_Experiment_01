package com.example.api_experiment_01.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.api_experiment_01.data.model.Breed
import com.example.api_experiment_01.data.remote.ApiService

class Repository (val breedsApi: ApiService){

    private val _breedsList: MutableLiveData<List<Breed>> = MutableLiveData<List<Breed>>()
    val breedsList: LiveData<List<Breed>>
        get() = _breedsList

    suspend fun loadBreedListRepository(){
        // Erst daten von API laden
        val loadedBreeds = breedsApi.getBreedsFromAPI()
        // dann in Format einer Liste "umwandeln" (entpacken gem. .data.model), die der Adapter benötigt:
        val workingBreedsList = loadedBreeds.data
        // letztendlich in die LiveData '_breedsList' des Repository packen, die im ViewModel benutzt wird:
        _breedsList.postValue(workingBreedsList)
    }
}