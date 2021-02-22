package tk.kunalgohire.tik_toy_game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void butclick(View view){
        Button select=(Button)view;
        int cellID=0;
        switch (select.getId()){
            case R.id.button1:
                cellID=1;
                break;
            case R.id.button2:
                cellID=2;
                break;
            case R.id.button3:
                cellID=3;
                break;
            case R.id.button4:
                cellID=4;
                break;
            case R.id.button5:
                cellID=5;
                break;
            case R.id.button6:
                cellID=6;
                break;
            case R.id.button7:
                cellID=7;
                break;
            case R.id.button8:
                cellID=8;
                break;
            case R.id.button9:
                cellID=9;
                break;
        }
        playgame(cellID,select);
    }
    int ActivePlayer=1;
    int count=0,tcount=0;

    ArrayList<Integer>Player1=new ArrayList<Integer>();
    ArrayList<Integer>Player2=new ArrayList<Integer>();
    void playgame(int cellID,Button select){
        if(ActivePlayer==1){
            select.setText("X");
            select.setBackgroundColor(Color.RED);
            Player1.add(cellID);
            ActivePlayer=2;
            if(count!=4) {
                autoplay();
            }
            checkwinner();
        }
        else if(ActivePlayer==2){
            select.setText("O");
            select.setBackgroundColor(Color.GREEN);
            Player2.add(cellID);
            ActivePlayer=1;
            checkwinner();
        }
        select.setEnabled(false);
    }
    void  checkwinner(){
        tcount++;
        int winner=-1;
        if(Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3)){
            winner=1;
        }
        else if(Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6)){
            winner=1;
        }
        else if(Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9)){
            winner=1;
        }
        else if(Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7)){
            winner=1;
        }
        else if(Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8)){
            winner=1;
        }
        else if(Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9)){
            winner=1;
        }
        else if(Player1.contains(1)&&Player1.contains(5)&&Player1.contains(9)){
            winner=1;
        }
        else if(Player1.contains(3)&&Player1.contains(5)&&Player1.contains(7)){
            winner=1;
        }
        else if(Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3)){
            winner=2;
        }
        else if(Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6)){
            winner=2;
        }
        else if(Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9)){
            winner=2;
        }
        else if(Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7)){
            winner=2;
        }
        else if(Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8)){
            winner=2;
        }
        else if(Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9)){
            winner=2;
        }
        else if(Player2.contains(1)&&Player2.contains(5)&&Player2.contains(9)){
            winner=2;
        }
        else if(Player2.contains(3)&&Player2.contains(5)&&Player2.contains(7)){
            winner=2;
        }

        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"Player 1 is winner: ",Toast.LENGTH_LONG).show();
                recreate();
            }
            else if(winner==2){
                Toast.makeText(this,"Player 2 is winner: ",Toast.LENGTH_LONG).show();
                recreate();
            }
        }
        else if(tcount==9){
            Toast.makeText(this,"No Winner ",Toast.LENGTH_LONG).show();
            recreate();
        }
    }
    void autoplay(){
        ArrayList<Integer>EmptyCells=new ArrayList<Integer>();
        for(int cellID=1;cellID<10;cellID++){
            if(!(Player1.contains(cellID)||Player2.contains(cellID))){
                EmptyCells.add(cellID);
            }
        }
        Random r=new Random();
        int RandIndex=r.nextInt(EmptyCells.size()-0)+0;
        int cellID=EmptyCells.get(RandIndex);
        Button select;
        switch (cellID){
            case 1:
                select=(Button)findViewById(R.id.button1);
                break;
            case 2:
                select=(Button)findViewById(R.id.button2);
                break;
            case 3:
                select=(Button)findViewById(R.id.button3);
                break;
            case 4:
                select=(Button)findViewById(R.id.button4);
                break;
            case 5:
                select=(Button)findViewById(R.id.button5);
                break;
            case 6:
                select=(Button)findViewById(R.id.button6);
                break;
            case 7:
                select=(Button)findViewById(R.id.button7);
                break;
            case 8:
                select=(Button)findViewById(R.id.button8);
                break;
            case 9:
                select=(Button)findViewById(R.id.button9);
                break;
            default:
                select=(Button)findViewById(R.id.button1);
        }
        playgame(cellID,select);
        count++;
    }
}