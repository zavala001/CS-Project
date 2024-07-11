import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    private static UserManager userManager = new UserManager();
    private static Recipemanager recipemanager = new Recipemanager();
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to Dish delights, the Recipe Manager app!!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option [Register, Login, Exit]: ");
            String option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "register":
                    register();
                    break;
                case "login":
                    login();
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userManager.registerUser(username, password);
        System.out.println("User registered successfully!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userManager.loginUser(username, password);
        if (user != null) {
            currentUser = user;
            System.out.println("Login successful!");
            home();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void home() {
        int choice;
        do {
            System.out.println();
            System.out.println("\nHome");
            System.out.println("1. View Profile");
            System.out.println("2. Search Bar");
            System.out.println("3. Manage Recipes");
            System.out.println("4. Log out");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    searchRecipes();
                    break;
                case 3:
                    manageRecipess();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    currentUser = null;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void viewProfile() {
        System.out.println("\nProfile");
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Password: " + currentUser.getPassword());
    }

    private static void manageRecipess() {
        int choice;
        do {

            System.out.println("\nManage Recipes");
            System.out.println("1. Create Recipe");
            System.out.println("2. Edit Recipe");
            System.out.println("3. Delete Recipe");
            System.out.println("4. List recipes");
            System.out.println("5. View other recipes");
            System.out.println("6. Go back");
            System.out.println("7. Search bar");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createRecipe();
                    break;
                case 2:
                    editRecipe();
                    break;
                case 3:
                    deleteRecipe();
                    break;
                case 4:
                    listRecipe();
                    break;
                case 5:
                    sampleRecipe();
                    listRecipe();
                    break;
                case 6:
                    System.out.println("Returning back...");
                    break;
                case 7:
                    searchRecipes();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

    }

    private static void createRecipe() {
        System.out.println("\nCreating your Recipes");
        System.out.println("1. Desserts ");
        System.out.println("2. Snacks ");
        System.out.println("3. Main dishes");
        System.out.println("4. Drinks ");
        System.out.println("5. Sandwiches ");

        System.out.print("Choose recipe type [Desserts, Snacks, Main dishes, Drinks, Sandwiches]: ");
        String recipe1Type = scanner.nextLine().toLowerCase();

        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();

        System.out.print("Enter recipe description: ");
        String description = scanner.nextLine();

        System.out.print("Enter recipe ingredients: ");
        String ingredients = scanner.nextLine();

        System.out.print("Enter recipe preptime: ");
        String preptime = scanner.nextLine();

        System.out.print("Enter recipe directions: ");
        String directions = scanner.nextLine();

        System.out.print("Enter nutrition facts: ");
        String nutritionfacts = scanner.nextLine();

        Recipes recipes;

        if (recipe1Type.equals("desserts")) {
            recipes = new Desserts(name, description, ingredients, preptime, directions, nutritionfacts);
        } else if (recipe1Type.equals("snacks")) {
            recipes = new Snacks(name, description, ingredients, preptime, directions, nutritionfacts);
        } else if (recipe1Type.equals("main dishes")) {
            recipes = new Maindishes(name, description, ingredients, preptime, directions, nutritionfacts);
        } else if (recipe1Type.equals("drinks")) {
            recipes = new Drinks(name, description, ingredients, preptime, directions, nutritionfacts);
        } else if (recipe1Type.equals("sandwiches")) {
            recipes = new Sandwiches(name, description, ingredients, preptime, directions, nutritionfacts);
        } else {
            System.out.println("Invalid recipe type. Please try again.");
            return;
        }

        recipemanager.addRecipes(recipes);
        System.out.println("Recipe created successfully!");

    }

    private static void editRecipe() {
        listRecipe();
        System.out.print("Enter the index of the recipe to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new recipe name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new recipe description: ");
        String description = scanner.nextLine();

        System.out.print("Enter new recipe ingredients: ");
        String ingredients = scanner.nextLine();

        System.out.print("Enter new recipe preptime: ");
        String preptime = scanner.nextLine();

        System.out.print("Enter new recipe directions: ");
        String directions = scanner.nextLine();

        System.out.print("Enter new recipe nutrition facts: ");
        String nutritionfacts = scanner.nextLine();


        recipemanager.editRecipe(index, name, description, ingredients, preptime, directions, nutritionfacts);
        System.out.println("Recipe edited successfully!");
    }

    private static void deleteRecipe() {
        listRecipe();
        System.out.print("Enter the index of the recipe to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        recipemanager.deleteRecipe(index);
        System.out.println("Recipe deleted successfully!");
    }

    private static void listRecipe() {
        recipemanager.listRecipes();
    }

    private static void sampleRecipe() {
        recipemanager.addsampleRecipes();

    }

    private static void searchRecipes() {
        System.out.print("Enter the recipe name to search: ");
        String name = scanner.nextLine();
        Recipes recipe = recipemanager.searchRecipes(name);
        if (recipe != null) {
            System.out.println(recipe);
        } else {
            System.out.println("Recipe not found.");
        }
    }
}
