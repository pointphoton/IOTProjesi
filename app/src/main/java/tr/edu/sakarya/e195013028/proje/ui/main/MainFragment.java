package tr.edu.sakarya.e195013028.proje.ui.main;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import tr.edu.sakarya.e195013028.proje.R;
import tr.edu.sakarya.e195013028.proje.databinding.FragmentMainBinding;
import tr.edu.sakarya.e195013028.proje.util.DebugLog;

public class MainFragment extends Fragment implements MainHandlers {


    private  FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setHandlers(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DebugLog.write();
        animateBg();
    }


    @Override
    public void onClickWatch(View view) {
        DebugLog.write();
        NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_watchFragment);

    }

    @Override
    public void onClickControl(View view) {
        DebugLog.write();
        NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_controlFragment);
    }

    private void animateBg(){
        AnimationDrawable ad = (AnimationDrawable) binding.mainFrgRootView.getBackground();
        ad.setEnterFadeDuration(2000);
        ad.setExitFadeDuration(4000);
        ad.start();
    }
}