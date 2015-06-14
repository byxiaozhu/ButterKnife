package com.zhuyongit.butterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.zhuyongit.butterknife.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

/**
 * Created by zhuyong < zhuyongit@163.com > on 2015/6/14.
 *
 * 使用注解框架来实现列表显示
 */
public class ListViewActivity extends AppCompatActivity {

    @InjectView(R.id.listView)
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);
        ButterKnife.inject(this);

        // 将数据填充到列表组件中
        listView.setAdapter(new ListAdapter(this,getInitDatas()));
    }

    /**
     * 准备列表数据源
     * @return
     */
    private List<String> getInitDatas() {

        List<String> datas = new ArrayList<String>() ;

        for (int i=0  ; i< 20 ; i++) {
            datas.add("准备列队，开始报数"+i);
        }

        return datas ;
    }

    /**
     * 列表item事件 , 参数可通过原生事件来设定
     * @param parent
     * @param position
     */
    @OnItemClick(R.id.listView)
    public void listOnItemClick(AdapterView<?> parent,int position) {
        String titleName = (String) parent.getItemAtPosition(position);
        Toast.makeText(this,"我是item事件==="+titleName,Toast.LENGTH_SHORT).show();
    }


}
