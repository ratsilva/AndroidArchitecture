package br.com.tembici.architecture.usage.activity

import br.com.tembici.architecture.ui.base.BaseViewModel

class MainActivityViewModel : BaseViewModel() {

    override fun goBack() = navigateBack()

    override fun getViewModelTag() = javaClass.simpleName

}