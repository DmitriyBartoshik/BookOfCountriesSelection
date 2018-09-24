package com.brothersoft.domain.entity.country;

import com.brothersoft.domain.entity.DomainModel;

public class Language implements DomainModel,Comparable<Language> {
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

    public void setIso639_1(String iso639_1) {
        this.iso639_1 = iso639_1;
    }

    public void setIso639_2(String iso639_2) {
        this.iso639_2 = iso639_2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    @Override
    public int compareTo(Language language) {
        return name.compareTo(language.getName());
    }
}
