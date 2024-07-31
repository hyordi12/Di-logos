package com.example.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogFragment extends DialogFragment {

    public interface ConfirmDialogListener {
        void onConfirmDialogResponse(boolean isConfirmed);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppTheme_Dialog);
        builder.setMessage(R.string.dialog_confirm_message)
                .setPositiveButton(R.string.dialog_confirm_positive, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConfirmDialogListener listener = (ConfirmDialogListener) getActivity();
                        if (listener != null) {
                            listener.onConfirmDialogResponse(true);
                        }
                    }
                })
                .setNegativeButton(R.string.dialog_confirm_negative, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConfirmDialogListener listener = (ConfirmDialogListener) getActivity();
                        if (listener != null) {
                            listener.onConfirmDialogResponse(false);
                        }
                    }
                });


        return builder.create();
    }
}
