package com.sg.hackamu.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sg.hackamu.ChatActivity;
import com.sg.hackamu.R;
import com.sg.hackamu.databinding.AllconnectionsListItemBinding;
import com.sg.hackamu.models.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.AllConnectionsViewHolder> {
    private Context context;
    private ArrayList<User> users;

    public StudentsAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public AllConnectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AllconnectionsListItemBinding allconnectionsListItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.allconnections_list_item,parent,false);
        return new AllConnectionsViewHolder(allconnectionsListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllConnectionsViewHolder holder, int position) {
        holder.allconnectionsListItemBinding.setUser(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users==null?0:users.size();
    }

    public class AllConnectionsViewHolder extends RecyclerView.ViewHolder
    {
        private AllconnectionsListItemBinding allconnectionsListItemBinding;
        public AllConnectionsViewHolder(@NonNull final AllconnectionsListItemBinding allconnectionsListItemBinding) {
            super(allconnectionsListItemBinding.getRoot());
            this.allconnectionsListItemBinding=allconnectionsListItemBinding;
            allconnectionsListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    Intent i=new Intent(context, ChatActivity.class);
                    i.putExtra("user",users.get(pos));
                    context.startActivity(i);
                }
            });
        }
    }
}
