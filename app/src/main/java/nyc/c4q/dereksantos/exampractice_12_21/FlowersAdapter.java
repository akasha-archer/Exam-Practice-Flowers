package nyc.c4q.dereksantos.exampractice_12_21;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;

import nyc.c4q.dereksantos.exampractice_12_21.backend.Flowers;

public class FlowersAdapter extends RecyclerView.Adapter<FlowerViewHolder> {
    List<Flowers> flowersList;

    public FlowersAdapter(List<Flowers> flowersList) {
        this.flowersList = flowersList;
    }


    @Override
    public FlowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlowerViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(FlowerViewHolder holder, int position) {
        Flowers flowers = flowersList.get(position);
        holder.bind(flowers);
    }

    @Override
    public int getItemCount() {
        return flowersList.size();
    }
}
