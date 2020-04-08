package br.com.tembici.architecture.usage.activity

import androidx.lifecycle.ViewModelProvider
import br.com.tembici.architecture.R
import br.com.tembici.architecture.databinding.ActivityMainBinding
import br.com.tembici.architecture.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override fun getViewModel() = ViewModelProvider(this).get(MainActivityViewModel::class.java)

    override fun getLayoutId() = R.layout.activity_main
}