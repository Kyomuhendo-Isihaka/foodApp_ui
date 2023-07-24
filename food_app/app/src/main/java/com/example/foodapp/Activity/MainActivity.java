package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.foodapp.Adapter.CategoryAdapter;
import com.example.foodapp.Adapter.FastDeliveryAdapter;
import com.example.foodapp.Domain.CategoryDomain;
import com.example.foodapp.Domain.FastDeliveryDomain;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategory, recyclerViewFastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        recyclerViewCategory();
        recyclerViewFastList();
    }

    private void recyclerViewFastList() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewFastList=findViewById(R.id.view2);
        recyclerViewFastList.setLayoutManager(linearLayoutManager);

        ArrayList<FastDeliveryDomain> fastDeliveryDomains = new ArrayList<>();
        fastDeliveryDomains.add(new FastDeliveryDomain("Cheese Bugger","fast_1",9.0,20));
        fastDeliveryDomains.add(new FastDeliveryDomain("Pepperani Pizza","fast_2",8.1,19));
        fastDeliveryDomains.add(new FastDeliveryDomain("Vegetable pizza","fast_3",9.5,15));

        adapter2=new FastDeliveryAdapter(fastDeliveryDomains);
        recyclerViewFastList.setAdapter(adapter2);
    }


    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory=findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Bugger", "cat_2"));
        categoryList.add(new CategoryDomain("Chicken", "cat_3"));
        categoryList.add(new CategoryDomain("Beef", "cat_4"));

        adapter=new CategoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter);
    }
}