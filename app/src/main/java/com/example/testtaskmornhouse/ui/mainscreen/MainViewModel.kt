package com.example.testtaskmornhouse.ui.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskmornhouse.domain.model.NumberModel
import com.example.testtaskmornhouse.domain.usecases.GetListHistoryUseCase
import com.example.testtaskmornhouse.domain.usecases.GetNumberInfoUseCase
import com.example.testtaskmornhouse.domain.usecases.SaveNumberInfoUseCase
import com.example.testtaskmornhouse.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getNumberInfoUseCase: GetNumberInfoUseCase,
    private val saveNumberInfoUseCase: SaveNumberInfoUseCase,
    private val getListHistoryUseCase: GetListHistoryUseCase,
) : ViewModel() {
    private val _infoOfNumber: MutableLiveData<NumberModel?> = SingleLiveEvent()
    val infoOfNumber: LiveData<NumberModel?> = _infoOfNumber

    private val _listHistory: MutableLiveData<List<NumberModel>> =
        MutableLiveData<List<NumberModel>>(emptyList())
    val listHistory: LiveData<List<NumberModel>> = _listHistory


    fun requireNumberInfo(data: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val resVal = getNumberInfoUseCase.execute(data = data)
            resVal?.let { data ->
                saveNumberInfoUseCase.execute(data)
            }
            _infoOfNumber.postValue(resVal)
        }
    }

    fun getListHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            val resVal = getListHistoryUseCase.execute()
            _listHistory.postValue(resVal)
        }
    }
}