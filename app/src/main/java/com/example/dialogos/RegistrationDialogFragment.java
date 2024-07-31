package com.example.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegistrationDialogFragment extends DialogFragment {

    public interface RegisterDialogListener {
        void onRegisterDialogResponse();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        FragmentActivity activity = requireActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AppTheme_Dialog);
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_register, null);


        final EditText nameEditText = view.findViewById(R.id.editText_name);
        final EditText ageEditText = view.findViewById(R.id.editText_age);
        final EditText emailEditText = view.findViewById(R.id.editText_email);
        final EditText phoneEditText = view.findViewById(R.id.editText_phone);

        builder.setView(view)
                .setTitle(R.string.dialog_register_title)
                .setPositiveButton(R.string.dialog_register_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        RegisterDialogListener listener = getRegisterDialogListener();
                        if (listener != null) {
                            listener.onRegisterDialogResponse();
                        }
                    }
                })
                .setNegativeButton(R.string.dialog_register_negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        showCancellationSnackbar(view);
                        RegisterDialogListener listener = getRegisterDialogListener();
                        if (listener != null) {
                            listener.onRegisterDialogResponse();
                        }
                    }
                });

        return builder.create();
    }


    private RegisterDialogListener getRegisterDialogListener() {
        if (getActivity() instanceof RegisterDialogListener) {
            return (RegisterDialogListener) getActivity();
        }
        return null;
    }


    private void showCancellationSnackbar(View view) {
        Snackbar.make(view, getString(R.string.registration_cancelled), Snackbar.LENGTH_SHORT).show();
    }
}
