package tr.edu.sakarya.e195013028.proje.ui.control;

import java.lang.annotation.Retention;

import androidx.annotation.IntDef;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static tr.edu.sakarya.e195013028.proje.ui.control.ControlMode.AUTO;
import static tr.edu.sakarya.e195013028.proje.ui.control.ControlMode.MANUEL;

@Retention(SOURCE)
@IntDef({AUTO, MANUEL})
public @interface ControlMode {
     int AUTO = 0;
     int MANUEL = 1;
}
