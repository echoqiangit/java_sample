package com.sample.controlfilegenerator;

import java.util.Objects;

public class ItemType {
    private String memberId;
    private String fileName;

    public ItemType(String memberId, String fileName) {
        this.memberId = memberId;
        this.fileName = fileName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemType other = (ItemType) obj;
        if (!Objects.equals(this.memberId, other.memberId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return memberId + " : " + fileName;
    }

}
