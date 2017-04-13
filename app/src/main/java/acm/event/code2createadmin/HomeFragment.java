package acm.event.code2createadmin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends Fragment {
    private boolean revert = false;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @OnClick({ R.id.redeem_option, R.id.revert_option })
    public void onRadioButtonClicked(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();

        switch (radioButton.getId()) {
            case R.id.redeem_option:
                if (checked) {
                    revert = false;
                }
                break;
            case R.id.revert_option:
                if (checked) {
                    revert = true;
                }
                break;
        }
    }

    @OnClick(R.id.scan_button)
    public void scan(View v) {
        ((MainActivity)getActivity()).loadScanner(revert);
    }
}
