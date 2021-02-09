package com.example.condortest.data.model.detail;

public class TeamDetail {

    private String strTeam;
    private String strDescriptionEN;
    private int intFormedYear;
    private String strTeamBadge;
    private String strTeamJersey;
    private String strWebsite;
    private String strFacebook;
    private String strTwitter;
    private String strInstagram;

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public int getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(int intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    @Override
    public String toString() {
        return "TeamDetail{" +
                "strTeam='" + strTeam + '\'' +
                ", strDescriptionEN='" + strDescriptionEN + '\'' +
                ", intFormedYear=" + intFormedYear +
                ", strTeamBadge='" + strTeamBadge + '\'' +
                ", strTeamJersey='" + strTeamJersey + '\'' +
                ", strWebsite='" + strWebsite + '\'' +
                ", strFacebook='" + strFacebook + '\'' +
                ", strTwitter='" + strTwitter + '\'' +
                ", strInstagram='" + strInstagram + '\'' +
                '}';
    }
}
