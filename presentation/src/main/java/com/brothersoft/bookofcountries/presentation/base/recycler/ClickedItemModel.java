package com.brothersoft.bookofcountries.presentation.base.recycler;

import com.brothersoft.domain.entity.DomainModel;

public class ClickedItemModel<Entity extends DomainModel> {
    private Entity entity;
    private int position;

    public ClickedItemModel(Entity entity, int position) {
        this.entity = entity;
        this.position = position;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getPosition() {
        return position;
    }
}