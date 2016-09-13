package dream.jugg.com.valueanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 参考郭霖大神的属性动画写出来的。
 */
public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView= (TextView) findViewById(R.id.mTextView);
        mButton= (Button) findViewById(R.id.myButton);
     /*   ImageView imageView=new ImageView(this);

        ValueAnimator animator=ValueAnimator.ofInt(0,100);
        animator.setDuration(800);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int current= (int)animation.getAnimatedValue();
                Log.v("TAG",current+"");
            }
        });
        animator.start();*/
        /**
         * "rotation"旋转，"alpha"渐变，
         * "translationX"横向平移,"translationY"纵向平移
         * "scaleX 横向拉伸倍数,"scaleY" 纵向拉伸倍数
         */
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ObjectAnimator animator=ObjectAnimator.ofFloat(mTextView,"alpha",2f,0f.2f);
                //ObjectAnimator animator=ObjectAnimator.ofFloat(mTextView,"rotation",0f,360f);
//                float x=mTextView.getTranslationY();
//                ObjectAnimator animator=ObjectAnimator.ofFloat(mTextView,"translationY",x,-600f,x);
                ObjectAnimator moveIn=ObjectAnimator.ofFloat(mTextView,"translationX",-200f,0f);
                ObjectAnimator moveOut=ObjectAnimator.ofFloat(mTextView,"translationY",0f,-200f);
                ObjectAnimator moveInAgain=ObjectAnimator.ofFloat(mTextView,"translationY",-200f,0f);
                ObjectAnimator around=ObjectAnimator.ofFloat(mTextView,"rotation",0f,180f);
                ObjectAnimator alpha=ObjectAnimator.ofFloat(mTextView,"alpha",2f,0f,3f);
                ObjectAnimator animator=ObjectAnimator.ofFloat(mTextView,"scaleX",1f,3f,1f);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(moveInAgain).with(around).after(moveOut).with(animator).after(alpha);
                animatorSet.setDuration(6000);
                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(MainActivity.this,"动画开始",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(MainActivity.this,"动画结束",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Toast.makeText(MainActivity.this,"动画取消",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Toast.makeText(MainActivity.this,"动画Repeat",Toast.LENGTH_SHORT).show();
                    }
                });
                animatorSet.start();
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
