package dyslexia.titi.frag27.permainan.kuis;

import androidx.appcompat.app.AppCompatActivity;
import dyslexia.titi.frag27.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView tvScore;
    RatingBar ratingBar;
    int lastScore;
    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvScore = findViewById(R.id.tvScore);
        ratingBar = findViewById(R.id.rating);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);

        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);

        if (lastScore > best3){
            best3 = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.apply();
        }
        if (lastScore > best2){
            int temp = best2;
            best2 = lastScore;
            best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();
        }
        if (lastScore > best1){
            int temp = best1;
            best1 = lastScore;
            best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();
        }
        tvScore.setText("NILAI ANDA: " + lastScore + "\n" +
                "Nilai Terbaik 1 : " + best1 + "\n" +
                "Nilai Terbaik 2  : " + best2 + "\n" +
                "Nilai Terbaik 3  : " + best3 );
        tvScore.setTextSize(28);

        if(lastScore == 0) {ratingBar.setRating(0);}

        else {ratingBar.setRating((int) ((int) lastScore / 2));}
    }

    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), KuisActivity.class);
        startActivity(intent);
        finish();
    }
}
