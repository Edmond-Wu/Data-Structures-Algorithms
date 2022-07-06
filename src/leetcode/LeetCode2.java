package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LeetCode2 {

    /**
     * "Shuffles" an array, by returning the array in a randomly sorted order
     * @param arr array to be shuffled
     * @return a shuffled array
     */
    public static int[] shuffleArray(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for (int num : arr) {
            arrList.add(num);
        }
        int[] shuffled = new int[arr.length];
        Random rand = new Random();
        //randomly pick element from list, add it to shuffled, then remove from arrList
        int counter = 0;
        while (!arrList.isEmpty()) {
            int randomIndex = rand.nextInt(arrList.size());
            shuffled[counter] = arrList.get(randomIndex);
            counter++;
            arrList.remove(randomIndex);
        }
        return shuffled;
    }

    /**
     * Given a list of recipes, a list of ingredients for each recipe, and a list of currently available supplies, find all the recipes that can be made.
     * Assume that there is an infinite amount of supplies. Recipes can be used as ingredients for other recipes.
     * @param recipes list of recipes
     * @param ingredients list of ingredients for recipes; outer list size should be the same size as recipes
     * @param supplies list of starting supplies
     * @return a list of all recipes that can be made
     */
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> allRecipes = new ArrayList<>();
        //this can be treated as a topological sort problem, as recipes can be used as dependencies for other recipes
        //so we want to find all the recipes that can be made with the initial supplies, then use those to make the more complicated recipes
        //first store the supplies in a set for easy look-up
        Set<String> supplySet = new HashSet<>();
        Collections.addAll(supplySet, supplies);
        //for topological sorting, create an in-degree map
        Map<String, Integer> recipeInDegreeMap = new HashMap<>();
        //create another map that maps ingredients to recipes that require that ingredient
        Map<String, Set<String>> ingredientToRecipeMap = new HashMap<>();
        //go through the recipes to find any initial recipes we can make and establish the in-degree map
        for (int i = 0; i < recipes.length; i++) {
            //keep track of missing ingredients for the recipe; that is the in-degree
            int missingIngredients = 0;
            for (String ingredient : ingredients.get(i)) {
                //if the ingredient is not found in the set
                if (!supplySet.contains(ingredient)) {
                    //increment in-degree and update the ingredient to recipe map
                    missingIngredients++;
                    if (!ingredientToRecipeMap.containsKey(ingredient)) {
                        ingredientToRecipeMap.put(ingredient, new HashSet<>());
                    }
                    ingredientToRecipeMap.get(ingredient).add(recipes[i]);
                }
            }
            //if the in-degree is 0, then we can already make it from existing supplies
            if (missingIngredients == 0) {
                allRecipes.add(recipes[i]);
            }
            //otherwise we need to process it through topological sort later
            else {
                recipeInDegreeMap.put(recipes[i], missingIngredients);
            }
        }
        //now perform topological sort
        //start with the 0 in-degree recipes
        for (int j = 0; j < allRecipes.size(); j++) {
            String zeroDegRecipe = allRecipes.get(j);
            //check to see if that recipe is a dependency for any recipes in the ingredient to recipe map
            if (ingredientToRecipeMap.containsKey(zeroDegRecipe)) {
                //if so, then update the in-degrees
                for (String recipe : ingredientToRecipeMap.get(zeroDegRecipe)) {
                    if (recipeInDegreeMap.containsKey(recipe)) {
                        recipeInDegreeMap.put(recipe, recipeInDegreeMap.get(recipe) - 1);
                        //if the in-degree becomes 0, add it to the answer list
                        if (recipeInDegreeMap.get(recipe) == 0) {
                            allRecipes.add(recipe);
                        }
                    }
                }
            }
        }
        return allRecipes;
    }
}
