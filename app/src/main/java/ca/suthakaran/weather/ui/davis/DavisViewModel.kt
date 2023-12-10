package ca.suthakaran.weather.ui.davis

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.suthakaran.weather.data.ReposApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DavisViewModel @Inject constructor(
    private val repoApi: ReposApi
) : ViewModel() {



    private val _weatherState: MutableStateFlow<Pair<Double, String>?> = MutableStateFlow(null)
    val apiState: StateFlow<Pair<Double, String>?> = _weatherState


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading


    private val _errorState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorState: StateFlow<Boolean> = _errorState




    fun grabApiData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true // S

                val weatherData = repoApi.getRepos("Brampton,ca", "metric", "7a5c54cc510975778d1e6e164fbcfa47")

                val temperature = weatherData.main.temperature
                val weatherCondition = weatherData.weather.firstOrNull()?.main ?: ""
                _weatherState.value = temperature to weatherCondition
                _isLoading.value = false
            } catch (e: Exception) {
                _errorState.value = true
                _weatherState.value = null
                _isLoading.value = false
            }
        }
    }
}