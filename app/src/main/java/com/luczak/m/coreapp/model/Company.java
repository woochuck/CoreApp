package com.luczak.m.coreapp.model;

import com.google.gson.annotations.SerializedName;

public class Company {
    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;
}
