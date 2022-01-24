package com.company;

class Song {
    private String artist;
    private String title;

    Song(){
        this.artist = "";
        this.title = "";
    }//end of song


    public void setArtist(String name){//set name
        this.artist = name;
    }//end of set Artist

    public void setTitle(String header){//sets title
        this.title = header;
    }//end of set tittle

    public String getArtist() {//gets the name
        return artist;
    }//end of get artist

    public String getTitle() {//get the title
        return title;
    }//end of get title

    public String toString(){//the toString
        return String.format(artist + " - " + title);
    }//end of tostring
}
