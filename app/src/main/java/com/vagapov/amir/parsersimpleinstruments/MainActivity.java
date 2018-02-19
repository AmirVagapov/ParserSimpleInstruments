package com.vagapov.amir.parsersimpleinstruments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ArrayList<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EventBus.getDefault().register(this);

        users = Paper.book().read("users", new ArrayList<User>());

        UsersAdapter adapter = new UsersAdapter(users);
        recyclerView.setAdapter(adapter);

        UserLoader.loadUsers(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handler(EventBusLoader event){
        Paper.book().write("users", event.getEvent());
        users = event.getEvent();
    }
}
