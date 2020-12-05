package br.com.desafio03ws

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.desafio03ws.repo.service
import kotlinx.coroutines.launch
import br.com.desafio03ws.entities.Result



class HomeHQViewModel(service: br.com.desafio03ws.repo.Service): ViewModel() {
    val listComics = MutableLiveData<List<Result>>()

    fun getHQs(offset: Int) {
        viewModelScope.launch {
            listComics.value = service.getAllHQRepo(offset).data.results
        }
    }
}