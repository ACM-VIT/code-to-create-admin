package acm.event.code2createadmin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        HomeFragment homeFragment = new HomeFragment();
        ft.replace(R.id.content, homeFragment);
        ft.commit();
    }

    public void loadScanner(boolean revert) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ScannerFragment scannerFragment = new ScannerFragment();
        scannerFragment.revert = revert;
        ft.replace(R.id.content, scannerFragment);
        ft.commit();
    }

    public void loadHome() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        HomeFragment homeFragment = new HomeFragment();
        ft.replace(R.id.content, homeFragment);
        ft.commit();
    }
}
