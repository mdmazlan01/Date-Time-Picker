package com.mdmazlan.datetimepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        mListener.onTimeSet(timePicker, i, i1);

    }

    public interface TimePickerListener {
        void onTimeSet(TimePicker timePicker, int hour, int minute);
    }
    TimePickerListener mListener;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (TimePickerListener) context;
        } catch (Exception e) {
            throw new ClassCastException(getActivity().toString() + " must implements TimePickerListener");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getContext()));
    }
}
