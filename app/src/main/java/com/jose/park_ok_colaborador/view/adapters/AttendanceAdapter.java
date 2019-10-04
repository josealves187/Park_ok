package com.jose.park_ok_colaborador.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;
import com.jose.park_ok_colaborador.view.adapters.listeners.AttendenceListener;

import java.util.ArrayList;
import java.util.List;

import static com.jose.park_ok_colaborador.utils.MaskTextView.boad;
import static com.jose.park_ok_colaborador.utils.MaskTextView.cpf;
import static com.jose.park_ok_colaborador.utils.Utils.formatCurrency;
import static com.jose.park_ok_colaborador.utils.Utils.timeFormat;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {

    private List<Attendence> attendenceList = new ArrayList<>();
    private Context context;
    private AttendenceListener attendenceListener;


    public AttendanceAdapter(List<Attendence> attendenceList, Context context, AttendenceListener attendenceListener) {
        this.attendenceList = attendenceList;
        this.context = context;
        this.attendenceListener = attendenceListener;
    }

    /***
     *  classe que fica responsável por infla o layout
     *
     */

    @NonNull
    @Override
    public AttendanceAdapter.AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_attendance, parent, false);
        AttendanceViewHolder attendanceViewHolder = new AttendanceViewHolder(view);

        return attendanceViewHolder;
    }

    /**
     * manipulaçao dos dados para serem mostrados nos itens das listagen
     */
    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.AttendanceViewHolder holder, final int position) {

        switch (attendenceList.get(position).getTypeVehicle()) {
            case 1:
                holder.ivCardAttendance.setImageResource(R.drawable.ic_car);
                holder.tvPartialAmount.setText(context.getString(R.string.
                        partial_amount, formatCurrency(context, attendenceList.get(position).getValue())));
                holder.tvName.setText(attendenceList.get(position).getNameUser());
                break;

            case 2:
                holder.ivBoard.setImageResource(R.drawable.board);
                holder.tvPartialAmount.setText(context.getString(R.string.
                        partial_amount, formatCurrency(context, attendenceList.get(position).getValue())));
                holder.tvName.setText(attendenceList.get(position).getNameUser());
                break;

            case 3:
                holder.ivCardAttendance.setImageResource(R.drawable.ic_gift);
                holder.ivCardAttendance.setVisibility(View.VISIBLE);
                holder.tvCpf.setVisibility(View.VISIBLE);
                holder.tvPartialAmount.setText("Tempo tolerância");
                holder.tvPartialAmount.setVisibility(View.VISIBLE);
                holder.ivBoard.setVisibility(View.GONE);
                holder.tvBoardCard.setVisibility(View.GONE);
                holder.tvName.setText(attendenceList.get(position).getNameUser());
                holder.tvName.setText("Everton");
                holder.tvName.setVisibility(View.VISIBLE);


                break;

            case 4:
                holder.ivCardAttendance.setImageResource(R.drawable.ic_motorcycle);
                holder.tvPartialAmount.setText(context.getString(R.string.
                        partial_amount, formatCurrency(context, attendenceList.get(position).getValue())));
                holder.tvName.setText(attendenceList.get(position).getNameUser());
                break;

            case 5:
                holder.ivCardAttendance.setImageResource(R.drawable.ic_bigcar);
                holder.tvPartialAmount.setText(context.getString(R.string.
                        partial_amount, formatCurrency(context, attendenceList.get(position).getValue())));
                holder.tvName.setText(attendenceList.get(position).getNameUser());
                break;
        }


        holder.tvCpf.setText(cpf(attendenceList.get(position).getCpf()));
        holder.tvBoardCard.setText(boad(attendenceList.get(position).getNumberBoard()));
        holder.tvInputAdapterAttendance.setText(context.getString(R.string.input_time_attendance,
                timeFormat(attendenceList.get(position).getDateHour(), context)));

        switch (attendenceList.get(position).getTypeAttendance()) {
            case 1:
                holder.endService.setText("SAÍDA SEM QR-CODE");
                attendanceOnClickSemQR(holder, position);
                holder.vAttendance.setVisibility(View.GONE);
                break;
            case 2:
                holder.endService.setText("CANCELAR");
                callingOnClick(holder, position);
                holder.vAttendance.setVisibility(View.GONE);
                break;

            case 3:
                holder.endService.setText("");
                holder.vAttendance.setVisibility(View.VISIBLE);
                holder.endService.setVisibility(View.GONE);
                break;
        }

    }

    private void callingOnClick(@NonNull AttendanceViewHolder holder, final int position) {
        holder.endService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendenceListener.attendanceOnClick(attendenceList.get(position), position);
            }
        });
    }

    private void attendanceOnClickSemQR(@NonNull AttendanceViewHolder holder, final int position) {
        holder.endService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendenceListener.attendanceOnClickSemQR(attendenceList.get(position), position);
            }
        });
    }

    /***
     * retornando o tamanho da lista
     *
     */
    @Override
    public int getItemCount() {
        return attendenceList.size();
    }

    class AttendanceViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBoard;
        TextView tvBoardCard;
        ImageView ivCardAttendance;
        TextView tvChange;
        TextView tvCpf;
        MaterialButton endService;
        TextView tvInputAdapterAttendance;
        TextView tvName;
        TextView tvPartialAmount;
        View vAttendance;

        /**
         * *classe faz referência aos id dos componentes da minha view
         */
        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCardAttendance = itemView.findViewById(R.id.iv_card_attendance);
            vAttendance = itemView.findViewById(R.id.v_attendance);
            ivBoard = itemView.findViewById(R.id.iv_board);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCpf = itemView.findViewById(R.id.tv_cpf);
            tvChange = itemView.findViewById(R.id.tv_change);
            tvBoardCard = itemView.findViewById(R.id.tv_board_card);
            tvInputAdapterAttendance = itemView.findViewById(R.id.tv_Input_adapter_attendance);
            tvPartialAmount = itemView.findViewById(R.id.tv_partial_amount);
            endService = itemView.findViewById(R.id.btn_end_servicer);
        }
    }
}
