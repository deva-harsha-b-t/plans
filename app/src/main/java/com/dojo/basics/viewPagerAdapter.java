package com.dojo.basics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class viewPagerAdapter extends RecyclerView.Adapter<viewPagerAdapter.pageViewerHolder> {
    private Context context;
    private List<plan> plans;

    public viewPagerAdapter(Context context, List<plan> plans) {
        this.context = context;
        this.plans = plans;
    }

    @NonNull
    @Override
    public viewPagerAdapter.pageViewerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_layout,parent,false);
        return new pageViewerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewPagerAdapter.pageViewerHolder holder, int position) {
        holder.name.setText(plans.get(position).getPlanName());
        holder.price.setText(plans.get(position).getPlanPrice());
        holder.heading.setText(plans.get(position).planHeading);
        holder.image.setImageResource(plans.get(position).getReSourceID());
        if(!(plans.get(position).getFore())){
            holder.image.setBackground(AppCompatResources.getDrawable(context,R.drawable.circle_bk_blue));
            holder.root.setBackground(AppCompatResources.getDrawable(context,R.drawable.plan_yellow_bg));
            holder.name.setTextColor(context.getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return plans.size();
    }

    public class pageViewerHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView heading;
        private CircleImageView image;
        private ConstraintLayout root;
        public pageViewerHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.planName);
            price = itemView.findViewById(R.id.planPrice);
            image = itemView.findViewById(R.id.circleImageView);
            heading = itemView.findViewById(R.id.planHeading);
            root = itemView.findViewById(R.id.innerLayout);
        }
    }
}
