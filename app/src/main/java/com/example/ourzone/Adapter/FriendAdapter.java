package com.example.ourzone.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ourzone.Models.Item;
import com.example.ourzone.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    public void addItem(Item item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private Button dlt_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            dlt_button = itemView.findViewById(R.id.name);
        }
    }

    private Context context;
    private ArrayList<Item> items;

    public FriendAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_rows, parent, false);
        return new ViewHolder(itemView);
    }

//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Item item = items.get(position);
//        Glide.with(context)
//                .load(item.getImage())
//                .into(holder.image);
//        holder.dlt_button.setText(item.getNameButtonText());
//
//        holder.dlt_button.setOnClickListener(v -> {
//
//            View deleteDialogView = LayoutInflater.from(context).inflate(R.layout.delete_layout, null);
//            AlertDialog.Builder deleteDialogBuilder = new AlertDialog.Builder(context);
//            deleteDialogBuilder.setView(deleteDialogView);
//            AlertDialog deleteDialog = deleteDialogBuilder.create();
//            deleteDialog.show();
//
//            Button confirmDeleteButton = deleteDialogView.findViewById(R.id.delete_this);
//
//            confirmDeleteButton.setOnClickListener(view -> {
//                deleteDialog.dismiss();
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(delete_confirm_layout);
//                View v = getWindow().getDecorView();
//                v.setBackgroundResource(android.R.color.transparent);
//                View confirmDeleteDialogView = LayoutInflater.from(context).inflate(R.layout.delete_confirm_layout, null);
//                AlertDialog.Builder confirmDeleteDialogBuilder = new AlertDialog.Builder(context);
//                confirmDeleteDialogBuilder.setView(confirmDeleteDialogView);
//                AlertDialog confirmDeleteDialog = confirmDeleteDialogBuilder.create();
//                confirmDeleteDialog.show();
//
//                Button yesButton = confirmDeleteDialogView.findViewById(R.id.yes_btn);
//                Button noButton = confirmDeleteDialogView.findViewById(R.id.no_btn);
//
//                yesButton.setOnClickListener(v2 -> {
//                    confirmDeleteDialog.dismiss();
//                    // delete
//                    items.remove(position);
//                    notifyItemRemoved(position);
//                    notifyItemRangeChanged(position, items.size());
//                });
//
//                noButton.setOnClickListener(v2 -> confirmDeleteDialog.dismiss());
//            });
//        });
//    }
@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Item item = items.get(position);
    Glide.with(context)
            .load(item.getImage())
            .into(holder.image);
    holder.dlt_button.setText(item.getNameButtonText());

    holder.dlt_button.setOnClickListener(v -> {
        AlertDialog.Builder deleteDialogBuilder = new AlertDialog.Builder(context);
        View deleteDialogView = LayoutInflater.from(context).inflate(R.layout.delete_layout, null);
        deleteDialogBuilder.setView(deleteDialogView);
        AlertDialog deleteDialog = deleteDialogBuilder.create();
        Window deleteDialogWindow = deleteDialog.getWindow();
        if (deleteDialogWindow != null) {
            deleteDialogWindow.setGravity(Gravity.BOTTOM);
        }
        deleteDialog.show();

        Button confirmDeleteButton = deleteDialogView.findViewById(R.id.delete_this);

        confirmDeleteButton.setOnClickListener(view -> {
            deleteDialog.dismiss();

            AlertDialog.Builder confirmDeleteDialogBuilder = new AlertDialog.Builder(context);
            View confirmDeleteDialogView = LayoutInflater.from(context).inflate(R.layout.confirm_layout, null);
            confirmDeleteDialogBuilder.setView(confirmDeleteDialogView);
            AlertDialog confirmDeleteDialog = confirmDeleteDialogBuilder.create();
            confirmDeleteDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Hide the title
            confirmDeleteDialog.show();

            // Set the background to transparent
            confirmDeleteDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            Button yesButton = confirmDeleteDialogView.findViewById(R.id.yes_btn);
            Button noButton = confirmDeleteDialogView.findViewById(R.id.no_btn);

            yesButton.setOnClickListener(v2 -> {
                confirmDeleteDialog.dismiss();
                // Delete item from list
                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, items.size());
            });

            noButton.setOnClickListener(v2 -> confirmDeleteDialog.dismiss());
        });
    });
}

    @Override
    public int getItemCount() {
        return items.size();
    }
}
