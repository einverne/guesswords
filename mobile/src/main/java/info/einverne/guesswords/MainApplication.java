package info.einverne.guesswords;

import android.app.Application;

import info.einverne.guesswords.log.ReleaseTree;
import timber.log.Timber;

/**
 * Created by einverne on 8/21/16.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree(){
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return super.createStackElementTag(element) + ":" + element.getLineNumber();
                }
            });
        } else {
            Timber.plant(new ReleaseTree());
        }
    }
}
