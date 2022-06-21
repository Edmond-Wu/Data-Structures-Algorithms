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
     * Counts the minimum number of swaps needed to group all the 1's together in an array of 1's and 0's
     * @param data an array of only 1's and 0's
     * @return minimum number of swaps to group all the 1's together
     */
    public static int minSwaps(int[] data) {
        //count number of 1's
        //that number is the size of the final group
        //find sub-array of that size in data that has the most amount of 1's
        int numOnes = 0;
        for (int num : data) {
            if (num == 1) {
                numOnes++;
            }
        }
        int maxNumOnesInSubArr = 0;
        int leftBound = 0;
        int rightBound = 0;
        int oneCount = 0;
        //track max # of 1's in every sub-array of size numOnes
        while (rightBound < data.length) {
            //increase the right side and update the oneCount; can just add directly since array
            //will only have 1's and 0's
            oneCount += data[rightBound];
            rightBound++;
            //if the rightBound - leftBound exceeds the sub-array size, move up the leftBound and remove the old value
            //from oneCount
            if (rightBound - leftBound > numOnes) {
                oneCount -= data[leftBound];
                leftBound++;
            }
            maxNumOnesInSubArr = Math.max(maxNumOnesInSubArr, oneCount);
        }
        //answer is the total # of 1's minus the max 1's in sub-array
        return numOnes - maxNumOnesInSubArr;
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

    /**
     * Given an array of integers, find the length of the longest strictly increasing subsequence
     * Subsequence is any sub-set of the array that maintains original order
     * @param nums array of integers
     * @return length of the longest increasing subsequence
     */
    public static int longestIncreasingSubsequence(int[] nums) {
        //base case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //build the sequence with a tree set
        TreeSet<Integer> subSet = new TreeSet<>();
        //by default, add the 1st element
        subSet.add(nums[0]);
        //iterate through nums from the 2nd element
        for (int i = 1; i < nums.length; i++) {
            //if nums[i] is greater than anything in the set, add it to the set
            if (nums[i] > subSet.last()) {
                subSet.add(nums[i]);
            }
            //otherwise replace the smallest element >= nums[i] with nums[i]
            else {
                subSet.remove(subSet.ceiling(nums[i]));
                subSet.add(nums[i]);
            }
        }
        //answer is the size of subSet
        return subSet.size();
    }

    /**
     * How far can we get through an array of buildings to climb given some ladders and bricks?
     * Ladders are a one-size-fits-all, each brick is 1 unit
     * Climbing a building can use a ladder that covers the entire climb or use bricks to cover the height difference
     * @param buildings array of heights of buildings
     * @param bricks number of bricks starting out with
     * @param ladders number of ladders starting out with
     * @return the index of the farthest building that can be made before running out of bricks/ladders
     */
    public static int bricksAndLadders(int[] buildings, int bricks, int ladders) {
        //use a min-heap to store the sizes that are used by ladders
        //we want to use ladders for the biggest climbs and bricks for the smallest
        //use ladders if available, otherwise replace the smallest ladder being used with bricks
        Queue<Integer> ladderHeap = new PriorityQueue<>();
        for (int i = 0; i < buildings.length - 1; i++) {
            int heightDiff = buildings[i + 1] - buildings[i];
            //only care about positive climbs as equal/negative climbs don't need bricks/ladders
            if (heightDiff > 0) {
                //use a ladder if available
                if (ladders > 0) {
                    ladders--;
                    ladderHeap.add(heightDiff);
                }
                else {
                    //if the heap is empty or the smallest ladder being used exceeds the current climb, use bricks
                    if (ladderHeap.isEmpty() || ladderHeap.peek() >= heightDiff) {
                        bricks -= heightDiff;
                    }
                    //replace the smallest ladder with bricks and use a ladder for the current climb
                    else {
                        bricks -= ladderHeap.poll();
                        ladderHeap.add(heightDiff);
                    }
                    //if bricks becomes negative we need to return
                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }
        //return the last building if the loop didn't prematurely exit
        return buildings.length - 1;
    }
}
