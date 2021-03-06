package com.brothersoft.bookofcountry.presentation.base;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.Nullable;
 import com.brothersoft.bookofcountry.BR;


public abstract class BaseMvvmActivity<
        VM extends BaseViewModel,
        B extends ViewDataBinding,
        R extends BaseRouter>
        extends BaseActivity {

    protected VM viewModel;
    protected B binding;
    protected R router;

    /**
     * Use ViewModelProviders.of(this).get(ViewModel.class);
     */
    protected abstract VM provideViewModel();

    protected abstract int provideLayoutId();

    protected abstract R provideRouter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = provideViewModel();

        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        binding.setVariable(BR.viewModel, viewModel);

        router = provideRouter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.addRouter(router);
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.removeRouter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }
}
