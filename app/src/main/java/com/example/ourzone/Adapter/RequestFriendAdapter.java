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

public class RequestFriendAdapter extends RecyclerView.Adapter<RequestFriendAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private Button dlt_button;
        private Button accept_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            dlt_button = itemView.findViewById(R.id.name);
            accept_button = itemView.findViewById(R.id.accept_btn);
        }
    }

    private Context context;
    private ArrayList<Item> items;
    private OnAcceptClickListener mListener;

    public RequestFriendAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.request_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        Glide.with(context)
                .load(item.getImage())
                .into(holder.image);
        holder.dlt_button.setText(item.getNameButtonText());

        // Delete button
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

                confirmDeleteDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                Button yesButton = confirmDeleteDialogView.findViewById(R.id.yes_btn);
                Button noButton = confirmDeleteDialogView.findViewById(R.id.no_btn);

                yesButton.setOnClickListener(v2 -> {
                    confirmDeleteDialog.dismiss();
                    // Delete
                    items.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, items.size());
                });

                noButton.setOnClickListener(v2 -> confirmDeleteDialog.dismiss());
            });
        });

        // Accept button
        holder.accept_button.setOnClickListener(v -> {
            AlertDialog.Builder acceptDialogBuilder = new AlertDialog.Builder(context);
            View acceptDialogView = LayoutInflater.from(context).inflate(R.layout.confirm_layout, null);
            acceptDialogBuilder.setView(acceptDialogView);
            AlertDialog acceptDialog = acceptDialogBuilder.create();
            acceptDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Hide the title
            acceptDialog.show();

            acceptDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            Button yesAcceptButton = acceptDialogView.findViewById(R.id.yes_btn);
            Button noAcceptButton = acceptDialogView.findViewById(R.id.no_btn);
            yesAcceptButton.setOnClickListener(view -> {
                if (mListener != null) {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        mListener.onAcceptClick(items.get(adapterPosition));
                    }
                }
                acceptDialog.dismiss();
                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, items.size());
            });
            noAcceptButton.setOnClickListener(v2 -> acceptDialog.dismiss());
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnAcceptClickListener {
        void onAcceptClick(Item item);
    }

    public void setOnAcceptClickListener(OnAcceptClickListener listener) {
        mListener = listener;
    }
}
