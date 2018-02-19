package com.vagapov.amir.parsersimpleinstruments;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


public class UserLoader {

    public static void loadUsers(Context context){
        Ion.with(context)
                .load("http://jsonplaceholder.typicode.com/users")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if(e != null) {
                            return;
                        }
                        ArrayList<User> users = new Gson()
                                .fromJson(result, new TypeToken<ArrayList<User>>() {}
                                .getType());
                        EventBusLoader eventBusLoader = new EventBusLoader(users);
                        EventBus.getDefault().post(eventBusLoader);
                    }
                });

    }
}
