package org.games.library.model;

public class Game {

    private final String name, description, priceType, gameGenre;
    private final float price;
    private final int isChildFriendly;

    private Game(GameBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.gameGenre = builder.gameGenre;
        this.isChildFriendly = builder.isChildFriendly;
        if(this.price <= 10)
            this.priceType = "CHEAP";
        else if(this.price <= 30)
            this.priceType = "REGULAR";
        else
            this.priceType = "EXPENSIVE";
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getPriceType() {
        return priceType;
    }
    public String getGameGenre() {
        return gameGenre;
    }
    public float getPrice() {
        return price;
    }
    public int getIsChildFriendly() {
        return isChildFriendly;
    }


    public static class GameBuilder
    {
        private final String name, description;
        private final float price;
        private String gameGenre;
        private int isChildFriendly;

        public GameBuilder(String name, String description, float price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }
        public GameBuilder gameGenre(String gameGenre) {
            this.gameGenre = gameGenre;
            return this;
        }
        public GameBuilder isChildFriendly(int isChildFriendly) {
            this.isChildFriendly = isChildFriendly;
            return this;
        }
        public Game build() {
            return new Game(this);
        }
    }

}
