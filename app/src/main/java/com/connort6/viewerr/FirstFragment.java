package com.connort6.viewerr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.connort6.viewerr.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt = binding.button;

        NavController navController = Navigation.findNavController(view);
        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(requireActivity(),
                (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory
                        .getInstance(requireActivity().getApplication())).get(MainActivityViewModel.class);

        mainActivityViewModel.getDataList1().observe(getViewLifecycleOwner(), dataList -> {
            DataModel model = dataList.get(0);
            // gets the first datalist and then changes index 0 num value to 0.0 default 555.55
            model.setNum(0.0);
            navController.navigate(R.id.action_firstFragment_to_secondFragment);
        });

        bt.setOnClickListener(v -> {
            mainActivityViewModel.load();
        });
    }
}