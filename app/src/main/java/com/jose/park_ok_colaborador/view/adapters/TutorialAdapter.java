package com.jose.park_ok_colaborador.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Tutorial;

import java.util.ArrayList;
import java.util.List;

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.TutorialViewHolder> {

    private List<Tutorial> tutorials = new ArrayList<>();
    private Context context;




    public TutorialAdapter(List<Tutorial> tutorials, Context context){
        this.tutorials = tutorials;
        this.context = context;
    }


    /***
     *  classe que fica responsável por infla o layout
     *
     */
    @NonNull
    @Override
    public TutorialAdapter.TutorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_tutorial, parent, false);
        TutorialViewHolder tutorialViewHolder = new TutorialViewHolder(view);

        return tutorialViewHolder;

    }

    /**
     * manipulaçao dos dados para serem mostrados nos itens das listagen
     */

    @Override
    public void onBindViewHolder(@NonNull TutorialAdapter.TutorialViewHolder holder, int position) {

        switch (tutorials.get(position).getIdImage()) {
            case 1:
                holder.ivTutorial.setImageResource(R.drawable.ic_image_tutorial);
                break;

            case 2:
                holder.ivTutorial.setImageResource(R.drawable.ic_photo_tutorial);
                break;

        }
        holder.tvToturial.setText(tutorials.get(position).getInformation());

    }


    /***
     * retornando o tamanho da lista
     *
     */

    @Override
    public int getItemCount() {
        return tutorials.size();
    }

    /**
     * *classe faz referência aos id dos componentes da minha view
     */
    public class TutorialViewHolder extends RecyclerView.ViewHolder {

        TextView tvToturial;
        ImageView ivTutorial;



        public TutorialViewHolder(@NonNull View itemView) {
            super(itemView);

            tvToturial = itemView.findViewById(R.id.tv_toturial);
            ivTutorial = itemView.findViewById(R.id.iv_tutorial);
        }
    }
}
