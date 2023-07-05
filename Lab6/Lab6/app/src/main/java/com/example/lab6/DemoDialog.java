package com.example.lab6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DemoDialog extends AppCompatDialogFragment {
    private String[] codes = new String[]{
        "C++","C#","Java","Python","Kotlin"
    };
    private String selectedItem = "";
    private int selectedIndex = -1;
    private DemoListener listener;

    public static AppCompatDialogFragment newInstance() {
        DemoDialog dialog = new DemoDialog();

        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(android.R.layout.select_dialog_singlechoice, null);
        builder.setView(view).setSingleChoiceItems(codes, selectedIndex, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectedItem = codes[i];
                selectedIndex = i+1;

            }
        }).setPositiveButton("Select", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 listener.select(selectedItem,selectedIndex);
            }
        }).setTitle("Single Dialog");
        AlertDialog alertDialog = builder.create();
        ListView listView = alertDialog.getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        return alertDialog;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (DemoListener)  context;
        }catch(ClassCastException ex){
            throw new ClassCastException(context.toString()+ "Must Implement DemoListener");
        }
    }
    public interface DemoListener {
        void select(String selectedItem, int selectedIndex);
    }
}
