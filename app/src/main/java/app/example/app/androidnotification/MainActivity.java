package app.example.app.androidnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public  void showNotification(View v){

         NotificationChannel nChannel;
         NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nChannel = new NotificationChannel("channelID", "myChannel", NotificationManager.IMPORTANCE_DEFAULT);
            nManager.createNotificationChannel(nChannel);
        }


        int nID = (int)(Math.random()* 5000+1);
        Intent showIntent = new Intent(MainActivity.this, NotifcationDetails.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        showIntent.putExtra("notification_id", nID);
        PendingIntent showPIntent = PendingIntent.getActivity(MainActivity.this, nID ,showIntent,0);


        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(MainActivity.this, "channelID");
        nBuilder.setSmallIcon(android.R.drawable.ic_menu_share);
        nBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.airtel));
        nBuilder.setContentTitle("New Message");
        nBuilder.setContentText("You have received one new notification pending..");
        nBuilder.setAutoCancel(false);
        nBuilder.setOngoing(true);
        nBuilder.addAction(0, "See Now", showPIntent);
        nBuilder.setContentIntent(showPIntent);

        nManager.notify(nID, nBuilder.build());
    }
}
