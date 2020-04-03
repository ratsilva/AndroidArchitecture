package br.com.tembici.architecture.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import br.com.tembici.architecture.utils.navigation.NavigationCommand

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    private lateinit var binding: T
    private lateinit var viewModel: V
    private var mainActivity: BaseActivity<*, *>? = null

    abstract fun getBindingVariable(): Int
    abstract fun getViewModel(): V
    @LayoutRes abstract fun getLayoutId(): Int
    abstract fun getFragmentTag(): String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            this.mainActivity = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        this.viewModel = getViewModel()
        return binding.root
    }

    override fun onDetach() {
        mainActivity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(getBindingVariable(), viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun observeNavigation() {
        viewModel.navigation.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { command ->
                when (command) {
                    is NavigationCommand.To -> NavHostFragment.findNavController(this).navigate(command.directions)
                    is NavigationCommand.Back -> NavHostFragment.findNavController(this).navigateUp()
                }
            }
        })
    }

}