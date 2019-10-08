package com.jose.park_ok_colaborador.view.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.FAQ;

import java.util.ArrayList;
import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {

    private List<FAQ> faqs = new ArrayList<>();
    private Context context;


    public FaqAdapter(List<FAQ> tutorials, Context context){
        this.faqs = tutorials;
        this.context = context;
    }



    @NonNull
    @Override
    public FaqAdapter.FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_fag, parent, false);
        FaqViewHolder faqViewHolder = new FaqViewHolder(view);

        return faqViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FaqAdapter.FaqViewHolder holder, int position) {


        holder.information.setText(faqs.get(position).getInformation());
        String text = (position + 1) + "."+ faqs.get(position ).getTopic().trim().replaceAll("\n ","");
        holder.topic.setText(text);

        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context,R.color.colorTitleTextView)), 0, 2, 0);
        ss.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                2,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        holder.topic.setText(ss);
        holder.topic.setMovementMethod(LinkMovementMethod.getInstance());

    }


    @Override
    public int getItemCount() {
        return faqs.size();
    }

    public class FaqViewHolder extends RecyclerView.ViewHolder {

        TextView topic;
        TextView information;



        public FaqViewHolder(@NonNull View itemView) {
            super(itemView);

            topic = itemView.findViewById(R.id.tv_topic);
            information = itemView.findViewById(R.id.tv_information);



        }
    }
}
