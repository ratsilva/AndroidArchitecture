package br.com.tembici.architecture.usage.userPlans

import br.com.tembici.architecture.ui.base.BaseViewModel

class UserPlansViewModel : BaseViewModel(), UserPlansNavigator {

    init {
        fetchUserPlans()
    }

    override fun goBack() = navigateBack()

    override fun navigateToPlanDetails() = navigateTo(UserPlansFragmentDirections.showUserPlanDetailsFragment())

    override fun getViewModelTag() = javaClass.simpleName

    private fun fetchUserPlans(){

        // fetch infos
        // how factory repositories?

    }


}