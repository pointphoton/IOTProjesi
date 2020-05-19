package tr.edu.sakarya.e195013028.proje.ui.control;


import java.lang.annotation.Retention;

import androidx.annotation.IntDef;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static tr.edu.sakarya.e195013028.proje.ui.control.Level.CLOSE;
import static tr.edu.sakarya.e195013028.proje.ui.control.Level.DARK_INDOOR;
import static tr.edu.sakarya.e195013028.proje.ui.control.Level.INDOOR;
import static tr.edu.sakarya.e195013028.proje.ui.control.Level.NIGHT;
import static tr.edu.sakarya.e195013028.proje.ui.control.Level.OUTDOOR;

@Retention(SOURCE)
@IntDef({NIGHT, DARK_INDOOR,INDOOR,OUTDOOR,CLOSE})
public  @interface Level {
    int NIGHT = 5;
    int DARK_INDOOR = 4;
    int INDOOR=3;
    int OUTDOOR=2;
    int CLOSE=1;

}
