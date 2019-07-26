package com.sugar.boilerplate.FilterableRecyclerView;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import com.burakeregar.easiestgenericrecycleradapter.base.GenericAdapterBuilder;
import com.burakeregar.easiestgenericrecycleradapter.base.GenericRecyclerAdapter;
import com.sugar.boilerplate.R;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FiterMainActivity extends BaseActivity {

    @BindView(R.id.main_rv)
    RecyclerView mMainRv;
    @BindView(R.id.etSearch)
    EditText etSearch;
    GenericRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filterable_activity_main);
        ButterKnife.bind(this);
        initAdapter();
        ArrayList<ContactModel> mList = createDummyData();

        mAdapter.setList(mList);
    }

    private void initAdapter() {
        mMainRv.setLayoutManager(new LinearLayoutManager(this)); //set your layout manager
        mAdapter = new GenericAdapterBuilder().addModel(
                R.layout.custom_model, //set your row's layout file
                ContactViewHolder.class, //set your view holder class
                ContactModel.class) // set your model class(If you use just String list, it can be just String.class)
                .setFilterEnabled()
                .execute();
        mMainRv.setAdapter(mAdapter);


        mAdapter.setFilter(new SearchFilter(mAdapter));


        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged( CharSequence s,int start,int count,int after ) {

            }

            @Override
            public void onTextChanged( CharSequence s,int start,int before,int count ) {

                mAdapter.getFilter().filter(s.toString(), new Filter.FilterListener() {
                    @Override
                    public void onFilterComplete(int pI) {

                        Toast.makeText(FiterMainActivity.this,""+pI,Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void afterTextChanged( Editable s ) {

            }
        });




    }

    @Subscribe
    public void onRowClicked(ContactModel pModel) {
        Toast.makeText(this, "Name: " + pModel.getName() + " Surname: " + pModel.getSurname(), Toast.LENGTH_SHORT).show();
    }

    private ArrayList<ContactModel> createDummyData() {
        ArrayList<ContactModel> lList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            lList.add(new ContactModel("Name" + i, "Surname" + i));
        }
        return lList;
    }


    public class SearchFilter extends Filter {

        private GenericRecyclerAdapter mAdapter;

        public SearchFilter(GenericRecyclerAdapter pAdapter) {
            mAdapter = pAdapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();

            final List<Object> list = mAdapter.mOriginalObjectList;

            final ArrayList<Object> filteredList = new ArrayList<>();

            String filterableString = "";

            for (Object lModel : list) {
                if (lModel instanceof ContactModel) {
                    filterableString = ((ContactModel) lModel).getName();
                }
                if (filterableString.contains(constraint.toString())) {
                    filteredList.add(lModel);
                }
            }

            results.values = filteredList;
            results.count = filteredList.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mAdapter.mObjectList = (List<Object>) results.values;
            mAdapter.notifyDataSetChanged();
        }
    }
}
