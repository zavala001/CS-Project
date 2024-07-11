import java.util.ArrayList;
import java.util.List;
class Recipemanager {
    private List<Recipes> recipes1 = new ArrayList<>();

    public void addRecipes(Recipes recipes) {recipes1.add(recipes);}

    void addsampleRecipes() {

        // Add some sample recipes for demonstration
        addRecipes(new Recipes("Pasta", "Delicious pasta with tomato sauce", "Pasta, Tomato Sauce", "30 mins", "Boil pasta, add sauce", "200 calories"));
        addRecipes(new Recipes("Salad", "Fresh garden salad", "Lettuce, Tomato, Cucumber", "10 mins", "Chop ingredients, mix", "100 calories"));
        addRecipes(new Recipes("Omelette", "Fluffy omelette with cheese", "Eggs, Cheese, Milk", "15 mins", "Whisk eggs, cook in pan, add cheese", "150 calories"));
        addRecipes(new Recipes("Chicken Curry", "Spicy chicken curry with rice", "Chicken, Curry Paste, Coconut Milk, Rice", "45 mins", "Cook chicken, add curry paste, add coconut milk, serve with rice", "400 calories"));
        addRecipes(new Recipes("Grilled Cheese Sandwich", "Crispy grilled cheese sandwich", "Bread, Butter, Cheese", "10 mins", "Butter bread, place cheese between slices, grill until golden brown", "300 calories"));
        addRecipes(new Recipes("Chocolate Cake", "Rich chocolate cake", "Flour, Sugar, Cocoa Powder, Eggs, Butter, Baking Powder", "1 hr", "Mix ingredients, bake at 350F for 30 mins", "500 calories per slice"));
        addRecipes(new Recipes("Fruit Smoothie", "Refreshing fruit smoothie", "Banana, Berries, Yogurt, Honey, Ice", "5 mins", "Blend all ingredients until smooth", "150 calories"));
        addRecipes(new Recipes("Tacos", "Tasty beef tacos", "Ground Beef, Taco Seasoning, Tortillas, Lettuce, Tomato, Cheese", "25 mins", "Cook beef with seasoning, assemble tacos with toppings", "250 calories per taco"));
        addRecipes(new Recipes("Pancakes", "Fluffy pancakes", "Flour, Milk, Eggs, Sugar, Baking Powder", "20 mins", "Mix ingredients, cook on griddle until bubbles form, flip and cook until golden brown", "200 calories per pancake"));
        addRecipes(new Recipes("Caesar Salad", "Classic Caesar salad", "Romaine Lettuce, Caesar Dressing, Croutons, Parmesan Cheese", "15 mins", "Toss lettuce with dressing, add croutons and cheese", "200 calories"));

    }

    public void editRecipe(int index, String name, String description, String ingredients, String preptime, String directions, String nutritionfacts) {
        Recipes recipes = recipes1.get(index);
        recipes.setName(name);
        recipes.setDescription(description);
        recipes.setIngredients(ingredients);
        recipes.setpreptime(preptime);
        recipes.setdirections(directions);
        recipes.setnutritionfacts(nutritionfacts);
    }

    public void deleteRecipe(int index) {
        recipes1.remove(index);
    }

    public void listRecipes() {
        for (int i = 0; i < recipes1.size(); i++) {
            Recipes recipes = recipes1.get(i);
            System.out.println(i + ". " + recipes.getName() + ": " + recipes.getDescription());

        }
    }

    public Recipes searchRecipes(String name) {
        for (Recipes recipe : recipes1) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                return recipe;
            }
        }
        return null; // Return null if no recipe is found
    }
}
