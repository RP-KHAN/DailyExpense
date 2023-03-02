package com.example.dealyexpenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    FrameLayout frameLayout;
    Button add_Button,view_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.framelayout);
        add_Button = findViewById(R.id.add_button);
        view_Button = findViewById(R.id.view_button);

        int breakFastAmount,launchAmount,dinnerAmount;

        breakFastAmount = getIntent().getIntExtra("breakf",-1);
        launchAmount = getIntent().getIntExtra("launch",-1);
        dinnerAmount = getIntent().getIntExtra("dinner",-1);
        add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    // 1st Frame
                    //instruction.putString("color","red");
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.framelayout, FrameADDDailyExp.class,null)
                            .commit();

                }
            }
        });
        view_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (savedInstanceState == null) {
                    // 1st Frame
                    //instruction.putString("color","red");
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.framelayout, FragmentViewDailyExpenses.class,null)
                            .commit();
                }
            }
        });
       // FrameADDDailyExp frame_add_dealyExp = new FrameADDDailyExp(MainActivity.this);
    }
}