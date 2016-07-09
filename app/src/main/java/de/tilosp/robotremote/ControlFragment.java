package de.tilosp.robotremote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class ControlFragment extends Fragment {

    private static final int BUTTON_FORWARD = 1;
    private static final int BUTTON_BACKWARDS = 2;
    private static final int BUTTON_LEFT = 4;
    private static final int BUTTON_RIGHT = 8;

    private static final int[] LEFT_MAP = new int[16];
    private static final int[] RIGHT_MAP = new int[16];

    static {

        // forward
        LEFT_MAP[BUTTON_FORWARD] = 90;
        RIGHT_MAP[BUTTON_FORWARD] = 90;

        // forward | left
        LEFT_MAP[BUTTON_FORWARD | BUTTON_LEFT] = 0;
        RIGHT_MAP[BUTTON_FORWARD | BUTTON_LEFT] = 90;

        // forward | right
        LEFT_MAP[BUTTON_FORWARD | BUTTON_RIGHT] = 90;
        RIGHT_MAP[BUTTON_FORWARD | BUTTON_RIGHT] = 0;

        // backwards
        LEFT_MAP[BUTTON_BACKWARDS] = -90;
        RIGHT_MAP[BUTTON_BACKWARDS] = -90;

        // backwards | left
        LEFT_MAP[BUTTON_BACKWARDS | BUTTON_LEFT] = 0;
        RIGHT_MAP[BUTTON_BACKWARDS | BUTTON_LEFT] = -90;

        // backwards | right
        LEFT_MAP[BUTTON_BACKWARDS | BUTTON_RIGHT] = -90;
        RIGHT_MAP[BUTTON_BACKWARDS | BUTTON_RIGHT] = 0;

        // left
        LEFT_MAP[BUTTON_LEFT] = -90;
        RIGHT_MAP[BUTTON_LEFT] = 90;
        // right
        LEFT_MAP[BUTTON_RIGHT] = 90;
        RIGHT_MAP[BUTTON_RIGHT] = -90;
    }

    protected int button_status = 0;

    public ControlFragment() {
        // Required empty public constructor
    }

    private void updateServo() {
        ((MainActivity) getActivity()).updateServo(LEFT_MAP[button_status], RIGHT_MAP[button_status]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        Button button = (Button) view.findViewById(R.id.button_forward);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button_status |= BUTTON_FORWARD;
                    updateServo();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
                    button_status &= ~BUTTON_FORWARD;
                    updateServo();
                }
                return false;
            }
        });

        button = (Button) view.findViewById(R.id.button_backwards);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button_status |= BUTTON_BACKWARDS;
                    updateServo();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
                    button_status &= ~BUTTON_BACKWARDS;
                    updateServo();
                }
                return false;
            }
        });

        button = (Button) view.findViewById(R.id.button_left);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button_status |= BUTTON_LEFT;
                    updateServo();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
                    button_status &= ~BUTTON_LEFT;
                    updateServo();
                }
                return false;
            }
        });

        button = (Button) view.findViewById(R.id.button_right);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    button_status |= BUTTON_RIGHT;
                    updateServo();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
                    button_status &= ~BUTTON_RIGHT;
                    updateServo();
                }
                return false;
            }
        });

        return view;
    }

}
