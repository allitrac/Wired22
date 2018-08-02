package afinal.thesis.com.wired22;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class SplashLoginActivity extends AppCompatActivity {

    private LinearLayout linlayLogin;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash_login);

//for animation
//        linlayLogin = findViewById(R.id.linLayLogin);
//        handler.postDelayed(runnable, 2000);
    }

//for animation
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            linlayLogin.setVisibility(View.VISIBLE);
//        }
//    };
}
