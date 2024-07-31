package com.example.dialogos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements ConfirmDialogFragment.ConfirmDialogListener, RegistrationDialogFragment.RegisterDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmButton = findViewById(R.id.button_confirm);
        Button registerButton = findViewById(R.id.button_register);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment confirmDialog = new ConfirmDialogFragment();
                confirmDialog.show(getSupportFragmentManager(), "ConfirmDialog");
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment registerDialog = new RegistrationDialogFragment();
                registerDialog.show(getSupportFragmentManager(), "RegisterDialog");
            }
        });
    }

    @Override
    public void onConfirmDialogResponse(boolean isConfirmed) {
        String message = isConfirmed ? getString(R.string.option_yes) : getString(R.string.option_no);
        showSnackbar(message);
    }

    @Override
    public void onRegisterDialogResponse() {
        showSnackbar(getString(R.string.registration_done));
    }

    private void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
}
