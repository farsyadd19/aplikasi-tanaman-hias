package com.kelompok1.aplikasitanamanhias.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kelompok1.aplikasitanamanhias.activities.DBunga;
import com.kelompok1.aplikasitanamanhias.model.ModelMain;
import com.kelompok1.tanamanhias.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelompok 1 on 2023
 */

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.MainViewHolder> implements Filterable {

    private Context context;
    private List<ModelMain> modelMainList;
    private List<ModelMain> modelMainFilterList;

    @Override
    public Filter getFilter() {
        return modelFilter;
    }

    private Filter modelFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ModelMain> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(modelMainFilterList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ModelMain modelMainFilter : modelMainFilterList) {
                    if (modelMainFilter.getNama().toLowerCase().contains(filterPattern)) {
                        filteredList.add(modelMainFilter);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            modelMainList.clear();
            modelMainList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public BuahAdapter(Context context, List<ModelMain> modelMain) {
        this.context = context;
        this.modelMainList = modelMain;
        this.modelMainFilterList = new ArrayList<>(modelMain);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bunga, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        ModelMain item = modelMainList.get(position);

        holder.tvNamaBunga.setText(item.getNama());

        //send data to detail activity
        holder.cvListBunga.setOnClickListener(view -> {
            Intent intent = new Intent(context, DBunga.class);
            intent.putExtra(DBunga.DETAIL_BUNGA, modelMainList.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return modelMainList.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        CardView cvListBunga;
        TextView tvNamaBunga;

        public MainViewHolder(View itemView) {
            super(itemView);
            cvListBunga = itemView.findViewById(R.id.cvListBunga);
            tvNamaBunga = itemView.findViewById(R.id.tvNamaBunga);
        }
    }

}
