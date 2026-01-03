public class Solution
{
    public int[] SumOfDistancesInTree(int n, int[][] edges)
    {
        var graph = new List<int>[n];
        for (int i = 0; i < n; i++)
        {
            graph[i] = new List<int>();
        }
        
        foreach (var edge in edges)
        {
            int u = edge[0];
            int v = edge[1];
            graph[u].Add(v);
            graph[v].Add(u);
        }
        
        var subtreeSize = new int[n];
        var distanceSum = new int[n];
        
        void Dfs1(int node, int parent)
        {
            subtreeSize[node] = 1;
            foreach (var neighbor in graph[node])
            {
                if (neighbor == parent) continue;
                Dfs1(neighbor, node);
                subtreeSize[node] += subtreeSize[neighbor];
                distanceSum[node] += distanceSum[neighbor] + subtreeSize[neighbor];
            }
        }
        
        void Dfs2(int node, int parent)
        {
            foreach (var neighbor in graph[node])
            {
                if (neighbor == parent) continue;
                distanceSum[neighbor] = distanceSum[node] - subtreeSize[neighbor] + (n - subtreeSize[neighbor]);
                Dfs2(neighbor, node);
            }
        }
        
        Dfs1(0, -1);
        Dfs2(0, -1);
        
        return distanceSum;
    }
}