package com.example.juanelberto.menuprincipal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juanelberto.menuprincipal.model.RankingResponse;
import com.squareup.picasso.Picasso;

public class Ranking extends AppCompatActivity implements RankingTask.OnRankingListener{
    private RecyclerView rlPlayers;
    private SwipeRefreshLayout srlPlayers;
    private ImageView gameImage;
    private TextView tvTitulo, tvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        rlPlayers = findViewById(R.id.srlPlayers);
        srlPlayers = findViewById(R.id.srlPlayers);
        tvTitulo = findViewById(R.id.gameName);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        gameImage = findViewById(R.id.imvGame);
        updateRanking(); //Iniciar Ranking
        srlPlayers.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateRanking();
            }
        });
    }
    public void updateRanking(){
        RankingTask task = new RankingTask();
        task.setOnRankingListener(this);
        task.execute();
    }

    @Override
    public void updated(RankingResponse rankingResponse) {
        srlPlayers.setRefreshing(false);
        RankingAdapter adapter = new RankingAdapter(rankingResponse);
        String gName = rankingResponse.getData().getName();
        String gDescription = rankingResponse.getData().getDescription();
        String gImage = rankingResponse.getData().getImage_path();
        tvTitulo.setText(gName);
        tvDescripcion.setText(gDescription);
        Context context = gameImage.getContext();
        Picasso.with(context).load(rankingResponse.getData().getImage_path()).into(gameImage);

        rlPlayers.setLayoutManager(new LinearLayoutManager(Ranking.this));
        rlPlayers.setItemAnimator(new DefaultItemAnimator());
        rlPlayers.setAdapter(adapter);
    }
}


