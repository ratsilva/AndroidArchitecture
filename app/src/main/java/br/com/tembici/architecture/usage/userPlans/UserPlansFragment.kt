package br.com.tembici.architecture.usage.userPlans

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import br.com.tembici.architecture.BR
import br.com.tembici.architecture.R
import br.com.tembici.architecture.databinding.FragmentUserPlansBinding
import br.com.tembici.architecture.ui.base.BaseFragment

class UserPlansFragment : BaseFragment<FragmentUserPlansBinding, UserPlansViewModel>() {

    //private val params: UserPlansFragmentArgs by navArgs()

    override fun getNavigatorBinding() = BR.navigator

    override fun getViewModel() = ViewModelProvider(this).get(UserPlansViewModel::class.java)

    override fun getLayoutId() = R.layout.fragment_user_plans

    override fun getFragmentTag() = javaClass.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
            further implementation such as?
            1) Live Data observing view model
            2) Parsing args and doing stuff
            3)
         */
    }

}