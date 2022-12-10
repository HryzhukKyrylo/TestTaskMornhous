package com.example.testtaskmornhouse.ui.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.usecases.GetNumberInfoUseCase
import com.example.testtaskmornhouse.domain.usecases.SaveNumberInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getNumberInfoUseCase: GetNumberInfoUseCase,
    private val saveNumberInfoUseCase: SaveNumberInfoUseCase,
) : ViewModel() {
    private val _infoOfNumber: MutableLiveData<NumberModel?> = MutableLiveData(null)
    val infoOfNumber: LiveData<NumberModel?> = _infoOfNumber

    fun requireNumberInfo(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val resVal = getNumberInfoUseCase.execute(data = data)
            resVal?.let { data ->
                saveNumberInfoUseCase.execute(data)
            }
            _infoOfNumber.postValue(resVal)
        }
    }
}