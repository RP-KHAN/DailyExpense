package com.example.dealyexpenses;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrameADDDailyExp extends Fragment {
    Context context;

    public FrameADDDailyExp(){}
   /* public FrameADDDailyExp(Context context){
        this.context = context;
    }*/
    TextView meal_Click,view_sum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frame__a_d_d__daily_expences, container, false);
        context = view.getContext();

        meal_Click = view.findViewById(R.id.meal_id);

       meal_Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Dialog Box where we put meals amount
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.mealadd);    // getting the layout of the dialog box
                Button addAmount = dialog.findViewById(R.id.meal_add);  // getting the button from dialog box
                EditText breakFastA,launchA,dinnerA;      // Dialog box EditText
                // get the id from dialog and set in the Editbox
                breakFastA = dialog.findViewById(R.id.break_fast);    // get the break fast id from dialog and set in the Editbox
                launchA = dialog.findViewById(R.id.launch);           // get the launch id from dialog and set in the Editbox
                dinnerA = dialog.findViewById(R.id.dinner);           // get the dinner id from dialog and set in the Editbox
                // this button is for add meal amount
                addAmount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // get the amount from edit view and set in to int
                        int breakFastAmount = Integer.parseInt(breakFastA.getText().toString());  // get break fast amount
                        int launchAmount = Integer.parseInt(launchA.getText().toString());        // get launch amount
                        int dinnerAmount = Integer.parseInt(dinnerA.getText().toString());        // get dinner amount

                        // this Intent for back to the main activity which is containing fragment
                        Intent intent = new Intent(context,FrameADDDailyExp.class);
                        // now sending all Amount details form dialog box to fragment
                        intent.putExtra("breakf",breakFastAmount);
                        intent.putExtra("launch",launchAmount);
                        intent.putExtra("dinner",dinnerAmount);
                        startActivity(intent);
                        // This is for dismiss dialog box, when user press button then automatically invisible the dialog box

                    }
                });
                dialog.show();
            }
        });
       return view;
    }

}