package martinamagdalenajukic.ferit.hr.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener {
    @Override
    public void onNameClick(int position) {
        Log.d("onNameClick", "position "+ position);
    }

    private RecyclerView recyclerView;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerData();
        setupRecyclerView();
    }

    private void setupRecyclerView(){
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       CustomAdapter customAdapter= new CustomAdapter(dataList, this);
       recyclerView.setAdapter(customAdapter);

    }


    private void setUpRecyclerData(){
        dataList=new ArrayList<>();
        dataList.add("Ana");
        dataList.add("Ana1");
        dataList.add("Ana2");
        dataList.add("Ana3");
        dataList.add("Ana4");
        dataList.add("Ana5");
        dataList.add("Ana6");
        dataList.add("Ana7");
        dataList.add("Ana8");
        dataList.add("Ana9");
    }
}