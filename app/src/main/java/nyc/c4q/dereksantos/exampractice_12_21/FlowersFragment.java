package nyc.c4q.dereksantos.exampractice_12_21;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.dereksantos.exampractice_12_21.backend.Flowers;
import nyc.c4q.dereksantos.exampractice_12_21.backend.FlowersApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlowersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FlowersAdapter flowersListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flowers_layout, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.flowers_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getFlowersList();

        return view;
    }

    private void getFlowersList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://services.hanselandpetal.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FlowersApi flowersApi = retrofit.create(FlowersApi.class);

        Call<List<Flowers>> call = flowersApi.getFlowersList();

        call.enqueue(new Callback<List<Flowers>>() {
            @Override
            public void onResponse(Call<List<Flowers>> call, Response<List<Flowers>> response) {
                List<Flowers> flowersResponsesList = response.body();

                flowersListAdapter = new FlowersAdapter(flowersResponsesList);

                mRecyclerView.setAdapter(flowersListAdapter);

            }

            @Override
            public void onFailure(Call<List<Flowers>> call, Throwable t) {

            }
        });
    }


}
