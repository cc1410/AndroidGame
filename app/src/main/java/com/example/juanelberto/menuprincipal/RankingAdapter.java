package com.example.juanelberto.menuprincipal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juanelberto.menuprincipal.model.Data;
import com.example.juanelberto.menuprincipal.model.RankingResponse;
import com.example.juanelberto.menuprincipal.model.RankingUser;
import com.example.juanelberto.menuprincipal.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by chen on 14/02/2018.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private RankingResponse rankingResponse;

    public RankingAdapter(RankingResponse rankingResponse){
        super();
        this.rankingResponse = rankingResponse;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView username, points, position, gameName, gameDescription;
        ImageView avatar, gameImage;
        public ViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.gameName);
            points = itemView.findViewById(R.id.points);
            avatar = itemView.findViewById(R.id.gameIcon);
            position = itemView.findViewById(R.id.position);
            //gameName = itemView.findViewById(R.id.gameName);
            //gameDescription = itemView.findViewById(R.id.gameDescription);
            //gameImage = itemView.findViewById(R.id.gameImage);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(rankingResponse == null) return;
        RankingUser rData = rankingResponse.getData().getRanking().get(position);
        Data data = rankingResponse.getData();
        User user = data.getRanking().get(position).getUser();

        String username = user.getUsername();
        String userPoints = String.valueOf(data.getRanking().get(position).getScore());

        holder.username.setText(username);
        holder.points.setText(userPoints);
        holder.position.setText(String.valueOf(position+1));
        Context context = holder.avatar.getContext();
        Picasso.with(context).load(rData.getUser().getAvatar_path()).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        if(rankingResponse == null) return 0;
        return rankingResponse.getData().getRanking().size();
    }

}
