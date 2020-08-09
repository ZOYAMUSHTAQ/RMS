package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.Orderviewholder>{
    ArrayList<Cart> data=new ArrayList<>();
    public OrderAdapter(ArrayList<Cart> data)
    {this.data=data;}
    @NonNull
    @Override
    public Orderviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.cart_item,parent,false);

        return new Orderviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Orderviewholder holder, int position) {
        Cart x=data.get(position);
        holder.tv1.setText(x.dish_name);
        holder.tv2.setText(x.dish_price);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public ArrayList<Cart> getData() {
        return data;
    }

    public  class Orderviewholder extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
        Button b;
        public Orderviewholder(@NonNull View itemView) {
            super(itemView);
            tv1=(TextView)itemView.findViewById(R.id.tv1);
            tv2=(TextView)itemView.findViewById(R.id.textView);
            tv3=(TextView)itemView.findViewById(R.id.tv3);
            b=(Button) itemView.findViewById(R.id.btnremove);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    removeAt(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(),data.size());
                }
            });

        }
        public void removeAt(int position)
        {for (int i=0;i<data.size();i++)
        {if (i==position)
        {
            data.remove(i);
        }
        }
        }

    }}

