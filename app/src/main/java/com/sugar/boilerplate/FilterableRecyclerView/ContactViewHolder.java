package com.sugar.boilerplate.FilterableRecyclerView;

import android.view.View;
import android.widget.TextView;

import com.burakeregar.easiestgenericrecycleradapter.base.GenericViewHolder;
import com.sugar.boilerplate.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Burak Eregar on 5.05.2017.
 */

public class ContactViewHolder extends GenericViewHolder {

    @BindView(R.id.txtTitle)
    TextView name;
    @BindView(R.id.txtBody)
    TextView surname;
    private ContactModel mItem;

    public ContactViewHolder(final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(final Object element) {
        mItem = (ContactModel) element;
        // set whatever you want. for instance;
        surname.setText(mItem.getSurname());
        name.setText(mItem.getName());
    }

    @OnClick(R.id.custom_model)
    public void onClick() {
        EventBus.getDefault().postSticky(mItem);
    }
}