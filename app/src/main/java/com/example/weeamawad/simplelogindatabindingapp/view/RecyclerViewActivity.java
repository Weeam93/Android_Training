package com.example.weeamawad.simplelogindatabindingapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.weeamawad.simplelogindatabindingapp.R;
import com.example.weeamawad.simplelogindatabindingapp.SectionAdapter;
import com.example.weeamawad.simplelogindatabindingapp.databinding.ActivityRecyclerViewBinding;
import com.example.weeamawad.simplelogindatabindingapp.model.Item;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SectionAdapter mAdapter;
    private List<Item> mItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        createDummyList();
        mAdapter = new SectionAdapter(mItemList);

        LinearLayoutManager rvLayoutMangager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, rvLayoutMangager.getOrientation());

        mRecyclerView = binding.customRecyclerView;
        mRecyclerView.setLayoutManager(rvLayoutMangager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }


    private void createDummyList() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        //Section 1
        mItemList.add(new Item("Liverpool", Item.SportType.SOCCER));
        mItemList.add(new Item("Chelsea", Item.SportType.SOCCER));
        mItemList.add(new Item("Manchester United", Item.SportType.SOCCER));
        mItemList.add(new Item("Arsenal", Item.SportType.SOCCER));
        mItemList.add(new Item("Barcelona", Item.SportType.SOCCER));
        mItemList.add(new Item("Real Madrid", Item.SportType.SOCCER));
        mItemList.add(new Item("Juventus", Item.SportType.SOCCER));
        mItemList.add(new Item("Roma", Item.SportType.SOCCER));
        mItemList.add(new Item("Inter Milan", Item.SportType.SOCCER));
        //Section 2
        mItemList.add(new Item("Cavaliers", Item.SportType.BASKETBALL));
        mItemList.add(new Item("Suns", Item.SportType.BASKETBALL));
        mItemList.add(new Item("Warriors", Item.SportType.BASKETBALL));
        mItemList.add(new Item("Jazz", Item.SportType.BASKETBALL));
        mItemList.add(new Item("Heat", Item.SportType.BASKETBALL));
        mItemList.add(new Item("Knicks", Item.SportType.BASKETBALL));
        //Section 3
        mItemList.add(new Item("DiamondBacks", Item.SportType.BASEBALL));
        mItemList.add(new Item("Yankees", Item.SportType.BASEBALL));
        mItemList.add(new Item("Red Sox", Item.SportType.BASEBALL));
        mItemList.add(new Item("Dodgers", Item.SportType.BASEBALL));
        mItemList.add(new Item("Angels", Item.SportType.BASEBALL));
        mItemList.add(new Item("Mets", Item.SportType.BASEBALL));


    }
}
