package br.com.tembici.architecture.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import br.com.tembici.architecture.utils.navigation.EventNav
import br.com.tembici.architecture.utils.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    private var isLoading = ObservableBoolean()

    private val _navigation = MutableLiveData<EventNav<NavigationCommand>>()
    val navigation: LiveData<EventNav<NavigationCommand>> = _navigation

    abstract fun getViewModelTag(): String

    fun navigateTo(directions: NavDirections) {
        _navigation.value = EventNav(NavigationCommand.To(directions))
    }

    fun navigateBack(){
        _navigation.value = EventNav(NavigationCommand.Back)
    }

    // A pattern for loading screen
    open fun getIsLoading() = isLoading

    open fun setIsLoading(isLoading_: Boolean) {
        isLoading.set(isLoading_)
    }

}