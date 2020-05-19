package tr.edu.sakarya.e195013028.proje.ui.control;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tr.edu.sakarya.e195013028.proje.api.ThingSpeakServiceGenerator;
import tr.edu.sakarya.e195013028.proje.api.model.ThingSpeak;
import tr.edu.sakarya.e195013028.proje.api.service.ThingSpeakService;
import tr.edu.sakarya.e195013028.proje.util.DebugLog;

public class ControlViewModel extends ViewModel {

    private ThingSpeakService mThingSpeakService;
    private final MutableLiveData<Boolean> mldUpdateLevel = new MutableLiveData<>();
    private final MutableLiveData<Boolean> mldUpdateMode = new MutableLiveData<>();

    public ControlViewModel() {
        mThingSpeakService = ThingSpeakServiceGenerator.createService(ThingSpeakService.class);
    }

    void updateLevel(@Level int val) {
        Call<ThingSpeak> call = mThingSpeakService.setChannelData(ThingSpeakServiceGenerator.API_KEY, val);

        call.enqueue(new Callback<ThingSpeak>() {
            @Override
            public void onResponse(Call<ThingSpeak> call, Response<ThingSpeak> response) {
                if (response.code() == 200) {
                    DebugLog.write(response.code() + " " + Thread.currentThread().getName());
                    mldUpdateLevel.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<ThingSpeak> call, Throwable t)
            {
                DebugLog.write(t.getMessage());
                mldUpdateLevel.setValue(false);
            }
        });
    }

    void updateMode(@ControlMode  int mode) {
        Call<ThingSpeak> call = mThingSpeakService.setMode(ThingSpeakServiceGenerator.API_KEY, mode);

        call.enqueue(new Callback<ThingSpeak>() {
            @Override
            public void onResponse(Call<ThingSpeak> call, Response<ThingSpeak> response) {
                if (response.code() == 200) {
                    DebugLog.write(response.code() + " " + Thread.currentThread().getName());
                    mldUpdateMode.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<ThingSpeak> call, Throwable t) {
                DebugLog.write(t.getMessage());
                mldUpdateLevel.setValue(false);
            }
        });

    }


    LiveData<Boolean> getLevelResult() {
        return mldUpdateLevel;
    }

    LiveData<Boolean> getModeResult() {
        return mldUpdateMode;
    }


}
