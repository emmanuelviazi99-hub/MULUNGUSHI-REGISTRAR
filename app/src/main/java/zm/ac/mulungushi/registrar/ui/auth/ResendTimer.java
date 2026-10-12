package zm.ac.mulungushi.registrar.ui.auth;

import android.os.CountDownTimer;

/** The 30 second wait before "Resend code" turns on. */
public final class ResendTimer {

    public interface Listener {
        void onTick(int secondsLeft);

        void onFinish();
    }

    private CountDownTimer timer;

    public void start(int seconds, Listener listener) {
        cancel();
        if (seconds <= 0) {
            listener.onFinish();
            return;
        }
        listener.onTick(seconds);
        timer = new CountDownTimer(seconds * 1000L, 1000L) {
            @Override
            public void onTick(long millisLeft) {
                listener.onTick((int) Math.ceil(millisLeft / 1000.0));
            }

            @Override
            public void onFinish() {
                listener.onFinish();
            }
        }.start();
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    /** 27 becomes "0:27". */
    public static String clock(int seconds) {
        return (seconds / 60) + ":" + (seconds % 60 < 10 ? "0" : "") + (seconds % 60);
    }
}
