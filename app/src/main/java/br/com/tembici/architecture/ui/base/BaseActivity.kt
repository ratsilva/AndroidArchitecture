package br.com.tembici.architecture.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity()  {

    private lateinit var binding: T
    private lateinit var viewModel: V

    abstract fun getViewModel(): V
    @LayoutRes abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = getViewModel()
        binding.executePendingBindings()
    }
}