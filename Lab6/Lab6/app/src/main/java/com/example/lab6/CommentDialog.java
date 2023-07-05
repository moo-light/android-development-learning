package com.example.lab6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;

public class CommentDialog extends AppCompatDialogFragment {
    private EditText etComment;
    private ExampleDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_comment,null);
        etComment = view.findViewById(R.id.edit_comment);

        AlertDialog alertDialog = builder.setView(view).setTitle("Comment")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.addComment(etComment.getText().toString());
                    }
                }).create();
        return alertDialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (ExampleDialogListener) context;
        }catch(ClassCastException ex){
            throw new ClassCastException(context.toString()+ "Must Implement ExampleDialogListener");
        }

    }

    public static AppCompatDialogFragment newInstance() {
        CommentDialog dialog = new CommentDialog();
        // If you want to pass any arguments to the dialog, you can do so here using Bundle
        return dialog;
    }
    public interface ExampleDialogListener{
        void addComment(String comment);
    }

}