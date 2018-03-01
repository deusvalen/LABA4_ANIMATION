package by.bstu.fit.lyolia.laba4_animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button syncBtn;
    Button asyncBtn;
    EditText animTimeEt;
    ImageView firstPic;
    ImageView secondPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        syncBtn = (Button) findViewById(R.id.syncBtn);
        asyncBtn = (Button) findViewById(R.id.asyncBtn);
        animTimeEt = (EditText) findViewById(R.id.animTimeEt);
        firstPic = (ImageView) findViewById(R.id.imageView1);
        secondPic = (ImageView) findViewById(R.id.imageView2);

    }

    private AnimationSet createAnimation(int duration) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(duration); // 1 second

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(duration); // 1 second

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);

        return animationSet;

    }

    public void syncClick(View view) {

        if(animTimeEt.getText().toString().isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Input time!", Toast.LENGTH_SHORT).show();
        } else {
            AnimationSet set = createAnimation(Integer.valueOf(animTimeEt.getText().toString()));
            firstPic.startAnimation(set);
            secondPic.startAnimation(set);
        }

    }

    public void asyncClick(View view) throws InterruptedException {

        if(animTimeEt.getText().toString().isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Input time!", Toast.LENGTH_SHORT).show();
        } else {
            int delay = Integer.valueOf(animTimeEt.getText().toString());
            AnimationSet set = createAnimation(delay);
            firstPic.startAnimation(set);
            AnimationSet set2 = createAnimation(delay);
            set2.setStartOffset(delay);
            secondPic.startAnimation(set2);
        }

    }

}
