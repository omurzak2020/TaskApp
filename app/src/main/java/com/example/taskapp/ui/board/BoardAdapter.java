package com.example.taskapp.ui.board;

import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.taskapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();
    private ArrayList<Integer> img = new ArrayList<>();
    private static final String ARG_PARAM1 = "PARAM1";
    private static final String ARG_PARAM2 = "PARAM2";

    private String mParam1;
    private String mParam2;


    public BoardAdapter() {
        title.add("First");
        title.add("Second");
        title.add("Thout");
        desc.add("Description Description Description Description");
        desc.add("Description Description Description Description");
        desc.add("Description Description Description Description");
        img.add(R.drawable.images1);
        img.add(R.drawable.images2);
        img.add(R.drawable.images3);
    }

    @NonNull
    @Override
    public BoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pager_board,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textDesc;
        private ImageView imageView;
        public ViewPager viewPager;
        public Button button;

        public ViewHolder(@NonNull View itemView){
        super(itemView);
        textTitle = itemView.findViewById(R.id.textTitle);
        textDesc = itemView.findViewById(R.id.textDesc);
        imageView = itemView.findViewById(R.id.image);
        viewPager = itemView.findViewById(R.id.viewPager);
        button = itemView.findViewById(R.id.button1);
        }

        public void bind(int position) {
        textTitle.setText(title.get(position));
        textDesc.setText(desc.get(position));
        imageView.setImageResource(img.get(position));


        }
    }
}
