package jfuentesa.swapi_sample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.jfuentes.swapi_sample.People;

/**
 * Created by jfuentesa on 18/11/2016.
 */

public class PeopleModel extends People implements Parcelable{

    public PeopleModel() { }

    private PeopleModel(Parcel in) {
        setName(in.readString());
        setHeight(in.readString());
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

    }
}
