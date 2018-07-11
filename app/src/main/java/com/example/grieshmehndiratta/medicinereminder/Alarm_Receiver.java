package com.example.grieshmehndiratta.medicinereminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;

public class Alarm_Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String get_your_string=intent.getExtras().getString("extra");

    /*    Intent services_intent=new Intent(context, RingtonePlayingServices.class);
        services_intent.putExtra("extra",get_your_string);
        context.startService(services_intent);
*/
    }
}
