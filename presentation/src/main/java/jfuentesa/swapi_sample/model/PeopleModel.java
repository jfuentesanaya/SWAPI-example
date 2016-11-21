package jfuentesa.swapi_sample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jfuentesa on 18/11/2016.
 */

public class PeopleModel implements Parcelable{

    private String name;
    private String height;
    private String gender;
    private List<String> filmsUrl;

    public PeopleModel() { }

    private PeopleModel(Parcel in) {
        setName(in.readString());
        setHeight(in.readString());
        setGender(in.readString());
//        setFilmsUrl(in.readStringList(getFilmsUrl()));
    }

    public static final Creator<PeopleModel> CREATOR = new Creator<PeopleModel>() {
        @Override
        public PeopleModel createFromParcel(Parcel in) {
            return new PeopleModel(in);
        }

        @Override
        public PeopleModel[] newArray(int size) {
            return new PeopleModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getHeight());
        parcel.writeString(getGender());
        parcel.writeStringList(getFilmsUrl());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getFilmsUrl() {
        return filmsUrl;
    }

    public void setFilmsUrl(List<String> filmsUrl) {
        this.filmsUrl = filmsUrl;
    }

}
