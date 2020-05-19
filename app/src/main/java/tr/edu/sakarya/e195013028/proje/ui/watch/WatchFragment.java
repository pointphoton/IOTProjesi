package tr.edu.sakarya.e195013028.proje.ui.watch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import tr.edu.sakarya.e195013028.proje.R;
import tr.edu.sakarya.e195013028.proje.databinding.FragmentWatchBinding;
import tr.edu.sakarya.e195013028.proje.util.DebugLog;

public class WatchFragment  extends Fragment implements WatchHandlers{

    private WatchViewModel model;
    private FragmentWatchBinding binding;
    private WatchDataAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_watch, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        binding.watchFrgRecyclerV.setLayoutManager(layoutManager);
        binding.watchFrgRecyclerV.setHasFixedSize(true);
        adapter = new WatchDataAdapter();
        binding.watchFrgRecyclerV.setAdapter(adapter);
        binding.setHandlers(this::onClickBack);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DebugLog.write();
        model = new ViewModelProvider(requireActivity()).get(WatchViewModel.class);
        model.getLightData().observe(this.getViewLifecycleOwner(), thingSpeak -> {
            if (thingSpeak!=null){
            DebugLog.write(thingSpeak.getFeeds().size());
            adapter.setFeedList(thingSpeak.getFeeds());

          }
        });
        model.callThingSpeakForLight();
    }

    @Override
    public void onClickBack(View view) {
        DebugLog.write();
        NavHostFragment.findNavController(this).navigateUp();
    }


}