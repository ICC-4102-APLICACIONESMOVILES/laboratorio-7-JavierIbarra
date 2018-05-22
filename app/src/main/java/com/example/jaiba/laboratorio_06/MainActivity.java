package com.example.jaiba.laboratorio_06;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int mId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAlert();
    }

    public void startAlert() {
        Intent intent = new Intent(this, MyPhoneReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (10 * 1000), pendingIntent);
        Toast.makeText(this,"Alarma",Toast.LENGTH_SHORT).show();
        //Notificacion();
    }

    public void Notificacion(){
        NotificationCompat.Builder mBuider = new NotificationCompat.Builder(this,"")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Alarma")
                .setContentText("Revise la aplicacion");

        NotificationManager mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId,mBuider.build());
    }
}
