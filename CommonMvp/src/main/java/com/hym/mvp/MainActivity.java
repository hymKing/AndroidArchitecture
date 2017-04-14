package com.hym.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowDataActivity.class);
                startActivity(intent);
            }
        });
        Log.e("position",getViewHierarchyPosition(btn)+"");
        //getViewHierarchyPosition(btn);
    }

    /**
     * 获取一个view在当前布局中属于哪个层级
     * @param view
     * @return
     */
    public int getViewHierarchyPosition(View view){
        ViewParent parent =view.getParent();
        for(int i=0;;i++){
            parent=parent.getParent();
            if(parent==null){
                return i;
            }
        }
    }
}
