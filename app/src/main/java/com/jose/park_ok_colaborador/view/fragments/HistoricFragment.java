package com.jose.park_ok_colaborador.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Historic;
import com.jose.park_ok_colaborador.view.activities.DiscountDetailsActivity;
import com.jose.park_ok_colaborador.view.adapters.HistoricAdapter;
import com.jose.park_ok_colaborador.view.adapters.listeners.HistoricLIstener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jose.park_ok_colaborador.utils.Constants.HISTORIC;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricFragment extends Fragment implements HistoricLIstener {

    private RecyclerView rvHistoric;

    public HistoricFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historic, container, false);


        rvHistoric = view.findViewById(R.id.rv_historic);
        List<Historic> historics = new ArrayList<>();

        historics.add(new Historic(1, 1, new Date(2), 15, 13, new Date(), 1, "Pedro", new Date(), new Date(), "fsd5845", "14214852398", 2));
        historics.add(new Historic(2, 2, new Date(3), 16, 14, new Date(), 2, "Mari", new Date(), new Date(), "sff5845", "78947123581", 2));
        historics.add(new Historic(2, 1, new Date(4), 17, 15, new Date(), 3, "Jose", new Date(), new Date(), "fgv5845", "78945614839", 2));
        historics.add(new Historic(4, 2, new Date(5), 18, 16, new Date(), 1, "Davi", new Date(), new Date(), "fgv5845", "74826614578", 2));
        historics.add(new Historic(5, 1, new Date(6), 19, 17, new Date(), 2, "Ze", new Date(), new Date(), "gvs5845", "14792536528", 2));
        rvHistoric.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHistoric.setAdapter(new HistoricAdapter(historics, getContext(), this));
        return view;
    }


    @Override
    public void historicOnClick(Historic historic, int position) {
        Intent intent = new Intent(getContext(), DiscountDetailsActivity.class);
        intent.putExtra(HISTORIC, historic);
        startActivity(intent);

    }


}
