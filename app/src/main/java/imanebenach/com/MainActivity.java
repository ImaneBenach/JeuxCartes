package imanebenach.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.* ;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_card_left , iv_card_right ;
    TextView tv_score_left, tv_score_right ;
    Button b_distribuer ;
    Random r ;
    int leftScore = 0, rightScore = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setContentView(R.layout.activity_main);


        iv_card_left = (ImageView) findViewById(R.id.iv_card_left) ;
        iv_card_right= (ImageView) findViewById(R.id.iv_card_right) ;
        tv_score_left = (TextView) findViewById(R.id.tv_score_left) ;
        tv_score_right = (TextView) findViewById(R.id.tv_score_right) ;
        b_distribuer = (Button) findViewById(R.id.btn_distribuer) ;

        r = new Random() ;

        b_distribuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int leftCard = r.nextInt(13) + 2 ;
                int rightCard = r.nextInt(13) + 2 ;

                // Ajouter les images

                int leftImage = getResources().getIdentifier("card"+leftCard, "drawable", getPackageName()) ;
                iv_card_left.setImageResource(leftImage);

                int rightImage = getResources().getIdentifier("card"+rightCard, "drawable", getPackageName()) ;
                iv_card_right.setImageResource(rightImage);

                // Comparer les cartes, ajouter les points...

                if (leftCard > rightCard) {

                    leftScore++ ;
                    tv_score_left.setText(String.valueOf(leftScore));
                }

                else if (leftCard < rightCard){
                    rightScore++ ;
                    tv_score_right.setText(String.valueOf(rightScore));
                }

                else {
                    Toast.makeText(MainActivity.this, "WAR", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
