package com.jose.park_ok_colaborador.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Historic;
import com.jose.park_ok_colaborador.view.adapters.listeners.HistoricLIstener;


import java.util.ArrayList;
import java.util.List;

import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_AMOUNT;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_APP;
import static com.jose.park_ok_colaborador.utils.Constants.FORM_OF_PAYMENT_CARD;
import static com.jose.park_ok_colaborador.utils.Utils.formatCurrency;
import static com.jose.park_ok_colaborador.utils.Utils.getDayAndMonth;
import static com.jose.park_ok_colaborador.utils.Utils.timeFormat;

public class HistoricAdapter extends RecyclerView.Adapter<HistoricAdapter.HistoricViewHolde>{

    private List<Historic> historics = new ArrayList<>();
    private Context context;
    private HistoricLIstener historicLIstener;

    public HistoricAdapter(List<Historic> historics, Context context,HistoricLIstener historicLIstener ){
        this.context = context;
        this.historics = historics;
        this.historicLIstener = historicLIstener;
    }

    @NonNull
    @Override
    public HistoricAdapter.HistoricViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_historic, parent, false);
       HistoricViewHolde historicViewHolde = new HistoricViewHolde(view);
        return historicViewHolde;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricAdapter.HistoricViewHolde holder, final int position) {
        if (historics.get(position).getTypeService() ==1){
            holder.tvTypeService.setText("Desconto");
            holder.tvDiscount.setVisibility(View.VISIBLE);
            holder.tvTotalDiscount.setVisibility(View.VISIBLE);

        }else {
            holder.tvTypeService.setText("Bônus");
            holder.tvDiscount.setVisibility(View.GONE);
            holder.tvAmountPaidHitoric.setVisibility(View.GONE);
            holder.tvFinalAmountPaid.setVisibility(View.GONE);
            holder.tvTypeOfPayment.setVisibility(View.GONE);
            holder.tvFormOfPaymentHistoric.setVisibility(View.GONE);
            holder.tvDiscount.setVisibility(View.VISIBLE);
            holder.tvDiscount.setText("valor pago");
            holder.tvTotalDiscount.setVisibility(View.VISIBLE);
        }
        holder.tvServiceDate.setText(getDayAndMonth(historics.get(position).getServiceDate(),context));
        holder.tvGrandTotal.setText(formatCurrency(context,historics.get(position).getAmount()));
        holder.tvTotalDiscount.setText(formatCurrency(context,historics.get(position).getAmountPaid()));
        holder.tvTimePermanence.setText(timeFormat(historics.get(position).getLenghtOfStay(),context));


        switch (historics.get(position).getFormOfPayment()){
            case 1 :
                holder.tvTypeOfPayment.setText(FORM_OF_PAYMENT_APP);
                break;
            case 2:
                holder.tvTypeOfPayment.setText(FORM_OF_PAYMENT_AMOUNT);
                break;
            case 3:
                holder.tvTypeOfPayment.setText(FORM_OF_PAYMENT_CARD);
        }
        holder.tvPastingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                historicLIstener.historicOnClick(historics.get(position),position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return historics.size();
    }



    class HistoricViewHolde extends RecyclerView.ViewHolder{

        TextView tvAmountPaidHitoric;
        TextView tvAmount;
        TextView tvDiscount;
        TextView tvFormOfPaymentHistoric;
        TextView tvFinalAmountPaid;
        TextView tvGrandTotal;
        TextView tvPermanence;
        TextView tvPastingHistory;
        TextView tvServiceDate;
        TextView tvTimePermanence;
        TextView tvTotalDiscount;
        TextView tvTypeOfPayment;
        TextView tvTypeService;
        TextView tvTimeServic;

        public HistoricViewHolde(@NonNull View itemView) {
            super(itemView);

            tvServiceDate = itemView.findViewById(R.id.tv_service_date);
            tvTypeService = itemView.findViewById(R.id.tv_type_service);
            tvTimeServic = itemView.findViewById(R.id.tv_time_servic);
            tvPermanence = itemView.findViewById(R.id.tv_permanence);
            tvAmount = itemView.findViewById(R.id.tv_amount);
            tvDiscount = itemView.findViewById(R.id.tv_discount);
            tvTimePermanence = itemView.findViewById(R.id.tv_time_permanence);
            tvGrandTotal = itemView.findViewById(R.id.tv_grand_total);
            tvTotalDiscount = itemView.findViewById(R.id.tv_total_discount);
            tvFormOfPaymentHistoric = itemView.findViewById(R.id.tv_form_of_payment_historic);
            tvAmountPaidHitoric = itemView.findViewById(R.id.tv_amount_paid_hitoric);
            tvTypeOfPayment = itemView.findViewById(R.id.tv_type_of_payment);
            tvFinalAmountPaid = itemView.findViewById(R.id.tv_final_amount_paid);
            tvPastingHistory = itemView.findViewById(R.id.tv_pasting_history);

        }
    }
}
