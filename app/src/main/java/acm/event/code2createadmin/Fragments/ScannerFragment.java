package acm.event.code2createadmin.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

import acm.event.code2createadmin.Main.MainActivity;
import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerFragment extends Fragment implements ZXingScannerView.ResultHandler{
    private ZXingScannerView scannerView;
    private String adminId = "VinitSourish#12";
    public boolean revert = false;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(getActivity());
        scannerView = new ZXingScannerView(this.getActivity()) {
            @Override
            protected IViewFinder createViewFinderView(Context context) {
                ViewFinderView finderView = new ViewFinderView(context);
                finderView.setBorderColor(Color.TRANSPARENT);
                return finderView ;
            }
        };
        List<BarcodeFormat> formats = new ArrayList<>();
        formats.add(BarcodeFormat.QR_CODE);
        scannerView.setFormats(formats);
        return scannerView;
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void handleResult(Result rawResult) {
        String encodedData[] = rawResult.getText().split(" ");
        String userId = encodedData[0];
        String type = encodedData[1].replaceAll("\n", "").toLowerCase();
        Log.e("message", revert + " " + userId + " " + type);

        ((MainActivity)getActivity()).loadHome();
    }
}
