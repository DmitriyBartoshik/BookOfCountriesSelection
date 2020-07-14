package com.brothersoft.bookofcountry.presentation.screens.selection.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brothersoft.bookofcountry.R;

import java.util.List;

public class FieldTypeAdapter extends RecyclerView.Adapter<FieldTypeAdapter.FieldViewHolder>  {
    public LayoutInflater inflater;
    public List<String[]> list;
    private OnItemClickListener listener;

    public FieldTypeAdapter(Context context, List<String[]> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FieldViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.field_type_list, viewGroup, false);
        return new FieldViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FieldViewHolder fieldViewHolder, int i) {
        fieldViewHolder.textField.setText(list.get(i)[0]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class FieldViewHolder extends RecyclerView.ViewHolder {
        TextView textField;

        public FieldViewHolder(@NonNull View itemView) {
            super(itemView);

            textField = itemView.findViewById(R.id.field_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}



