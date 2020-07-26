package com.nitendratech.ec.domain;


/**
 * Enumeration for the State of California
 */

public enum Region {

    Central_Coast("Central Coast"), Southern_California("Southern California"),
    Northern_California("Northern California"), Varies("Varies");

    private String label;

    private Region(String label){
        this.label = label;
    }

    private static Region findByLabel(String byLabel){
        for(Region r: Region.values()){
            if(r.label.equalsIgnoreCase(byLabel)) return r;
        }
        return null;
    }



}
