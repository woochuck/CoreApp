package com.luczak.m.coreapp.model;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

//@Table(database = Db.class)
public class Comment extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int idDb;

    @SerializedName("postId")
    @Column
    private int postId;

    @SerializedName("id")
    @Column
    private int id;

    @SerializedName("name")
    @Column
    private String name;

    @SerializedName("email")
    @Column
    private String email;

    @SerializedName("body")
    @Column
    private String body;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
