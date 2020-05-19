package tr.edu.sakarya.e195013028.proje.api.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tr.edu.sakarya.e195013028.proje.api.model.ThingSpeak;
import tr.edu.sakarya.e195013028.proje.ui.control.ControlMode;
import tr.edu.sakarya.e195013028.proje.ui.control.Level;

public interface ThingSpeakService {

    @GET("/channels/1034607/feeds.json")
    Call<ThingSpeak> getChannelData(@Query("result") int count);

    @GET("/update.json")
    Call<ThingSpeak> setChannelData(@Query("api_key") String key, @Query("field2") @Level int value);

    @GET("/update.json")
    Call<ThingSpeak> setMode(@Query("api_key") String key, @Query("field3") @ControlMode int value);

}
