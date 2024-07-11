class Recipes {
    private String name;
    private String description;
    private String ingredients;
    private String preptime;
    private String directions;
    private String nutritionfacts;
    public Recipes(String name, String description, String ingredients, String preptime, String directions, String nutritionfacts) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.preptime = preptime;
        this.directions = directions;
        this.nutritionfacts = nutritionfacts;

    }
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {return description;}
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIngredients() {return ingredients;}
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getpreptime() {return preptime;}
    public void setpreptime(String preptime) {
        this.preptime= preptime;
    }
    public String getdirections() {return directions;}
    public void setdirections(String directions) {
        this.directions= directions;
    }
    public String getnutritionfacts() {return nutritionfacts;}
    public void setnutritionfacts(String nutritionfacts) {
        this.nutritionfacts= nutritionfacts;
    }

}
