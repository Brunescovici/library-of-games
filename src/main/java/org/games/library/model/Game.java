package org.games.library.model;

import java.util.Date;

public class Game {
    private long id;
    private String name, description, priceType, gameGenre;
    private float price;
    private boolean isChildFriendly;
    private Date creationDate, updateDate;

//    Game(long id, String name, String description, float price, String priceType, String gameGenre, boolean isChildFriendly, LocalDateTime creationDate, LocalDateTime updateDate) {
//        setID(id);
//        setName(name);
//        setDescription(description);
//        setPrice(price);
//        setPriceType(priceType);
//        setGameGenre(gameGenre);
//        setChildFriendly(isChildFriendly);
//        setCreationDate(creationDate);
//        setUpdateDate(updateDate);
//    }

    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPriceType() {
        return this.priceType;
    }

    public String getGameGenre() {
        return this.gameGenre;
    }

    public float getPrice() {
        return this.price;
    }

    public String getChildFriendly() {
        if (isChildFriendly)
            return "Yes";
        else
            return "No";
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setID(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setChildFriendly(boolean isChildFriendly) {
        this.isChildFriendly = isChildFriendly;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setUpdateDate(Date date) {
        this.updateDate = date;
    }
}
