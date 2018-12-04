package app.example.app.androidnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NotifcationDetails extends AppCompatActivity {

    int notificaitonID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifcation_details);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
           notificaitonID = bundle.getInt("notification_id");
        }

        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText("Notifiction ID: "+notificaitonID);


        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notificaitonID);

    }
}
