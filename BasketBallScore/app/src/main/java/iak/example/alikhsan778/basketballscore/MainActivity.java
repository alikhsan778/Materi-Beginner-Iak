package iak.example.alikhsan778.basketballscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int mScoreTeamA,mScoreTeamB;
    TextView mTvScoreTeamA, mTvScoreTeamB;
    Button mButtonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreTeamA = 0;
        mScoreTeamB = 0;
        mTvScoreTeamA = (TextView)findViewById(R.id.tv_team_a);
        mTvScoreTeamB = (TextView)findViewById(R.id.tv_team_b);
        mButtonReset = (Button)findViewById(R.id.btn_reset);
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScoreTeamA = 0;
                mScoreTeamB = 0;
                mTvScoreTeamA.setText(String.valueOf(mScoreTeamA));
                mTvScoreTeamB.setText(String.valueOf(mScoreTeamB));
            }
        });
    }

    public void mInctreePointTeamA(View view) {
        mScoreTeamA+=3;
        mTvScoreTeamA.setText(String.valueOf(mScoreTeamA));
    }

    public void mInctwoPointTeamA(View view) {
        mScoreTeamA+=2;
        mTvScoreTeamA.setText(String.valueOf(mScoreTeamA));
    }

    public void mInconePointTeamA(View view) {
        mScoreTeamA+=1;
        mTvScoreTeamA.setText(String.valueOf(mScoreTeamA));
    }

    public void mInctreePointTeamB(View view) {
        mScoreTeamB+=3;
        mTvScoreTeamB.setText(String.valueOf(mScoreTeamB));
    }

    public void mInctwoPointTeamB(View view) {
        mScoreTeamB+=2;
        mTvScoreTeamB.setText(String.valueOf(mScoreTeamB));
    }

   /* public void mResetScore(View view) {
        mScoreTeamA = 0;
        mScoreTeamB = 0;
        mTvScoreTeamA.setText(String.valueOf(mScoreTeamA));
        mTvScoreTeamB.setText(String.valueOf(mScoreTeamB));
    }*/

    public void mInconePointTeamB(View view) {
        mScoreTeamB+=1;
        mTvScoreTeamB.setText(String.valueOf(mScoreTeamB));
    }
}
