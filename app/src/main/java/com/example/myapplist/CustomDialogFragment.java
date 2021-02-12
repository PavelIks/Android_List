package com.example.myapplist;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment
{
    private Removable removable;
    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        removable = (Removable)context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInst)
    {
        final String product = getArguments().getString("test_key");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("Зацени!")
                .setMessage("Выбран фрукт " + product)
                .setIcon(R.drawable.ic_launcher_background)
                .setNegativeButton("Удалить!", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        removable.remove(product);
                        Toast.makeText(getContext(), "Удалён!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Оставить!", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getContext(), "=)", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();

    }
}