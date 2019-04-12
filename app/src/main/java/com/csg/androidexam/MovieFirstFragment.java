package com.csg.androidexam;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class MovieFirstFragment extends Fragment {

    private Model mMovie;

    public MovieFirstFragment() {
    }

    public static MovieFirstFragment newInstance(Model model) {
        MovieFirstFragment fragment = new MovieFirstFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", model);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMovie = getArguments().getParcelable("movie");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_exam, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView movieImageView = view.findViewById(R.id.image_movie);
        TextView movieTextTitle = view.findViewById(R.id.text_movie_title);
        Button movieDetailButton = view.findViewById(R.id.btn_detail);

        Glide.with(this)
                .load(mMovie.getUrl())
                .into(movieImageView);

        movieTextTitle.setText(mMovie.getTitle());

        movieDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "" + mMovie.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
