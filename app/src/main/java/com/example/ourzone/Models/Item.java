package com.example.ourzone.Models;

public class Item {
    String nameButtonText;

    int image;

    public String getNameButtonText() {
        return nameButtonText;
    }

    public void setNameButtonText(String nameButtonText) {
        this.nameButtonText = nameButtonText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public Item(String name,int image) {
        this.nameButtonText = name;
        this.image = image;
    }
}

//package com.example.ourzone.Models;
//
//public class item {
//    String name;
//
//
//
//    int image;
//
//    public item(String name,int image) {
//        this.name = name;
//        this.image = image;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
//}
