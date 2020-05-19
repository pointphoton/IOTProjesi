package tr.edu.sakarya.e195013028.proje.ui.watch;



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

public class WatchViewModel extends ViewModel {

    private ThingSpeakService mThingSpeakService;
    private final MutableLiveData<ThingSpeak> mldLightSensorData = new MutableLiveData<ThingSpeak>();

    public WatchViewModel() {
        mThingSpeakService= ThingSpeakServiceGenerator.createService(ThingSpeakService.class);
    }

    void callThingSpeakForLight() {

        Call<ThingSpeak> call = mThingSpeakService.getChannelData(20);

              call.enqueue(new Callback<ThingSpeak>() {
                @Override
                public void onResponse(Call<ThingSpeak> call, Response<ThingSpeak> response) {
                    if (response.code() == 200) {
                        DebugLog.write(response.code()+" "+Thread.currentThread().getName());
                        mldLightSensorData.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<ThingSpeak> call, Throwable t) {
                    DebugLog.write(t.getMessage());
                }
            });



    }

     LiveData<ThingSpeak> getLightData() {
        return mldLightSensorData;
    }

}
