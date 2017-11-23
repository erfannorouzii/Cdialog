package ir.northdesign.cdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.TextView;

public class CDialog extends Dialog {

    private TextView title;
    private TextView desc;
    private OnOKListener onOKListener;


    public CDialog(@NonNull Context context) {
        super(context);
        init();
    }

    public CDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init();
    }



    private void init(){
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_box);
       // getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setCancelable(false);
        title = findViewById(R.id.dialog_title);
        desc = findViewById(R.id.dialog_desc);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOKListener != null) {
                    onOKListener.onOK();
                }
                dismiss();
            }
        });

    }

    public CDialog setMessage(String message) {
        desc.setText(message);
        return this;
    }

    public CDialog setTitle(String t) {
        title.setText(t);
        return this;
    }

    public CDialog setOnOKListener(OnOKListener onOKListener) {
        this.onOKListener = onOKListener;
        return this;
    }

    public interface OnOKListener {
        void onOK();
    }

}
