package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    public static void main(String args[]){
        Scanner objects = new Scanner(System.in);// Makes a Scanner of objects
        DoubleList<Song> songs = new DoubleList<>();// Makes a list
        PrintWriter lol = null;// Initilizes the printwrtier to 0

        System.out.println("*** Playlist Manager! ***");//Makes the heading
        System.out.println("Commands!!!");//Below are the commands you can use
        System.out.println("add");//Use to add songs and artist
        System.out.println("remove");//use to remove song and artist
        System.out.println("count");//use to print the total number of songs
        System.out.println("play");//use to print the list of songs
        System.out.println("shuffle");//use to shuffle the songs
        System.out.println("reverse");//use to reverse the songs
        System.out.println("Save");//use to save the songs to a file
        System.out.println("Load");//use to load the songs from the file
        System.out.println("quit");//use to quit the program
        System.out.print(":");
        String input;//use to input the name of the artist to remove
        String input2;// use to input the album of the artist to remove
        String input3;//use to input the name of the file you want to store your data in
        String read = objects.nextLine();//use to input data
        while(read != "quit" || read != "Quit"){//if read equals quit then the program stops otherwise continues.
            Song artist = new Song();//makes the song object to store data
            if(read.equals("add") || read.equals("Add")){// if read equals add then continues
                System.out.print("Enter artist: ");//prints enter artist
                String setname = objects.nextLine();//stores the artist
                artist.setArtist(setname);//sets the name of the artist
                System.out.print("Enter title: ");//prints to enter the title
                String settitle = objects.nextLine();//stores the title of the album
                artist.setTitle(settitle);//sets the title of the album
                songs.addEnd(artist);//adds to the end of the list
                System.out.print(":");//makes a colon
            }//end of if
            if(read.equals("remove") || read.equals("Remove")){//use to remove the artist and album from the list
                Song compare = new Song();//song object to compare data from the list
                System.out.print("Enter artist: ");//prints Enter artist
                input = objects.nextLine();//Stores the artist
                compare.setArtist(input);//sets the artist to compare object
                System.out.print("Enter title: ");//prints to enter the title
                input2 = objects.nextLine();//makes second input
                compare.setTitle(input2);//sets the title for the obect
                for(int i = 0; i < songs.total(); i++) {//make a loop to compare
                    if (songs.gets(i).getArtist().equals(compare.getArtist()) && songs.gets(i).getTitle().equals(compare.getTitle())) {//starts comparing
                        songs.remove(songs.gets(i));//removes if matches
                    }//end of if
                }//end of for
                System.out.print(":");//makes the wonder ful colon
            }//end of if
            if(read.equals("count") || read.equals("Count")){//makes another option
                System.out.print(songs.total());//gives you the size
                System.out.print(":");//makes the colon
            }//end of if
            if(read.equals("Play") || read.equals("play")){//makes option if wanted to play
                songs.print();//prints out the list of songs
                System.out.print(":");//makes colon
            }//end of if
            if(read.equals("Shuffle") || read.equals("shuffle")){//makes option to shuffle
                songs.shuffle(songs.total());//makes the shuffling with the size of parameter
                System.out.print(":");//makes colon
            }//end of if
            if(read.equals("Reverse") || read.equals("reverse")){//makes option to reverse
                songs.reverse();//makes the reverse
                System.out.print(":");//makes colon
            }//end of if

            if(read.equals("Save") || read.equals("save")) {//does a save
                System.out.print("Enter the file? ");//asks for the file name
                input3 = objects.next();//makes the input
                try {//tires using the file
                    lol = new PrintWriter(input3);//gives the printwriter the file to write as
                } catch (FileNotFoundException e) {//incase the file doens't work
                    e.printStackTrace();//prints the message if the paramenter for printwriter cannot be made into a file
                }//end of try and catch
                for(int i = 0; i < songs.total(); i++){//makes a loop to print the stuf
                    lol.println(songs.gets(i).getArtist());//prints artist
                    lol.println(songs.gets(i).getTitle());//prints music
                }//end of for loop
                System.out.print(":");//maeks colon
                lol.close();//closes file
            }//end of
            if(read.equals("Load") || read.equals("load")) {//makes an option to load
                System.out.print("Enter the file to load: ");//asks to enter file name to load
                String input4 = objects.next();//makes the thing
                try {//makes a try
                    File file = new File(input4);//makes file
                    Scanner scan = new Scanner(file);//makes scanner for the file
                    while(scan.hasNextLine()){//makes a loop to go through file
                        String artists = scan.nextLine();//get the name
                        String songss = scan.nextLine();//gets the songs
                        Song king = new Song();//makes a song object
                        king.setArtist(artists);//sets the name
                        king.setTitle(songss);//sets the tittle
                        songs.addEnd(king);//adds to the songs
                    }//end of while
                    System.out.print(":");//makes the colon
                } catch (FileNotFoundException e) {//if file not found catches the FILENOTFOUND EXCEPTION
                    System.out.println("file not found");//prints the message
                }//end of catch
            }//end of load

            read = "";//makes a empty read
            read = objects.nextLine();//sets the line
            if(read.equals("quit")){//makes the option to quit
                break;//breaks
            }//end of if

        }//end of while
    }//main

}//Main
