package StackQueue;


import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateStockSpan(prices);
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Span:   " + Arrays.toString(span));

        int[] prices2 = {10, 20, 30, 40, 50};
        int[] span2 = calculateStockSpan(prices2);
        System.out.println("Prices: " + Arrays.toString(prices2));
        System.out.println("Span:   " + Arrays.toString(span2));

        int[] prices3 = {50, 40, 30, 20, 10};
        int[] span3 = calculateStockSpan(prices3);
        System.out.println("Prices: " + Arrays.toString(prices3));
        System.out.println("Span:   " + Arrays.toString(span3));
    }
}

