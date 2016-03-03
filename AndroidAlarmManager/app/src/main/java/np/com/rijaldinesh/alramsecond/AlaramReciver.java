package np.com.rijaldinesh.alramsecond;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;

public class AlaramReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context k1, Intent k2) {
        // TODO Auto-generated method stub


        //Toast.makeText(k1, "Alarm received!", Toast.LENGTH_LONG).show();

        Uri alarmUri = Uri.parse("android.resource://np.com.rijaldinesh.alramsecond/" + R.raw.sound);

        Ringtone ringtone = RingtoneManager.getRingtone(k1, alarmUri);
        AudioManager audioManager = (AudioManager) k1.getSystemService(Context.AUDIO_SERVICE);
        int volume = audioManager.getStreamVolume(AudioManager.STREAM_ALARM);
        if (volume == 0) {
            volume = audioManager.getStreamVolume(AudioManager.STREAM_ALARM);
        }

//        ringtone.setStreamType(AudioManager.STREAM_ALARM);
        //ringtone.play();
        if (ringtone != null) {
            ringtone.play();

        }
        Vibrator v = (Vibrator) k1.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(1000);

    }

}