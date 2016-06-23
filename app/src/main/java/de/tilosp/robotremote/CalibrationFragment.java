package de.tilosp.robotremote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

public class CalibrationFragment extends Fragment {

    public CalibrationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calibration, container, false);

        NumberPicker picker = (NumberPicker) view.findViewById(R.id.numberPickerLeft);
        picker.setMaxValue(90);
        picker.setMinValue(0);
        picker.setValue(45);
        picker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return Integer.toString(i - 45);
            }
        });

        picker = (NumberPicker) view.findViewById(R.id.numberPickerRight);
        picker.setMaxValue(90);
        picker.setMinValue(0);
        picker.setValue(45);
        picker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return Integer.toString(i - 45);
            }
        });

        return view;
    }
}
