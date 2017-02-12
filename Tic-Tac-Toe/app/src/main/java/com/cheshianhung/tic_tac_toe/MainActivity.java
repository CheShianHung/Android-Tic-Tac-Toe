package com.cheshianhung.tic_tac_toe;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    protected int[] statusAry = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    protected int handNum = 0;
    protected int round = 0;
    protected int count = 0;
    protected boolean finished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        round = 0;
        variableInit();

        textInit();
        imageInit();
    }

    public void slot(View view){

//        Log.i("Info", getResources().getResourceEntryName(view.getId()).replace("slot",""));

        int id = Integer.parseInt(getResources().getResourceEntryName(view.getId()).replace("slot",""));

        if (count < 9 && statusAry[id - 1] == 0 && !finished) {

            setImage(view, id);
            finished = checkWin(handNum % 2 + 1);
            setText();

            handNum ++;
            count++;
        }
    }

    protected void setImage(View view, int id) {

        ImageView img = (ImageView) view;

        if (handNum % 2 == 1) {
            img.setImageResource(R.drawable.hand_drawn_x);
            img.animate().scaleX(0.5f).scaleY(0.5f).rotation(10f).setDuration(500);
        } else {
            img.setImageResource(R.drawable.circle);
            img.animate().scaleX(0.5f).scaleY(0.5f).rotation(10f).setDuration(500);
        }

        statusAry[id - 1] = handNum % 2 + 1;
        img.setAlpha(1f);

    }

    protected void setText(){

        TextView des = (TextView) findViewById(R.id.status);
        if(finished && handNum % 2 ==0)
            des.setText(R.string.circleWins);
        else if(finished)
            des.setText(R.string.xWins);
        else if(count == 8)
            des.setText(R.string.duel);
        else if (handNum % 2 == 0)
            des.setText(R.string.xTurn);
        else
            des.setText(R.string.circleTurn);

    }

    protected boolean checkWin(int hand){

        boolean win = false;

        if(statusAry[0] == hand && statusAry[3] == hand && statusAry[6] == hand)
            win = true;
        else if(statusAry[1] == hand && statusAry[4] == hand && statusAry[7] == hand)
            win = true;
        else if(statusAry[2] == hand && statusAry[5] == hand && statusAry[8] == hand)
            win = true;
        else if(statusAry[0] == hand && statusAry[4] == hand && statusAry[8] == hand)
            win = true;
        else if(statusAry[0] == hand && statusAry[1] == hand && statusAry[2] == hand)
            win = true;
        else if(statusAry[3] == hand && statusAry[4] == hand && statusAry[5] == hand)
            win = true;
        else if(statusAry[6] == hand && statusAry[7] == hand && statusAry[8] == hand)
            win = true;
        else if(statusAry[2] == hand && statusAry[4] == hand && statusAry[6] == hand)
            win = true;

        return win;

    }

    public void reset(View view){

        round++;
        variableInit();

        imageInit();
        textInit();

    }

    protected void variableInit(){

        count = 0;
        handNum = round;
        finished = false;
        statusAry = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    protected void imageInit(){

        ImageView slot1 = (ImageView) findViewById(R.id.slot1);
        ImageView slot2 = (ImageView) findViewById(R.id.slot2);
        ImageView slot3 = (ImageView) findViewById(R.id.slot3);
        ImageView slot4 = (ImageView) findViewById(R.id.slot4);
        ImageView slot5 = (ImageView) findViewById(R.id.slot5);
        ImageView slot6 = (ImageView) findViewById(R.id.slot6);
        ImageView slot7 = (ImageView) findViewById(R.id.slot7);
        ImageView slot8 = (ImageView) findViewById(R.id.slot8);
        ImageView slot9 = (ImageView) findViewById(R.id.slot9);

        slot1.setAlpha(0f);
        slot2.setAlpha(0f);
        slot3.setAlpha(0f);
        slot4.setAlpha(0f);
        slot5.setAlpha(0f);
        slot6.setAlpha(0f);
        slot7.setAlpha(0f);
        slot8.setAlpha(0f);
        slot9.setAlpha(0f);

        slot1.setScaleX(1f);
        slot1.setScaleY(1f);
        slot2.setScaleX(1f);
        slot2.setScaleY(1f);
        slot3.setScaleX(1f);
        slot3.setScaleY(1f);
        slot4.setScaleX(1f);
        slot4.setScaleY(1f);
        slot5.setScaleX(1f);
        slot5.setScaleY(1f);
        slot6.setScaleX(1f);
        slot6.setScaleY(1f);
        slot7.setScaleX(1f);
        slot7.setScaleY(1f);
        slot8.setScaleX(1f);
        slot8.setScaleY(1f);
        slot9.setScaleX(1f);
        slot9.setScaleY(1f);

    }

    protected void textInit() {

        TextView des = (TextView) findViewById(R.id.status);

        if(round % 2 == 0)
            des.setText(R.string.circleFirst);
        else
            des.setText(R.string.xFirst);

    }
}
