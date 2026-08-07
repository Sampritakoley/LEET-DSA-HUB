class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {

            String from = ticket.get(0);
            String to = ticket.get(1);

            graph
                .computeIfAbsent(from, k -> new PriorityQueue<>())
                .offer(to);
        }

        List<String> result = new ArrayList<>();

        dfs("JFK", graph, result);

        Collections.reverse(result);

        return result;
    }

    private void dfs(
            String airport,
            Map<String, PriorityQueue<String>> graph,
            List<String> result) {

        PriorityQueue<String> destinations =
                graph.get(airport);

        while (destinations != null &&
               !destinations.isEmpty()) {

            String next = destinations.poll();

            dfs(next, graph, result);
        }

        result.add(airport);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna