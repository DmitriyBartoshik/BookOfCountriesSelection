package com.brothersoft.bookofcountry.presentation.base.recycler;

import com.brothersoft.domain.entity.DomainModel;

public abstract class BaseItemViewModel<Entity extends DomainModel> {

    public abstract void setItem(Entity entity, int position);

    public void onItemClick(){

    }
}
