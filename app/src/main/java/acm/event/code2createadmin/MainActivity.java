package acm.event.code2createadmin;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.google.zxing.Result;

import butterknife.BindView;
import butterknife.OnClick;
import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    @BindView(R.id.options_radio_group)
    RadioGroup optionsRadioGroup;

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.scan_button)
    public void scan(View v) {
        startScan();
    }

    public void startScan(){
        scannerView = new ZXingScannerView(this) {
            @Override
            protected IViewFinder createViewFinderView(Context context) {
                ViewFinderView finderView = new ViewFinderView(context);
                finderView.setBorderColor(Color.TRANSPARENT);
                return finderView ;
            }
        };
        setContentView(scannerView);

        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        String encodedData[] = rawResult.getText().split(" ");
        String userId = encodedData[0];
        String type = encodedData[1].replaceAll("\n", "").toLowerCase();
        Log.e("message", userId + " " + type);

        setContentView(R.layout.activity_main);
    }
}
