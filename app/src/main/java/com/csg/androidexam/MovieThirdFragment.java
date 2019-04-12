package com.csg.androidexam;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieThirdFragment extends Fragment {

    private RecyclerAdapter mAdapter;
    private GridLayoutManager mGridLayoutManager;
    private List<Model> modelList;

    public MovieThirdFragment() {
        // Required empty public constructor
    }

    public static MovieThirdFragment newInstance(ArrayList<Model> modelList) {
        MovieThirdFragment fragment = new MovieThirdFragment();
        Bundle args = new Bundle();
        args.putSerializable("modelList", modelList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third_exam, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            modelList = (List<Model>) getArguments().getSerializable("modelList");

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        mAdapter = new RecyclerAdapter();
        mAdapter.addItems(modelList);
        recyclerView.setAdapter(mAdapter);
        mGridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.item, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
