package br.com.tembici.architecture.usage.userPlans

import br.com.tembici.architecture.ui.base.BaseViewModel

class UserPlansViewModel : BaseViewModel(), UserPlansNavigator {

    override fun navigateToPlanDetails() = navigateTo(UserPlansFragmentDirections.showUserPlanDetailsFragment())

    override fun goBack() = navigateBack()

    init {
        fetchUserPlans()
    }

    private fun fetchUserPlans(){

        // fetch infos
        // how factory repositories?

    }

    override fun getViewModelTag() = javaClass.simpleName
}