package com.zhuyongit.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * 使用注解框架 ， 通过注解来获取控件对象和监听组件事件
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 注册butterKnife 注解框架
        ButterKnife.inject(this);
    }

    @OnClick(R.id.tvClick)
    public void showTvClick() {
        Toast.makeText(this,"是否好用，但是电脑真的好卡。。。",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnStartListActivity)
    public void startLisActivity() {
        startActivity(new Intent(this,ListViewActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
