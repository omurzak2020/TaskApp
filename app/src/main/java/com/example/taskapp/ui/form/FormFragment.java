package com.example.taskapp.ui.form;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taskapp.MainActivity;
import com.example.taskapp.R;


public class FormFragment extends Fragment {
    
    private Button button;
    private EditText editText;
    
    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.btnsave);
        editText = view.findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String text =editText.getText().toString();
        Log.e("FormFragment", "onClick: hello hello "+text);
        Toast.makeText(getContext(), "654654654", Toast.LENGTH_LONG).show();
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        getParentFragmentManager().setFragmentResult("task",bundle);
        ((MainActivity) requireActivity()).closeFragment();
    }
}
