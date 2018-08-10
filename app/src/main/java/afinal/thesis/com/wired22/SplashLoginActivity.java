package afinal.thesis.com.wired22;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class SplashLoginActivity extends AppCompatActivity {

    private LinearLayout linlayLoginBox;
    private ImageView ivWiredLogo, ivBackgroundOne;
    private Button btnLogin;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_login);

//for animation
        ivWiredLogo = findViewById(R.id.ivWiredLogo);
        ivBackgroundOne = findViewById(R.id.ivBackgroundOne);
        linlayLoginBox = findViewById(R.id.linLayLogin);
        handler.postDelayed(runnable, 1000);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SplashLoginActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.room_spinner_layout, null);
                mBuilder.setIcon(R.drawable.pic_logo_wired_colored);
                Spinner mSpinner = mView.findViewById(R.id.roomSpinner);
                ArrayAdapter<String> roomAdapter = new ArrayAdapter<String>(SplashLoginActivity.this, android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.Rooms));
                roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(roomAdapter);

                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        dialogInterface.dismiss();
                        Intent toMainDashboard = new Intent(SplashLoginActivity.this, MainDashboardActivity.class);
                        startActivity(toMainDashboard);
                    }
                });

                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }


//for animation
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ivWiredLogo.setVisibility(View.GONE);
            linlayLoginBox.setVisibility(View.VISIBLE);
            ivBackgroundOne.setVisibility(View.GONE);
        }
    };
}
