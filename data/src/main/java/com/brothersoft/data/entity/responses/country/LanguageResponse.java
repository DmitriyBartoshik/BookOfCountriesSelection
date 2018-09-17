package com.brothersoft.data.entity.responses.country;

import com.brothersoft.data.entity.responses.DataModel;

public class LanguageResponse implements DataModel {
    private String iso639_1;
    private String iso639_2;
    private String name;
    private String nativeName;

    public String getIso639_1() {
        return iso639_1;
    }

    public String getIso639_2() {
        return iso639_2;
    }

    public String getName() {
        return name;
    }

    public String getNativeName() {
        return nativeName;
    }

}
