package com.example.demo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapterDemo extends RecyclerView.Adapter<UserAdapterDemo.UserViewHolder> {
    private Context mcontext;
    private List<UserDemo2> mlistUser;
    private OnItemClickListener listener;
    public interface OnItemClickListener{
        void onItemClick(int position);

        void onClick(View view);
    }
    public void setOnItemClickListener (OnItemClickListener clickListener){
        listener = clickListener;
    }

    public UserAdapterDemo(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void setData(List<UserDemo2> list){
        this.mlistUser = list;
        notifyDataSetChanged();
    }

    public List<UserDemo2> getMlistUser() {
        return mlistUser;
    }

    public UserAdapterDemo (List<UserDemo2> mlistUser){
        this.mlistUser = mlistUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo2,parent,false);


        return new UserViewHolder(view,listener);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserDemo2 userDemo2 = mlistUser.get(position);
        if (userDemo2 == null) {
            return;
        }
        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(holder.getBindingAdapterPosition());
            }
        });
        holder.imageUser1.setImageResource(userDemo2.getResourceId());
        holder.textUser1.setText(userDemo2.getName());
    }

    @Override
    public int getItemCount() {
            if(mlistUser != null) {
            return mlistUser.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageUser1;
        private ImageView imageViewDelete;
        private TextView textUser1;
        private Button button;
        public UserViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);

            imageUser1 = itemView.findViewById(R.id.img_user1);
            textUser1 = itemView.findViewById(R.id.text_name1);
            button = itemView.findViewById(R.id.button_new);
            imageViewDelete = itemView.findViewById(R.id.img_delete);

//            imageUser2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    listener.onItemClick(getAdapterPosition());
//                }
//            });
        }

    }

}
