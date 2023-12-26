package com.giobyte8.psalgo.gtci.two_heaps;

import com.giobyte8.psalgo.collections.PriorityQueue;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://www.educative.io/courses/grokking-coding-interview-patterns-java/maximize-capital">
 *     Source
 * </a>
 */
public class MaximizeCapital {

    private record InvProject(int capital, int profit) { }

    public static int maxCapitalTwoHeaps(int c, int k, int[] capitals, int[] profits) {

        // Sort all projects by capital (asc order)
        PriorityQueue<InvProject> caps = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.capital)
        );
        for (int i = 0; i < capitals.length; i++) {
            InvProject invProj = new InvProject(capitals[i], profits[i]);
            caps.add(invProj);
        }

        int maxCap = c;
        for (int i = 0; i < k; i++) {

            // Pick up projects in range of curr cap
            PriorityQueue<InvProject> profs = new PriorityQueue<>(
                    Comparator.comparingInt((InvProject p) -> p.profit).reversed()
            );
            while (!caps.isEmpty() && maxCap >= caps.peek().capital) {
                profs.add(caps.poll());
            }

            // No project can be picked up
            if (profs.isEmpty()) break;

            // Pick up highest profit project and put others back into 'caps'
            maxCap += profs.poll().profit;
            while (!profs.isEmpty()) {
                caps.add(profs.poll());
            }
        }

        return maxCap;
    }

    public static int maxCapitalSingleHeap(int c, int k, int[] capitals, int[] profits) {

        // Sort projects by profit (Descending order)
        PriorityQueue<InvProject> profs = new PriorityQueue<>(
                Comparator.comparingInt((InvProject p) -> p.profit).reversed()
        );
        for (int i = 0; i < capitals.length; i++) {
            InvProject invProj = new InvProject(capitals[i], profits[i]);
            profs.add(invProj);
        }

        int currCapital = c;
        for (int i = 0; i < k; i++) {

            // Pick up highest profit project in range of curr cap
            Set<InvProject> unaffordableProjects = new HashSet<>();
            while (!profs.isEmpty() && profs.peek().capital > currCapital) {
                unaffordableProjects.add(profs.poll());
            }

            currCapital += profs.poll().profit;

            // Put projects back into available options
            unaffordableProjects.forEach(profs::add);
        }

        return currCapital;
    }
}
