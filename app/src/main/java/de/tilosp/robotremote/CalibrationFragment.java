package de.tilosp.robotremote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
        picker.setMaxValue(50);
        picker.setMinValue(0);
        picker.setValue(25);
        picker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return Integer.toString(i - 25);
            }
        });
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int from, int to) {
                ((MainActivity) getActivity()).calibrateLeft = to - 25;
                ((MainActivity) getActivity()).updateServo(0, 0);
            }
        });

        picker = (NumberPicker) view.findViewById(R.id.numberPickerRight);
        picker.setMaxValue(50);
        picker.setMinValue(0);
        picker.setValue(25);
        picker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return Integer.toString(i - 25);
            }
        });
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int from, int to) {
                ((MainActivity) getActivity()).calibrateRight = to - 25;
                ((MainActivity) getActivity()).updateServo(0, 0);
            }
        });

        return view;
    }
}
