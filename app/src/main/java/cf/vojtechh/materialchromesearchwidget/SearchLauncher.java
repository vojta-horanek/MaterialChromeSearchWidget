package cf.vojtechh.materialchromesearchwidget;

import android.app.Activity;
import android.os.Bundle;

import java.io.DataOutputStream;
import java.io.IOException;

public class SearchLauncher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream outputStream = new DataOutputStream(su.getOutputStream());

            outputStream.writeBytes("am start -a android.intent.action.MAIN -n com.chrome.dev/org.chromium.chrome.browser.searchwidget.SearchActivity\n");
            outputStream.flush();
            finish();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
