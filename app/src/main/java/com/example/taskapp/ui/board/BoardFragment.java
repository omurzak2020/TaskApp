package com.example.taskapp.ui.board;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;

import com.example.taskapp.R;
import com.google.android.material.tabs.TabLayout;


public class BoardFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout indicatorLay;
    BoardAdapter adapter;
    Button btn;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPager);
        indicatorLay = view.findViewById(R.id.linear);
        btn = view.findViewById(R.id.button1);
        imageView = view.findViewById(R.id.imgView);

        initView();

        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();
                    }
                });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_boardFragment_to_navigation_home);
            }
        });
        btn.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() != 2) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }else {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_boardFragment_to_navigation_home);
            }
        });

    }


    private void initView() {
        adapter = new BoardAdapter();
        viewPager.setAdapter(adapter);

    }


}