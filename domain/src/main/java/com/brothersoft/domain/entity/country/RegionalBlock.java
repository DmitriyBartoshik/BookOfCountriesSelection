package com.brothersoft.domain.entity.country;

import com.brothersoft.domain.entity.DomainModel;

import java.util.List;

public class RegionalBlock implements DomainModel, Comparable<RegionalBlock> {
    private String acronym;
    private String name;
    private List<String> otherAcronyms;
    private List<String> otherNames;

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public List<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    @Override
    public int compareTo(RegionalBlock regionalBlock) {
        return name.compareTo(regionalBlock.getName());
    }
}
