package tr.edu.sakarya.e195013028.proje.ui.control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButtonToggleGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import tr.edu.sakarya.e195013028.proje.R;
import tr.edu.sakarya.e195013028.proje.databinding.FragmentControlBinding;
import tr.edu.sakarya.e195013028.proje.util.DebugLog;

public class ControlFragment extends Fragment implements ControlHandlers {

    private ControlViewModel model;
    private FragmentControlBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_control, container, false);
        binding.setHandlers(this);
        binding.setValue(3);
        binding.controlToggleGroup.addOnButtonCheckedListener(mOnButtonCheckedListener);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DebugLog.write();
        model = new ViewModelProvider(requireActivity()).get(ControlViewModel.class);
        model.getLevelResult().observe(this.getViewLifecycleOwner(), res -> {
            DebugLog.write(res);

        });
        model.getModeResult().observe(this.getViewLifecycleOwner(), res -> {
            DebugLog.write(res);
            if(res){

            }
        });
    }


    @Override
    public void onClickDec(View view, Integer val) {
        DebugLog.write();
        if (val != null) {
            binding.setValue(val - 1);
        }
    }

    @Override
    public void onClickInc(View view, Integer val) {
        DebugLog.write();
        if (val != null) {
            binding.setValue(val + 1);
        }
    }

    @Override
    public void onClickSet(View view) {
        DebugLog.write();
        model.updateLevel(binding.getValue());
    }

    private MaterialButtonToggleGroup.OnButtonCheckedListener mOnButtonCheckedListener = new MaterialButtonToggleGroup.OnButtonCheckedListener() {
        @Override
        public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {

            if (isChecked && checkedId == binding.controlTbOff.getId()) { // off
                DebugLog.write();
                binding.setIsEnabled(false);
                model.updateMode(ControlMode.AUTO);
            } else if (isChecked && checkedId == binding.controlTbOn.getId()) { //on
                DebugLog.write();
                binding.setIsEnabled(true);
                model.updateMode(ControlMode.MANUEL);
            }

        }
    };


}