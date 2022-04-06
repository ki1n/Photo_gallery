package ru.turev.photogallery.presentation.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import ru.turev.photogallery.R
import ru.turev.photogallery.di.component.ViewModelFactory
import ru.turev.photogallery.util.exstension.hideKeyboard
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var defaultViewModelFactory: ViewModelFactory

    private var progressDialog: Dialog? = null

    protected val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(getViewModelClass())
    }

    override fun androidInjector() = androidInjector

    protected open val viewModelFactory: ViewModelProvider.Factory
        get() = defaultViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog()

        subscribe(viewModel.loadingLiveData, ::showLoading)
    }

    override fun onPause() {
        hideKeyboard()
        super.onPause()
    }

    open fun showLoading(isVisible: Boolean) {
        if (isVisible) {
            progressDialog?.show()
        } else {
            progressDialog?.dismiss()
        }
    }

    open fun showError(message: String) = showSnackbarMessage(message)

    open fun showError(@StringRes message: Int) = showSnackbarMessage(message)

    open fun showSnackbarMessage(message: String) {
        if (isVisible && message.isNotEmpty()) {
            Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
        }
    }

    open fun showSnackbarMessage(@StringRes message: Int) {
        if (isVisible) {
            Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun progressDialog() {
        progressDialog = Dialog(requireContext()).apply {
            val inflate =
                LayoutInflater.from(requireContext()).inflate(R.layout.layout_progress, null)
            setContentView(inflate)
            setCancelable(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    protected fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    protected fun <T> subscribe(liveData: LiveData<T>, onNext: (t: T) -> Unit) {
        liveData.observe(viewLifecycleOwner) {
            onNext(it)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass() =
        (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>
}
