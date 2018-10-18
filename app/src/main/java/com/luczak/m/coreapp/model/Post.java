package com.luczak.m.coreapp.model;

import com.google.gson.annotations.SerializedName;
import com.luczak.m.coreapp.database.Db;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = Db.class)
public class Post extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    int idDb;

    @Column
    @SerializedName("userId")
    int userId;
    @Column
    @SerializedName("id")
    int id;
    @Column
    @SerializedName("title")
    String title;
    @Column
    @SerializedName("body")
    String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
