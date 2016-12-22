package nyc.c4q.dereksantos.exampractice_12_21;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.dereksantos.exampractice_12_21.backend.Flowers;

public class FlowerViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private final TextView categoryViewHolder;
    private final TextView priceViewHolder;
    private final TextView productIdViewHolder;
    private final TextView instructionsViewHolder;
    private final TextView nameViewHolder;

    public FlowerViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        categoryViewHolder = (TextView) mView.findViewById(R.id.flower_category);
        priceViewHolder = (TextView) mView.findViewById(R.id.flower_price);
        productIdViewHolder = (TextView) mView.findViewById(R.id.flower_productid);
        instructionsViewHolder = (TextView) mView.findViewById(R.id.flower_instructions);
        nameViewHolder = (TextView) mView.findViewById(R.id.flower_name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.flowers_viewholder, parent, false);
    }

    public void bind(Flowers flowers) {
        categoryViewHolder.setText(flowers.getCategory());
        priceViewHolder.setText(flowers.getPrice());
        productIdViewHolder.setText(flowers.getProductId());
        instructionsViewHolder.setText(flowers.getInstructions());
        nameViewHolder.setText(flowers.getName());
    }
}
