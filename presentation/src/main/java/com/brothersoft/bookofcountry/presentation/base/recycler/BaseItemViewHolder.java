package com.brothersoft.bookofcountry.presentation.base.recycler;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.brothersoft.bookofcountry.BR;
import com.brothersoft.domain.entity.DomainModel;

    public abstract class BaseItemViewHolder<
            Entity extends DomainModel,
            VM extends BaseItemViewModel<Entity>,
            B extends ViewDataBinding> extends RecyclerView.ViewHolder{

        private VM viewModel;
        private B binding;

        public BaseItemViewHolder(VM viewModel, B binding) {
            super(binding.getRoot());
            this.viewModel = viewModel;
            this.binding = binding;
            binding.setVariable(BR.viewModel, viewModel);
        }

        public void bindTo(Entity entity, int position){
            viewModel.setItem(entity, position);
            binding.executePendingBindings();
        }

        public VM getViewModel() {
            return viewModel;
        }

    }


